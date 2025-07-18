package com.example.assignment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String phoneNumber;

    private String email;

    private Integer linkedId;

    @Enumerated(EnumType.STRING)
    private LinkPrecedence linkPrecedence;

    private LocalDateTime createdAt;
    @PrePersist
    protected void onCreate(){
        this.createdAt=LocalDateTime.now();
    }

    private LocalDateTime updatedAt;
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }

    private LocalDateTime deletedAt;
    @PreRemove
    public void setDeletionTimestamp() {
        this.deletedAt = LocalDateTime.now();
    }

}
