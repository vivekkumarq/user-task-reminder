package com.neko.entity;

import com.neko.enums.Channel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
public class Reminder {
    private UUID id;
    private UUID taskId;
    private String cron;
    private String message;
    private LocalDateTime dueDate;
    private Channel channel;
}
