package com.example.backend.Exceptions;

public class DogAlreadyExistsException extends RuntimeException{

    public DogAlreadyExistsException(){ super("Dog already exists"); }
}
