package com.neko.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Data
public class Notification {
    private UUID id;
    private UUID userId;
    private UUID taskId;
    private String message;
    private Boolean seen;
    private LocalDateTime createdDate;
}
