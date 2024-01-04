package com.draekk.springboot.springbootusersapi.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.draekk.springboot.springbootusersapi.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> defaultHandlerException(Exception ex) {
        Error error = new Error();
        error.setDate(new Date());
        error.setMessage(ex.getMessage());
        error.setException(ex.getClass().getSimpleName());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
    
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<?> notFoundHandlerException(Exception ex) {
        Error error = new Error();
        error.setDate(new Date());
        error.setMessage(ex.getMessage());
        error.setException(ex.getClass().getSimpleName());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
