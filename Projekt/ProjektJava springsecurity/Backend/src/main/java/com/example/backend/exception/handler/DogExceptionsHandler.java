package com.example.backend.exception.handler;

import com.example.backend.exception.exceptions.DogAlreadyExistsException;
import com.example.backend.exception.exceptions.DogNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DogExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DogNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request){
        return new ResponseEntity<>("Dog not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DogAlreadyExistsException.class)
    public ResponseEntity<Object> handleBadRequestExists(RuntimeException ex, WebRequest request){
        return new ResponseEntity<>("Dog already exists ", HttpStatus.BAD_REQUEST);
    }

}
