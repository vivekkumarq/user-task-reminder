package com.neko.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
public class Remainder {
    private UUID id;
    private UUID taskId;
    private String cronExpression;
    private String message;
    private LocalDateTime dueDate;
    private List<String> channel;
}
