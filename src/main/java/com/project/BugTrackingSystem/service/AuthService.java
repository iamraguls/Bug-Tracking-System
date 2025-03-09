package com.project.BugTrackingSystem.service;

import com.project.BugTrackingSystem.dto.AuthDTO;
import com.project.BugTrackingSystem.dto.AuthResponse;
import com.project.BugTrackingSystem.dto.RegistrationDTO;
import com.project.BugTrackingSystem.entity.Role;
import com.project.BugTrackingSystem.entity.User;
import com.project.BugTrackingSystem.jwt.JwtService;
import com.project.BugTrackingSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;


    public User RegisterUser(RegistrationDTO registrationDTO) {
        Optional<User> oldUser = userRepository.findByUsername(registrationDTO.getUsername());
        if(oldUser.isPresent()){
            throw new RuntimeException("User already exists");
        }

        User newUser = new User();
        newUser.setUsername(registrationDTO.getUsername());
        newUser.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        newUser.setEmail(registrationDTO.getEmail());
        newUser.setRole(Role.USER);

        return userRepository.save(newUser);

    }

    public AuthResponse authenticateUser(AuthDTO authDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDTO.getUsername(),authDTO.getPassword()));
        User user = userRepository.findByUsername(authDTO.getUsername()).orElseThrow(()->new RuntimeException("User not found"));
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(jwtService.generateToken(user));
        authResponse.setUsername(user.getUsername());
        authResponse.setRoles(user.getRole());
        return authResponse;
    }

}
