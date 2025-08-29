package com.service;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailerService {

	@Autowired
	JavaMailSender mailSender;

	public void sendWelcomeMail(String firstName, String email) {
//		SimpleMailMessage msg = new SimpleMailMessage();
//		msg.setTo(email);
//		msg.setSubject("Welcome to CampusCare");
//		msg.setText("We are happy to help you. please take a look in app.");
//		mailSender.send(msg);

		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setTo(email);
			helper.setSubject("🎉 Welcome to CampusCare!");

			ClassPathResource resource = new ClassPathResource("templates/welcome.html");
			
			String template = Files.readString(resource.getFile().toPath(), StandardCharsets.UTF_8);
		
			template  = template.replace("{{name}}", firstName);	
			helper.setText(template, true);

			mailSender.send(message);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
