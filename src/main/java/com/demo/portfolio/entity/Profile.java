package com.demo.portfolio.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id
    private Long id; 

    private String name;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String bio;
    private String githubUrl;
    private String linkedinUrl;
    private String email;
    
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.EAGER) // LAZY အစား EAGER သုံးကြည့်ပါ
    @JsonIgnoreProperties("profile")
    private List<Skill> skills = new ArrayList<>();
    
}