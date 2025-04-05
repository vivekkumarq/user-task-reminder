package com.neko.controller;

import com.neko.dto.TaskDto;
import com.neko.entity.Task;
import com.neko.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.neko.constants.ApiConstants.*;

@RestController
@RequestMapping(TASK_MANAGEMENT + API + V1 + TASK)
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Task createTask(@RequestBody TaskDto task) {
        return taskService.create(task);
    }

    @GetMapping(SLASH+ID_VAR)
    public String getTask(@PathVariable(ID) String id) {
        return "Hello" + id;
    }

    @GetMapping(SLASH)
    public String listTask() {
        return "Hello";
    }
}
