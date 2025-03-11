package com.project.BugTrackingSystem.service;

import com.project.BugTrackingSystem.dto.ProjectDTO;
import com.project.BugTrackingSystem.entity.Project;
import com.project.BugTrackingSystem.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project addProject(Project project){
        return projectRepository.save(project);
    }

    public ProjectDTO getProjectById(Long id) {
        Project project = projectRepository.findById(id).orElseThrow(()->new RuntimeException("Project not Found"));
        return new ProjectDTO(project);
    }

    public List<ProjectDTO> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream().map(ProjectDTO::new).toList();
    }

    public ProjectDTO updateProject(Long id, Project project) {
        Project existingProject = projectRepository.findById(id).orElseThrow(()->new RuntimeException("Project not Found"));
        existingProject.setName(project.getName());
        existingProject.setDescription(project.getDescription());
        projectRepository.save(existingProject);
        return new ProjectDTO(existingProject);
    }

    public String deleteProject(Long id) {
        Project existingProject = projectRepository.findById(id).orElseThrow(()->new RuntimeException("Project not Found"));
        projectRepository.deleteById(id);
        return "project deleted Successfully!!";
    }
}
