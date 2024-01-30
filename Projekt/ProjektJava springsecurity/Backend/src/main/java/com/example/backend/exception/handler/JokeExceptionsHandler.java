package com.example.backend.exception.handler;

import com.example.backend.exception.exceptions.JokeAlreadyExistsException;
import com.example.backend.exception.exceptions.JokeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class JokeExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(JokeNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request){
        return new ResponseEntity<>("Joke not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(JokeAlreadyExistsException.class)
    public ResponseEntity<Object> handleBadRequestExists(RuntimeException ex, WebRequest request){
        return new ResponseEntity<>("Joke already exists ", HttpStatus.BAD_REQUEST);
    }

}
