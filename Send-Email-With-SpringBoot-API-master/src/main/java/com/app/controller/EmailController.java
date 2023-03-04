package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Email;
import com.app.service.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	EmailService service;
	
	@PostMapping("/send")
	public String sendEmail(@RequestBody Email tempEmail) {
		
		try {
			System.out.println("send email......................");
			service.sendEmailWithAttachment(tempEmail.getEmail());
			System.out.println("Done");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return "Email Successfully send";
		
	}

}
