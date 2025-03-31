package com.neko.entity;

import com.neko.enums.Priority;
import com.neko.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
public class Task {
    private UUID id;
    private String name;
    private String description;
    private LocalDateTime createdDate;
    private String createdBy;
    private String modifiedBy;
    private LocalDateTime dueDate;
    private Boolean recurring;
    private UUID remainderId;
    private Priority priority;
    private Status status;
    private List<String> labels;
    private List<Object> attachments;
}
