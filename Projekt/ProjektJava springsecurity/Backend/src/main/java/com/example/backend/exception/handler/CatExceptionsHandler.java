package com.example.backend.exception.handler;

import com.example.backend.exception.exceptions.CatAlreadyExistsException;
import com.example.backend.exception.exceptions.CatNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CatExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CatNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request){
        return new ResponseEntity<>("Cat not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CatAlreadyExistsException.class)
    public ResponseEntity<Object> handleBadRequestExists(RuntimeException ex, WebRequest request){
        return new ResponseEntity<>("Cat already exists ", HttpStatus.BAD_REQUEST);
    }

}
