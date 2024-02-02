package dev.kush.onetoone.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ExceptionMessage(
        String message,
        LocalDateTime timeStamp,
        HttpStatus statusCode
) {
}
