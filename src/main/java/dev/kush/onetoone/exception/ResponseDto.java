package dev.kush.onetoone.exception;

import org.springframework.http.HttpStatus;

public record ResponseDto(
        HttpStatus status,
        String message,
        Object data
) {
}
