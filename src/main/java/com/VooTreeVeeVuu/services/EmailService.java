package com.VooTreeVeeVuu.services;

import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;

	public EmailService (JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendOTP (String email, String otp) {
		MimeMessage message = mailSender.createMimeMessage();
		try
		{
			message.setFrom("dhuyclone2001@gmail.com");
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("FORGOT PASSWORD OTP");
			message.setText("Your OTP code: " + otp);
			mailSender.send(message);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
