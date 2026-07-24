package com.demo.portfolio.service;

import com.demo.portfolio.entity.Profile;

public interface ProfileService {
    Profile getProfile();
    Profile updateProfile(Profile profile);
}