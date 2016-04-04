package com.cafe.service.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.Map;

public class EmailListener implements MessageListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailNotificationService.class);

	private boolean isConfigAvailable;

	@Autowired
    private JavaMailSenderImpl mailSender;

	@Autowired
    private ServletContext servletContext;

	public void onMessage(Message message) {

		try{
			ByteArrayInputStream byteIn = new ByteArrayInputStream(message.getBody());
		    ObjectInputStream in = new ObjectInputStream(byteIn);
			Map<String,Object> params =  (Map<String,Object>)in.readObject();
			final String to = (String) params.get("to");
			final String from = (String) params.get("from");
			final String subject = (String) params.get("subject");
			final String body = (String) params.get("body");
			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				@SuppressWarnings({ "rawtypes", "unchecked" })
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
					message.setTo(to);
					message.setFrom(from);
					message.setSubject(subject);
					message.setSentDate(new Date());
					message.setText(body, true);
				}
			};
			//if(isConfigAvailable){
				mailSender.send(preparator);
			//}else{
				LOGGER.debug("Mail configuration is not set properly");
			//}
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
