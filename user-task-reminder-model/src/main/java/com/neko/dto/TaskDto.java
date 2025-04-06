package com.neko.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.neko.enums.Priority;
import com.neko.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskDto {
    private UUID id;
    private String name;
    private String description;
    //TODO: user info needs to be removed in future
    private UserDto createdBy;
    private String modifiedBy;
    private LocalDateTime createdDate;
    private LocalDateTime dueDate;
    private Boolean recurring;
    private UUID remainderId;
    private Priority priority;
    private Status status;
    private List<String> labels;
    private List<Object> attachments;
}
