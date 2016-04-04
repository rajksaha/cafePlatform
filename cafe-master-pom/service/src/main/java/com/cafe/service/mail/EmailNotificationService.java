package com.cafe.service.mail;


import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.Map;

public class EmailNotificationService implements IEmailNotificationService {
	// https://keyholesoftware.com/2013/04/01/rabbitmq-with-spring-tutorial/
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailNotificationService.class);
	private static final String MAIL_FROM = "test@test.com";

	@Autowired
	private VelocityEngine velocityEngine;

	@Autowired
	private ServletContext servletContext;

	@Autowired
	AmqpTemplate amqpTemplate;

	@Autowired
	RabbitTemplate rabbitTemplate;


	public void sendForgetPasswordEmail() {
		Map<String,Object> model = new HashMap<String,Object>();

		String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "com/cafe/web/mailtemplate/forgetpassword.vm", "UTF-8", model);

		try {
			String adminEmail = "";
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("from", MAIL_FROM);
			params.put("subject", "Forget Password Request");
			params.put("to", adminEmail);
			params.put("body", text);

			amqpTemplate.convertAndSend("fams.reset.password", params);
		} catch (Exception e) {
			LOGGER.error("Error while getting admin email during forget password email : " + e.getMessage());
		}

	}

	public void sendResetPasswordEmail() {
		Map<String,Object> model = new HashMap<String,Object>();

		String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "com/cafe/web/mailtemplate/resetpassword.vm", "UTF-8", model);

		try {
			String adminEmail = "";
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("from", MAIL_FROM);
			params.put("subject", "Reset Password Email");
			params.put("to", adminEmail);
			params.put("body", text);

			amqpTemplate.convertAndSend("fams.reset.password", params);
		} catch (Exception e) {
			LOGGER.error("Error while getting admin email during forget password email : " + e.getMessage());
		}

	}


}
