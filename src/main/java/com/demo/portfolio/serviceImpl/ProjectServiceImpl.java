package com.demo.portfolio.serviceImpl;

import com.demo.portfolio.entity.Project;
import com.demo.portfolio.repository.ProjectRepository;
import com.demo.portfolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }
}