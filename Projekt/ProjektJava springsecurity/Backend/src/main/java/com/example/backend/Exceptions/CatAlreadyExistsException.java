package com.example.backend.Exceptions;

public class CatAlreadyExistsException extends RuntimeException{

    public CatAlreadyExistsException(){ super("Cat already exists\"");}
}
