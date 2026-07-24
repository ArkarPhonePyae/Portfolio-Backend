package com.demo.portfolio.entity;

import lombok.Data;

@Data
public class ContactMessage {
    private String name;
    private String email;
    private String subject;
    private String message;
}
