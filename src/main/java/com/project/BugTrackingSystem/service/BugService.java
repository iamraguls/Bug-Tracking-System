package com.project.BugTrackingSystem.service;

import com.project.BugTrackingSystem.dto.BugDTO;
import com.project.BugTrackingSystem.dto.BugResponseDTO;
import com.project.BugTrackingSystem.dto.ProjectDTO;
import com.project.BugTrackingSystem.dto.UserDTO;
import com.project.BugTrackingSystem.entity.*;
import com.project.BugTrackingSystem.repository.BugRepository;
import com.project.BugTrackingSystem.repository.ProjectRepository;
import com.project.BugTrackingSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BugService {

    @Autowired
    private BugRepository bugRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public BugResponseDTO createBug(BugDTO bugDTO, String username) {
        User reportedBy = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        User assignedTo = null;
        if (bugDTO.getAssignedToId() != null) {
            assignedTo = userRepository.findById(bugDTO.getAssignedToId())
                    .orElseThrow(() -> new RuntimeException("Assigned user not found"));
        }
        Project project = projectRepository.findById(bugDTO.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        Bug bug = new Bug();
        bug.setTitle(bugDTO.getTitle());
        bug.setDescription(bugDTO.getDescription());
        bug.setStatus(BugStatus.valueOf(bugDTO.getStatus())); // Convert String to Enum
        bug.setPriority(BugPriority.valueOf(bugDTO.getPriority())); // Convert String to Enum
        bug.setReportedBy(reportedBy);
        bug.setAssignedTo(assignedTo);
        bug.setProject(project);
        bug.setCreatedAt(LocalDateTime.now());
        bugRepository.save(bug);
//        return new BugResponseDTO(
//                bug.getId(),
//                bug.getTitle(),
//                bug.getDescription(),
//                bug.getStatus().name(),
//                bug.getPriority().name(),
//                bug.getCreatedAt(),
//                bug.getResolvedAt(),
//                new UserDTO(reportedBy),
//                new UserDTO(assignedTo),
//                new ProjectDTO(project),
//                bug.getAttachments()
//        );
        return new BugResponseDTO(bug);
    }

    public List<BugResponseDTO> getAllBugs() {
        List<Bug> bugs = bugRepository.findAll();
        return bugs.stream().map(BugResponseDTO::new).collect(Collectors.toList());
    }

    public List<BugResponseDTO> getBugsByProject(Long projectId) {
        List<Bug> bugs = bugRepository.findByProjectId(projectId);
        return bugs.stream().map(BugResponseDTO::new).collect(Collectors.toList());
    }

    public String deleteByBugId(Long bugId) {
        Bug bug = bugRepository.findById(bugId)
                .orElseThrow(() -> new RuntimeException("Bug not found"));
        bugRepository.delete(bug);
        return "Bug deleted successfully";
    }

    public BugResponseDTO updateBug(Long bugId, BugDTO bugDTO) {
        Bug bug = bugRepository.findById(bugId)
                .orElseThrow(() -> new RuntimeException("Bug not found"));
        bug.setTitle(bugDTO.getTitle());
        bug.setDescription(bugDTO.getDescription());
        bug.setStatus(BugStatus.valueOf(bugDTO.getStatus())); // Convert String to Enum
        bug.setPriority(BugPriority.valueOf(bugDTO.getPriority())); // Convert String to Enum
        bugRepository.save(bug);
        return new BugResponseDTO(bug);
    }
}
