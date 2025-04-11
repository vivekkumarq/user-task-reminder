package com.neko.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationDto {
    private UUID id;
    private UUID userId;
    private UUID taskId;
    private String message;
    private Boolean seen;
    private LocalDateTime createdDate;
}

