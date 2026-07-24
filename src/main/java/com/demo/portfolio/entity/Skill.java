package com.demo.portfolio.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "skills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String category;
    private int percentage;

    @ManyToOne
    @JoinColumn(name = "profile_id") 
    @JsonIgnoreProperties("skills") 
    private Profile profile;
}