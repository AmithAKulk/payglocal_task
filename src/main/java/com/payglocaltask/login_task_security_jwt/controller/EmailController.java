package com.payglocaltask.login_task_security_jwt.controller;

import com.payglocaltask.login_task_security_jwt.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/send-email")
    public String sendEmail() {
        // replace with your email details
        String to = "amith.kulkarni.54@gmail.com";
        String subject = "Test Email";
        String text = "This is a test email.";

        emailService.sendEmail(to, subject, text);

        return "Email sent successfully!";
    }
}