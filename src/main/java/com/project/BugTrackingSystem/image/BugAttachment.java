package com.project.BugTrackingSystem.image;

import com.project.BugTrackingSystem.entity.Bug;
import jakarta.persistence.*;

@Entity
@Table(name = "bug_attachments")
public class BugAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary Key

    private String fileName;  // Uploaded file name
    private String fileType;  // File type (png, jpg, pdf, etc.)
    private String filePath;  // Where the file is stored on server

    @ManyToOne
    @JoinColumn(name = "bug_id", nullable = false)
    private Bug bug; // Foreign key reference to Bug

    public BugAttachment() {}

    public BugAttachment(String fileName, String fileType, String filePath, Bug bug) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.filePath = filePath;
        this.bug = bug;
    }

    public BugAttachment(Long id,String fileName, String fileType, String filePath, Bug bug) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.filePath = filePath;
        this.bug = bug;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Bug getBug() {
        return bug;
    }

    public void setBug(Bug bug) {
        this.bug = bug;
    }
}
