package com.rr.util;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
@Component
public class emailUtiliti {
	@Autowired
	private JavaMailSender mailSender;
	public void sendEmail(String to,String sub,String body) {
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo(to);
		msg.setSubject(sub);
		msg.setText(body);
		mailSender.send(msg);
	}
	
}