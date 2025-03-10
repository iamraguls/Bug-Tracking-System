package com.project.BugTrackingSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.BugTrackingSystem.image.BugAttachment;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bugs")
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private BugStatus status = BugStatus.OPEN; // Default OPEN

    @Enumerated(EnumType.STRING)
    private BugPriority priority = BugPriority.MEDIUM; // Default MEDIUM

    //@JsonIgnore  // 🔥 Circular reference fix
    @ManyToOne
    @JoinColumn(name = "reported_by")
    @JsonBackReference("user-bug-reported")
    private User reportedBy;

    //@JsonIgnore  // 🔥 Circular reference fix
    @ManyToOne
//    @JoinColumn(name = "assigned_to", nullable = true)
//    @JsonBackReference("user-bug-assigned")
    private User assignedTo;

    @ManyToOne
//    @JoinColumn(name = "project_id")
//    @JsonBackReference("project-bug")
    private Project project;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime resolvedAt;

    @OneToMany(mappedBy = "bug", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BugAttachment> attachments = new ArrayList<>();

    public Bug() {
    }

    public Bug(Long id, String title, String description, BugStatus status, BugPriority priority, Project project, User reportedBy, User assignedTo, LocalDateTime createdAt, LocalDateTime resolvedAt, List<BugAttachment> attachments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.project = project;
        this.reportedBy = reportedBy;
        this.assignedTo = assignedTo;
        this.createdAt = createdAt;
        this.resolvedAt = resolvedAt;
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

    public BugStatus getStatus() {
        return status;
    }

    public void setStatus(BugStatus status) {
        this.status = status;
    }

    public BugPriority getPriority() {
        return priority;
    }

    public void setPriority(BugPriority priority) {
        this.priority = priority;
    }

    public User getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(User reportedBy) {
        this.reportedBy = reportedBy;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
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

    public List<BugAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<BugAttachment> attachments) {
        this.attachments = attachments;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
