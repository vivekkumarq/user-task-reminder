package com.neko.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@NoArgsConstructor
@Data
public class AuditLog {
    private UUID id;
    private UUID taskId;
    private String action;
    private String performedBy;
    private Timestamp timestamp;
    private String details;
}
