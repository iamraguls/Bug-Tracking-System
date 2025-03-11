package com.project.BugTrackingSystem.controller;

import com.project.BugTrackingSystem.entity.Project;
import com.project.BugTrackingSystem.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/project")
    public Project addProject(@RequestBody Project project){
        return projectService.addProject(project);
    }



}
