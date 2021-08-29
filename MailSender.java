package com.xworkz.vaccine.utility;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
@Component
public class MailSender {
	@Autowired
	private JavaMailSender javaMailSender;

	private Logger logger = Logger.getLogger(MailSender.class);

	public void sendMail(String to, String subject, String text) {
		try {
			logger.info("Sending mail to " + to);
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(to);
			mailMessage.setSubject(subject);
			mailMessage.setText(text);
			javaMailSender.send(mailMessage);
			logger.info("Mail sent to " + to);
		} catch (Exception e) {
			logger.error("You have exception in {} " + e.getMessage());
		}

	}
}
