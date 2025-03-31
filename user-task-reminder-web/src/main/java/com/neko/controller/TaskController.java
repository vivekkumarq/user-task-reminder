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

    @GetMapping("/{id}")
    public String getTask(@PathVariable("id") String id) {
        return "Hello" + id;
    }

    @GetMapping("/")
    public String listTask() {
        return "Hello";
    }
}
