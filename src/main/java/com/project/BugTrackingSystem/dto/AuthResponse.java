package com.project.BugTrackingSystem.dto;

import com.project.BugTrackingSystem.entity.Role;

public class AuthResponse {

    private String token;
    private String username;
    private Role roles;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

}
