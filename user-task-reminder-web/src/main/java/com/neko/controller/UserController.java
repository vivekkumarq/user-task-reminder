package com.neko.controller;

import com.neko.dto.UserDto;
import com.neko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.neko.constants.ApiConstants.*;

@RestController
@RequestMapping(TASK_MANAGEMENT + API + V1 + USER)
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity<UserDto> create(@RequestBody UserDto user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    @PatchMapping(path = SLASH + ID_VAR)
    public ResponseEntity<UserDto> update(@PathVariable(ID) UUID Id, @RequestBody UserDto user) {
        return new ResponseEntity<>(userService.update(Id, user), HttpStatus.OK);
    }

    @GetMapping(path = SLASH + ID_VAR)
    public ResponseEntity<UserDto> get(@PathVariable(ID) UUID Id) {
        return new ResponseEntity<>(userService.get(Id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> list() {
        return new ResponseEntity<>(userService.list(), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<UserDto> delete(@PathVariable(ID) UUID Id) {
        userService.delete(Id);
        return null;
    }
}
