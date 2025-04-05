package com.neko.serviceImpl;

import com.neko.dto.TaskDto;
import com.neko.entity.Task;
import com.neko.repositories.TaskRepository;
import com.neko.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task create(TaskDto taskDto) {
        Task task = new Task();
        task = mapper.map(taskDto, Task.class);
        task.setId(UUID.randomUUID());
        return taskRepository.save(task);
    }

    @Override
    public Task get(UUID id) {
        Task task = taskRepository.findById(id).get();
        return task;
    }

    @Override
    public List<Task> list() {
        return taskRepository.findAll();
    }

    @Override
    public Task update(UUID id) {
        //TODO: PATCH for task controller
        return null;
    }

    @Override
    public void delete(UUID id) {
        Task task = taskRepository.findById(id).get();
        taskRepository.delete(task);
    }
}
