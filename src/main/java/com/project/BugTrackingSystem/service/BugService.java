package com.project.BugTrackingSystem.service;

import com.project.BugTrackingSystem.dto.BugDTO;
import com.project.BugTrackingSystem.entity.*;
import com.project.BugTrackingSystem.repository.BugRepository;
import com.project.BugTrackingSystem.repository.ProjectRepository;
import com.project.BugTrackingSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BugService {

    @Autowired
    private BugRepository bugRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public Bug createBug(BugDTO bugDTO, String username) {
        User reportedBy = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        User assignedTo = null;
        if (bugDTO.getAssignedToId() != null) {
            assignedTo = userRepository.findById(bugDTO.getAssignedToId())
                    .orElseThrow(() -> new RuntimeException("Assigned user not found"));
        }

        Bug bug = new Bug();
        bug.setTitle(bugDTO.getTitle());
        bug.setDescription(bugDTO.getDescription());
        bug.setStatus(BugStatus.valueOf(bugDTO.getStatus())); // Convert String to Enum
        bug.setPriority(BugPriority.valueOf(bugDTO.getPriority())); // Convert String to Enum
        bug.setReportedBy(reportedBy);
        bug.setAssignedTo(assignedTo);
        bug.setCreatedAt(LocalDateTime.now());
        bugRepository.save(bug);
        return bug;
    }

}
