package com.project.BugTrackingSystem.dto;

import com.project.BugTrackingSystem.image.BugAttachment;

import java.time.LocalDateTime;
import java.util.List;

public class BugDTO {

    private String title;
    private String description;
    private String status;
    private String priority;
    private LocalDateTime createdAt;
    private Long projectId;
    private Long reportedById;
    private Long assignedToId;
    private List<BugAttachment> attachments;

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

    public List<BugAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<BugAttachment> attachments) {
        this.attachments = attachments;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getReportedById() {
        return reportedById;
    }

    public void setReportedById(Long reportedById) {
        this.reportedById = reportedById;
    }

    public Long getAssignedToId() {
        return assignedToId;
    }

    public void setAssignedToId(Long assignedToId) {
        this.assignedToId = assignedToId;
    }
}
