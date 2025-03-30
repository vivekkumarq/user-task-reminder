package com.neko.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
public class User {
    private UUID id;
    private String userName;
    private String email;
    private LocalDateTime createdDate;
    private List<String> roles;
}
