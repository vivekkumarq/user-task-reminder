package com.neko.controller;

import com.neko.dto.TaskDto;
import com.neko.entity.Task;
import com.neko.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.neko.constants.ApiConstants.*;

@RestController
@RequestMapping(TASK_MANAGEMENT + API + V1 + TASK)
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> create(@RequestBody TaskDto task) {
        return new ResponseEntity<>(taskService.create(task), HttpStatus.CREATED);
    }

    @PatchMapping(path = SLASH+ID_VAR,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> update(@PathVariable(ID) UUID id,@RequestBody TaskDto task) {
        return new ResponseEntity<>(taskService.update(id,task), HttpStatus.CREATED);
    }

    @GetMapping(SLASH+ID_VAR)
    public ResponseEntity<Task> get(@PathVariable(ID) UUID id) {
        Task task = taskService.get(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Task>> list() {
        List<Task> tasks = taskService.list();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @DeleteMapping(SLASH+ID_VAR)
    public void delete(@PathVariable(ID) UUID id) {
        taskService.delete(id);
    }
}



//http://localhost:8080/taskManagement/api/v1/task
