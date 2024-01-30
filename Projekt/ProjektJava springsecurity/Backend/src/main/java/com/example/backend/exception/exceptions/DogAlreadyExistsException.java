package com.example.backend.exception.exceptions;

public class DogAlreadyExistsException extends RuntimeException{

    public DogAlreadyExistsException(){ super("Dog already exists"); }
}
