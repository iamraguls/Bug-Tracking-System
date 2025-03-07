package com.project.BugTrackingSystem.image;

import com.project.BugTrackingSystem.entity.Bug;
import com.project.BugTrackingSystem.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/bugs/{bugId}/attachments")
public class BugAttachmentController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private BugRepository bugRepository;

    @Autowired
    private BugAttachmentService bugAttachmentService;

    private BugAttachmentRepository attachmentRepository;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(
            @PathVariable Long bugId,
            @RequestParam("file") MultipartFile file) {

        Bug bug = bugRepository.findById(bugId)
                .orElseThrow(() -> new RuntimeException("Bug not found"));

        try {
            String fileName = fileStorageService.storeFile(file);
            BugAttachment attachment = new BugAttachment(fileName, file.getContentType(), "uploads/" + fileName, bug);
            attachmentRepository.save(attachment);

            return ResponseEntity.ok("File uploaded: " + fileName);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed");
        }
    }

    @GetMapping()
    public ResponseEntity<List<BugAttachment>> getAttachmentsByBugId(@PathVariable Long bugId) {
        List<BugAttachment> attachments = bugAttachmentService.getAttachmentsByBugId(bugId);
        return ResponseEntity.ok(attachments);
    }



}
