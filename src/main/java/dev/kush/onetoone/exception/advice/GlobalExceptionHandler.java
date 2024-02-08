package dev.kush.onetoone.exception.advice;

import dev.kush.onetoone.exception.FileHandleException;
import dev.kush.onetoone.exception.ResponseDto;
import dev.kush.onetoone.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public Object UserNotFoundExceptionHandler(Exception ex, WebRequest request) {
        return new ResponseDto(NOT_FOUND,"error",ex.getMessage());
    }

    @ExceptionHandler(FileHandleException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public Object UploadFileExceptionHandler(Exception ex, WebRequest request){
        return new ResponseDto(INTERNAL_SERVER_ERROR,"error",ex.getMessage());
    }
}
