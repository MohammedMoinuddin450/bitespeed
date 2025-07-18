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

    @PrePersist
    protected void onCreate(){
        LocalDateTime createdAt=LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        LocalDateTime updatedAt = LocalDateTime.now();
    }

    private LocalDateTime deletedAt;

}
