package com.example.movieweb.Exception;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> badRequestException(BadRequestException e) {
        return ResponseEntity.
                status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> accessDeniedException(AccessDeniedException e) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(e.getMessage());
    }
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ValidationErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException e) {
//        Map<String, String> errors = new HashMap<>();
//        e.getBindingResult().getAllErrors().forEach((error) -> errors.put(error.getDefaultMessage(), error.getDefaultMessage()));
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ValidationErrorResponse(HttpStatus.BAD_REQUEST.value(),"Validation failed", errors));
//    }
}
