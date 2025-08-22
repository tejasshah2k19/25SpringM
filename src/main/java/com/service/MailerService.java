package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailerService {

	@Autowired
	JavaMailSender mailSender;

	public void sendWelcomeMail(String firstName, String email) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);
		msg.setSubject("Welcome to CampusCare");
		msg.setText("We are happy to help you. please take a look in app.");
		mailSender.send(msg);
	}
}
