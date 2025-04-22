package com.neko.exceptions.ErrorCode;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    //start with UTR - {code}
    // 001 - 099 Resource not found
    // 100 - 199 Validation Errors
    // 200 - 299 Internal Server
    // 300 - 399 Unauthorized or auth related
    // 400 - 499 Duplicates or conflicts

    TASK_NOT_FOUND("UTR-001", "Task with ID %s Not Found", HttpStatus.NOT_FOUND),
    USER_NOT_FOUND("UTR-002", "User with ID %s Not Found", HttpStatus.NOT_FOUND),
    NOTIFICATION_NOT_FOUND("UTR-003", "Notification with ID %s Not Found", HttpStatus.NOT_FOUND);


    final String code;
    final String message;
    final HttpStatus status;

    ErrorCode(String code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

}
