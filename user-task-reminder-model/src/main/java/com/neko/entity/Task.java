package com.neko.entity;

import com.neko.enums.Priority;
import com.neko.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
@Entity
public class Task {
    @Id
    private UUID id;
    private String description;
    private LocalDateTime createdDate;
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
    private String modifiedBy;
    private LocalDateTime dueDate;
    private Boolean recurring;
    private UUID remainderId;

    @Enumerated(EnumType.ORDINAL)
    private Priority priority;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @ElementCollection
    private List<String> labels;
    //TODO: remove transient and enable it to persist when implementing upload logic
    @Transient
    private List<Object> attachments;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications;

}
