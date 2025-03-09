package com.project.BugTrackingSystem.controller;

import com.project.BugTrackingSystem.dto.BugDTO;
import com.project.BugTrackingSystem.entity.Bug;
import com.project.BugTrackingSystem.service.BugService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BugController {

    @Autowired
    private BugService bugService;

    @PostMapping("/bug")
    public Bug createBug(@RequestBody BugDTO bugDTO, HttpServletRequest request){
        String username = (String) request.getAttribute("username");
        return bugService.createBug(bugDTO,username);
    }

}
