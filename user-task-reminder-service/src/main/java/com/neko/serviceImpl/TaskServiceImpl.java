package com.neko.serviceImpl;

import com.neko.dto.TaskDto;
import com.neko.entity.Task;
import com.neko.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private ModelMapper mapper;

    @Override
    public Task create(TaskDto taskDto) {
        Task task = new Task();
        task = mapper.map(taskDto, Task.class);
        task.setId(UUID.randomUUID());
        //TODO: Save to DB
        return task;
    }

    @Override
    public Task get(UUID id) {
        return null;
    }

    @Override
    public List<Task> list(UUID id) {
        return List.of();
    }

    @Override
    public Task update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
