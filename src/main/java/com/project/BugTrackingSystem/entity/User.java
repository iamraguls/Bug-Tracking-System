package com.project.BugTrackingSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role roles;

    @JsonIgnore  // 🔥 Circular reference fix
    @OneToMany(mappedBy = "reportedBy", cascade = CascadeType.ALL)
//    @JsonManagedReference("user-bug-reported")
    private List<Bug> reportedBugs;

    @JsonIgnore  // 🔥 Circular reference fix
    @OneToMany(mappedBy = "assignedTo", cascade = CascadeType.ALL)
//    @JsonManagedReference("user-bug-assigned")
    private List<Bug> assignedBugs;

    public User() {
    }

    public User(Long id, String username, String email, String password, Role roles, List<Bug> reportedBugs, List<Bug> assignedBugs) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.reportedBugs = reportedBugs;
        this.assignedBugs = assignedBugs;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+roles.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return roles;
    }

    public void setRole(Role roles) {
        this.roles = roles;
    }

    public List<Bug> getReportedBugs() {
        return reportedBugs;
    }

    public void setReportedBugs(List<Bug> reportedBugs) {
        this.reportedBugs = reportedBugs;
    }

    public List<Bug> getAssignedBugs() {
        return assignedBugs;
    }

    public void setAssignedBugs(List<Bug> assignedBugs) {
        this.assignedBugs = assignedBugs;
    }
}
