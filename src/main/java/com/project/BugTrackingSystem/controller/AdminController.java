package com.project.BugTrackingSystem.controller;

import com.project.BugTrackingSystem.dto.UserResponseDTO;
import com.project.BugTrackingSystem.entity.User;
import com.project.BugTrackingSystem.service.AdminService;
import jakarta.annotation.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/user/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id) {
        return adminService.getUserById(id);
    }

    @GetMapping("/users")
    public List<UserResponseDTO> getAllUsers(){
        return adminService.getAllUsers();
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id){
        return adminService.deleteUser(id);
    }

}
