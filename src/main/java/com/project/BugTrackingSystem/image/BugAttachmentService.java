package com.project.BugTrackingSystem.image;

import com.project.BugTrackingSystem.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BugAttachmentService {

    @Autowired
    private BugAttachmentRepository bugAttachmentRepository;

    public List<BugAttachment> getAttachmentsByBugId(Long bugId) {
        return bugAttachmentRepository.findByBugId(bugId);
    }

}
