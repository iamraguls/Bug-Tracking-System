package com.project.BugTrackingSystem.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugAttachmentRepository extends JpaRepository<BugAttachment,Long> {
    @Query("SELECT b FROM BugAttachment b WHERE b.bug.id = :bugId")
    List<BugAttachment> findByBugId(@Param("bugId") Long bugId);
}
