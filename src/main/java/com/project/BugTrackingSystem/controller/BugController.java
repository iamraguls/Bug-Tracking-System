package com.project.BugTrackingSystem.controller;

import com.project.BugTrackingSystem.dto.BugDTO;
import com.project.BugTrackingSystem.dto.BugResponseDTO;
import com.project.BugTrackingSystem.entity.Bug;
import com.project.BugTrackingSystem.service.BugService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BugController {

    @Autowired
    private BugService bugService;

    @PostMapping("/bug")
    public BugResponseDTO createBug(@RequestBody BugDTO bugDTO, HttpServletRequest request){
        String username = (String) request.getAttribute("username");
        return bugService.createBug(bugDTO,username);
    }

    @GetMapping("/bugs")
    public List<BugResponseDTO> getAllBugs() {
        return bugService.getAllBugs();
    }

    @GetMapping("/bugs/project/{projectId}")
    public List<BugResponseDTO> getBugsByProject(@PathVariable Long projectId) {
        return bugService.getBugsByProject(projectId);
    }

    @DeleteMapping("/bug/{bugId}")
    public String deleteByBugId(@PathVariable Long bugId) {
        return bugService.deleteByBugId(bugId);
    }

    @PutMapping("/bug/{bugId}")
    public BugResponseDTO updateBug(@PathVariable Long bugId, @RequestBody BugDTO bugDTO) {
        return bugService.updateBug(bugId, bugDTO);
    }

    @PutMapping("/bugs/{id}/assign")
    public BugResponseDTO assignBug(@PathVariable Long id, @RequestParam Long developerId){
        return bugService.assignBug(id, developerId);
    }

}
