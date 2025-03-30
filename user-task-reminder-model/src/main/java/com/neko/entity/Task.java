package com.neko.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Task {
    private UUID id;
    private String name;
    private String description;
    private LocalDateTime createdDate;
    private String createdBy;
    private String modifiedBy;
    private LocalDateTime dueDate;
    private boolean recurring;
    private UUID remainderId;
    private String priority;
    private String status;
    private List<String> labels;
    private Object attachments;
}
