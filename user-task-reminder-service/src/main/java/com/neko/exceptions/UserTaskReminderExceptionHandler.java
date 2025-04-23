package com.neko.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class UserTaskReminderExceptionHandler {

    @ExceptionHandler(UserTaskReminderException.class)
    public ResponseEntity<?> handleUserTaskReminderException(UserTaskReminderException exception) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("code" , exception.getErrorCode().getCode());
        errorResponse.put("message", exception.getMessage());
        return new ResponseEntity<>(errorResponse, exception.getStatus());
    }
}
