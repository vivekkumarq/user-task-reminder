package com.neko.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Notification {
    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user_id") // ForeignKey column for user
    private User user;
    @ManyToOne
    @JoinColumn(name = "task_id") // FK column for task
    private Task task;
    private String message;
    private Boolean seen;
    private LocalDateTime createdDate;
}
