package com.project.BugTrackingSystem.dto;

import com.project.BugTrackingSystem.entity.Bug;
import com.project.BugTrackingSystem.entity.Project;
import com.project.BugTrackingSystem.entity.User;
import com.project.BugTrackingSystem.image.BugAttachment;

import java.time.LocalDateTime;
import java.util.List;

public class BugResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String status;
    private String priority;
    private LocalDateTime createdAt;
    private LocalDateTime resolvedAt;

    private UserDTO reportedBy;
    private UserDTO assignedTo;
    private ProjectDTO project;

    private List<BugAttachment> attachments;

    public BugResponseDTO(Bug bug) {
        this.id = bug.getId();
        this.title = bug.getTitle();
        this.description = bug.getDescription();
        this.status = bug.getStatus().name();
        this.priority = bug.getPriority().name();
        this.createdAt = bug.getCreatedAt();
        this.resolvedAt = bug.getResolvedAt();

        // Convert User & Project to DTOs (Avoid Circular Reference)
        this.reportedBy = bug.getReportedBy() != null ? new UserDTO(bug.getReportedBy()) : null;
        this.assignedTo = bug.getAssignedTo() != null ? new UserDTO(bug.getAssignedTo()) : null;
        this.project = bug.getProject() != null ? new ProjectDTO(bug.getProject()) : null;

        this.attachments = bug.getAttachments();
    }

    public BugResponseDTO(Long id, String title, String description, String status, String priority, LocalDateTime createdAt, LocalDateTime resolvedAt, UserDTO reportedBy, UserDTO assignedTo, ProjectDTO project, List<BugAttachment> attachments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.createdAt = createdAt;
        this.resolvedAt = resolvedAt;
        this.reportedBy = reportedBy;
        this.assignedTo = assignedTo;
        this.project = project;
        this.attachments = attachments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getResolvedAt() {
        return resolvedAt;
    }

    public void setResolvedAt(LocalDateTime resolvedAt) {
        this.resolvedAt = resolvedAt;
    }

    public UserDTO getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(UserDTO reportedBy) {
        this.reportedBy = reportedBy;
    }

    public UserDTO getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(UserDTO assignedTo) {
        this.assignedTo = assignedTo;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    public List<BugAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<BugAttachment> attachments) {
        this.attachments = attachments;
    }
}