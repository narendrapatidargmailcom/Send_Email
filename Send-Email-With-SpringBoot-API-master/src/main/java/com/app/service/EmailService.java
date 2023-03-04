package com.app.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
    private JavaMailSender javaMailSender;
	
  public void sendEmailWithAttachment(String email) throws MessagingException, IOException {

	       MimeMessage msg = javaMailSender.createMimeMessage();

	       // true = multipart message
	       MimeMessageHelper helper = new MimeMessageHelper(msg, true);
	       helper.setTo(email);

	       helper.setSubject("send Email");
	       
	       //msg.setText(text, charset, subtype);
	      

	       
	       helper.setText("Hi Prince I am going to send email to you", true);

	      // helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

	       javaMailSender.send(msg);

	   }


}
