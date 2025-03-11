package com.project.BugTrackingSystem.dto;

import com.project.BugTrackingSystem.entity.Bug;
import com.project.BugTrackingSystem.entity.Role;
import com.project.BugTrackingSystem.entity.User;

import java.util.List;

public class UserResponseDTO {

    private Long id;
    private String username;
    private String email;
    private Role roles;
    private List<BugResponseDTO> reportedBugs;
    private List<BugResponseDTO> assignedBugs;

    public UserResponseDTO(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.roles = user.getRole();
        this.reportedBugs = user.getReportedBugs().stream()
                .map(BugResponseDTO::new)  // Convert Bug → BugDTO
                .toList();
        this.assignedBugs = user.getAssignedBugs().stream()
                .map(BugResponseDTO::new)  // Convert Bug → BugDTO
                .toList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public List<BugResponseDTO> getReportedBugs() {
        return reportedBugs;
    }

    public void setReportedBugs(List<BugResponseDTO> reportedBugs) {
        this.reportedBugs = reportedBugs;
    }

    public List<BugResponseDTO> getAssignedBugs() {
        return assignedBugs;
    }

    public void setAssignedBugs(List<BugResponseDTO> assignedBugs) {
        this.assignedBugs = assignedBugs;
    }
}
