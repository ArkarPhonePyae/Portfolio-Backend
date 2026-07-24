package com.demo.portfolio.serviceImpl;

import com.demo.portfolio.entity.Profile;
import com.demo.portfolio.entity.Skill;
import com.demo.portfolio.repository.ProfileRepository;
import com.demo.portfolio.repository.SkillRepository;
import com.demo.portfolio.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;
    private final ProfileRepository profileRepository;

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll(); 
    }

    @Override
    public List<Skill> getSkillsByCategory(String category) {
        return skillRepository.findByCategory(category); 
    }

    @Override
    public Skill createSkill(Skill skill) {
        Profile profile = profileRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        skill.setProfile(profile);
        return skillRepository.save(skill);
    }
}