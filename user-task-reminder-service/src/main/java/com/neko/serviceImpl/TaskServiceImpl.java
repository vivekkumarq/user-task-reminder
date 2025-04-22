package com.neko.serviceImpl;

import com.neko.dto.TaskDto;
import com.neko.entity.Task;
import com.neko.exceptions.ErrorCode.ErrorCode;
import com.neko.exceptions.UserTaskReminderException;
import com.neko.repositories.TaskRepository;
import com.neko.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskDto create(TaskDto taskDto) {
        Task task = mapper.map(taskDto, Task.class);
        task.setId(UUID.randomUUID());
        task.setCreatedDate(LocalDateTime.now());
        return mapper.map(taskRepository.save(task), TaskDto.class);
    }

    @Override
    public TaskDto get(UUID id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new UserTaskReminderException(ErrorCode.TASK_NOT_FOUND, id));
        return mapper.map(task, TaskDto.class);
    }

    @Override
    public List<TaskDto> list() {
        return taskRepository.findAll().stream()
                .map(task -> mapper.map(task, TaskDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto update(UUID id, TaskDto task) {
        Task existingTask = taskRepository.findById(id).
                orElseThrow(() -> new UserTaskReminderException(ErrorCode.TASK_NOT_FOUND, id));

        for(Field field: task.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(task);
                if(Objects.nonNull(value)) {
                    Field entityField = existingTask.getClass().getDeclaredField(field.getName());
                    entityField.setAccessible(true);
                    entityField.set(existingTask, value);
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }
        return mapper.map(taskRepository.save(existingTask), TaskDto.class);
    }

    @Override
    public void delete(UUID id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new UserTaskReminderException(ErrorCode.TASK_NOT_FOUND, id));
        taskRepository.delete(task);
    }
}
