package com.demo.portfolio.service;

import com.demo.portfolio.entity.Project;
import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();      
    Project getProjectById(Long id);      
    Project createProject(Project project); 
}