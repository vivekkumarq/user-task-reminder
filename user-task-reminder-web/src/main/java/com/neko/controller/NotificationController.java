package com.neko.controller;

import com.neko.dto.NotificationDto;
import com.neko.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.neko.constants.ApiConstants.*;

@RestController
@RequestMapping(TASK_MANAGEMENT + API + V1 + NOTIFICATION)
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<NotificationDto> create(@RequestBody NotificationDto dto) {
        return new ResponseEntity<>(notificationService.create(dto), HttpStatus.CREATED);
    }

    @PatchMapping(path = SLASH + ID_VAR)
    public ResponseEntity<NotificationDto> update(@PathVariable(ID) UUID id, @RequestBody NotificationDto dto) {
        return new ResponseEntity<>(notificationService.update(id, dto), HttpStatus.OK);
    }

    @GetMapping(path = SLASH + ID_VAR)
    public ResponseEntity<NotificationDto> get(@PathVariable(ID) UUID id) {
        return new ResponseEntity<>(notificationService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<NotificationDto>> list() {
        return new ResponseEntity<>(notificationService.get(), HttpStatus.OK);
    }

    @DeleteMapping(path = SLASH + ID_VAR)
    public ResponseEntity<Void> delete(@PathVariable(ID) UUID id) {
        notificationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
