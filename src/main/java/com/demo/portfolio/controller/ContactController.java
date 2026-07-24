package com.demo.portfolio.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.portfolio.entity.ContactMessage;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {

    private final JavaMailSender mailSender;

    @PostMapping
    public ResponseEntity<Map<String, String>> sendEmail(@RequestBody ContactMessage contact) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("arkarphonepyae58@gmail.com");
        message.setReplyTo(contact.getEmail());
        message.setSubject("Portfolio Message: " + contact.getSubject());
        message.setText("From: " + contact.getName() + 
        		" (" + contact.getEmail() + ")\n\n" +
        		contact.getMessage()
        		);
        mailSender.send(message);
        
        Map<String, String> response = new HashMap<>();
        response.put("message", "Message sent successfully!");
        return ResponseEntity.ok(response); 
    }
}