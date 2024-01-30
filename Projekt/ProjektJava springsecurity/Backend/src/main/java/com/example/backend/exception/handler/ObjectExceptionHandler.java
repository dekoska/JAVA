package com.example.backend.exception.handler;

import com.example.backend.exception.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ObjectExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({CatAlreadyExistsException.class, DogAlreadyExistsException.class, JokeAlreadyExistsException.class})
    public ResponseEntity<Object> handleAlreadyExists(RuntimeException ex, WebRequest request){
        return new ResponseEntity<>("Object already exists", HttpStatus.CONFLICT);
    }

    @ExceptionHandler({CatNotFoundException.class, DogNotFoundException.class, JokeNotFoundException.class})
    public ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request){
        return new ResponseEntity<>("Object not found", HttpStatus.NOT_FOUND);
    }
}
