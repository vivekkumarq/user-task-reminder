package com.neko.exceptions;

import com.neko.exceptions.ErrorCode.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserTaskReminderException extends RuntimeException{
    private final ErrorCode errorCode;
    private final String message;
    private final HttpStatus status;

    public UserTaskReminderException(ErrorCode errorCode, Object... args) {
        super(String.format(errorCode.getMessage(), args));
        this.errorCode = errorCode;
        this.message = String.format(errorCode.getMessage(), args);
        this.status = errorCode.getStatus();
    }
}
