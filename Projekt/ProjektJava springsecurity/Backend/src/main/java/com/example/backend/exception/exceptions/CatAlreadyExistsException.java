package com.example.backend.exception.exceptions;

public class CatAlreadyExistsException extends RuntimeException{

    public CatAlreadyExistsException(){ super("Cat already exists\"");}
}
