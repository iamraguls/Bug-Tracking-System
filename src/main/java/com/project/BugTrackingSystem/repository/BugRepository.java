package com.project.BugTrackingSystem.repository;

import com.project.BugTrackingSystem.entity.Bug;
import com.project.BugTrackingSystem.entity.BugPriority;
import com.project.BugTrackingSystem.entity.BugStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugRepository extends JpaRepository<Bug,Long> {

    List<Bug> findByProjectId(Long projectId);
    List<Bug> findByStatus(BugStatus status);
    List<Bug> findByPriority(BugPriority priority);

}
