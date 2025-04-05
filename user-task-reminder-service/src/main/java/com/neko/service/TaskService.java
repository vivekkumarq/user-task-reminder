package com.neko.service;

import com.neko.dto.TaskDto;
import com.neko.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    Task create(TaskDto task);

    Task get(UUID id);

    List<Task> list();

    Task update(UUID id);

    void delete(UUID id);
}
