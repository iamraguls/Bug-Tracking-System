package com.project.BugTrackingSystem.service;

import com.project.BugTrackingSystem.dto.UserResponseDTO;
import com.project.BugTrackingSystem.entity.Role;
import com.project.BugTrackingSystem.entity.User;
import com.project.BugTrackingSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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

    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not Found"));
        return new UserResponseDTO(user);
    }

    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserResponseDTO::new).toList();
    }


    public String deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not Found"));
        userRepository.delete(user);
        return "User Deleted Successfully";
    }

}
