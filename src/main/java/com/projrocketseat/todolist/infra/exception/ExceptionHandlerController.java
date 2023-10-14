package com.projrocketseat.todolist.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handleHttpMessageNotReadbleException(HttpMessageNotReadableException err){
        return ResponseEntity.badRequest().body(err.getMostSpecificCause().getMessage());
    }

}
