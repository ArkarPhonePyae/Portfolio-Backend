package com.demo.portfolio.controller;

import com.demo.portfolio.entity.Profile;
import com.demo.portfolio.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping
    public ResponseEntity<Profile> getProfile() {
        return ResponseEntity.ok(profileService.getProfile());
    }

    @PutMapping
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile) {
        return ResponseEntity.ok(profileService.updateProfile(profile));
    }
}