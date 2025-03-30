package com.neko.controller;

import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/taskManagement/api/v1/task")
public class TaskController {

    @PostMapping
    public String createTask(@RequestBody Task task) {
        return "HelloCreate";
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
