package com.cafe.service.mail;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.MessagePostProcessor;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class JmsMessageSender {

    private JmsTemplate jmsTemplate;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    /**
     * send text to default destination
     *
     * @param text
     */
    public void send(final String text) {

        this.jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                Message message = session.createTextMessage(text);
                return message;
            }

        });
    }

    /**
     * Simplify the send by using convertAndSend
     *
     * @param text
     */
    public void sendText(final String text) {
        this.jmsTemplate.convertAndSend(text);
    }

    /**
     * Send text message to a specified destination
     *
     * @param text
     */
    public void send(final Destination dest, final Object obj) {
        jmsTemplate.convertAndSend(dest, obj, new MessagePostProcessor() {
            public Message postProcessMessage(Message message) throws JMSException {
                message.setObjectProperty("mailObject", obj);
                return message;
            }
        });
    }
}