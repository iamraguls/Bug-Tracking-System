package com.project.BugTrackingSystem.controller;

import com.project.BugTrackingSystem.entity.User;
import com.project.BugTrackingSystem.service.AdminService;
import jakarta.annotation.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/allocateRole/{id}")
    public User allocateRole(@PathVariable Long id, @RequestParam String role) {
        return adminService.allocateRole(id,role);
    }

}
