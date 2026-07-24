package com.demo.portfolio.serviceImpl;

import com.demo.portfolio.entity.Profile;
import com.demo.portfolio.repository.ProfileRepository;
import com.demo.portfolio.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    @Transactional(readOnly = true)
    public Profile getProfile() {
        return profileRepository.findById(1L).orElseGet(() -> {
            Profile emptyProfile = new Profile();
            emptyProfile.setId(1L);
            emptyProfile.setName("Enter Name");
            return emptyProfile;
        });
    }

    @Override
    @Transactional
    public Profile updateProfile(Profile profile) {
        Profile existing = profileRepository.findById(1L)
                .orElse(new Profile());
        
        existing.setId(1L); 
        existing.setName(profile.getName());
        existing.setTitle(profile.getTitle());
        existing.setBio(profile.getBio());
        existing.setGithubUrl(profile.getGithubUrl());
        existing.setLinkedinUrl(profile.getLinkedinUrl());
        existing.setEmail(profile.getEmail());
        
        return profileRepository.save(existing);
    }
}