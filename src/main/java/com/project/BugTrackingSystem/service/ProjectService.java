package com.project.BugTrackingSystem.service;

import com.project.BugTrackingSystem.entity.Project;
import com.project.BugTrackingSystem.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project addProject(Project project){
        return projectRepository.save(project);
    }

}
