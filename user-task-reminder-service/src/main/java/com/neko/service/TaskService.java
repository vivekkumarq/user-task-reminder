package com.neko.service;

import com.neko.dto.TaskDto;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    TaskDto create(TaskDto task);

    TaskDto get(UUID id);

    List<TaskDto> list();

    TaskDto update(UUID id, TaskDto task);

    void delete(UUID id);
}
