package com.project.BugTrackingSystem.entity;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime createdAt = LocalDateTime.now();

}
