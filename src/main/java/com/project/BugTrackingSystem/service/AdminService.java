package com.project.BugTrackingSystem.service;

import com.project.BugTrackingSystem.entity.Role;
import com.project.BugTrackingSystem.entity.User;
import com.project.BugTrackingSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    public User allocateRole(Long id, String role) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not Found"));
        try{
            user.setRole(Role.valueOf(role.toUpperCase()));
            userRepository.save(user);
            return user;
        }catch (IllegalArgumentException e){
            throw new RuntimeException("Invalid Role! Allowed values: " + Arrays.toString(Role.values()));
        }
    }
}
