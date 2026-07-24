package com.demo.portfolio.service;

import com.demo.portfolio.entity.Skill;
import java.util.List;

public interface SkillService {
    List<Skill> getAllSkills();
    List<Skill> getSkillsByCategory(String category);
    Skill createSkill(Skill skill);
}