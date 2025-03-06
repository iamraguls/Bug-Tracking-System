package com.project.BugTrackingSystem.repository;

import com.project.BugTrackingSystem.entity.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugRepository extends JpaRepository<Bug,Long> {

}
