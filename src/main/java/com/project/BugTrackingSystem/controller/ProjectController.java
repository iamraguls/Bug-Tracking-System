package com.project.BugTrackingSystem.controller;

import com.project.BugTrackingSystem.dto.ProjectDTO;
import com.project.BugTrackingSystem.entity.Project;
import com.project.BugTrackingSystem.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/project")
    public Project addProject(@RequestBody Project project){
        return projectService.addProject(project);
    }

    @GetMapping("/projects/{id}")
    public ProjectDTO getProjectById(@PathVariable Long id){
        return projectService.getProjectById(id);
    }

    @GetMapping("/projects")
    public List<ProjectDTO> getAllProjects(){
        return projectService.getAllProjects();
    }

    @PutMapping("/project/{id}")
    public ProjectDTO updateProject(@PathVariable Long id,@RequestBody Project project){
        return projectService.updateProject(id,project);
    }

    @DeleteMapping("/project/{id}")
    public String deleteProject(@PathVariable Long id){
        return projectService.deleteProject(id);
    }


}
