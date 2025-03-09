package com.project.BugTrackingSystem.controller;

import com.project.BugTrackingSystem.dto.AuthDTO;
import com.project.BugTrackingSystem.dto.AuthResponse;
import com.project.BugTrackingSystem.dto.RegistrationDTO;
import com.project.BugTrackingSystem.entity.User;
import com.project.BugTrackingSystem.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User RegisterUser(@RequestBody RegistrationDTO registrationDTO){
        return authService.RegisterUser(registrationDTO);
    }

    @PostMapping("/login")
    public AuthResponse authenticateUser(@RequestBody AuthDTO authDTO){
        return authService.authenticateUser(authDTO);
    }

}
