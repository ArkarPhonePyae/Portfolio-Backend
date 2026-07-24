package com.demo.portfolio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "blogs")
@Data
@NoArgsConstructor 
@AllArgsConstructor 
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private LocalDate publicationDate;

    @Lob
    @Column(nullable = false, length = 10000)
    private String description; 
    
    @Lob
    @Column(columnDefinition = "TEXT")
    private String content; 

    private int readTimeMinutes;
}