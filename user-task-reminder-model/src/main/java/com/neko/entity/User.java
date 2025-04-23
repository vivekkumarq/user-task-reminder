package com.neko.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
@Entity
@Table(name = "user_entity")
public class User {
    @Id
    private UUID id;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private List<String> roles;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    private List<Task> tasks;

    //FYI orphanRemoval is use for ,If we  remove an item from the parent’s collection,
    // and the child has no other reference,
    // it will be automatically deleted from the database.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications;
}
