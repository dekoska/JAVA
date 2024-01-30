package com.example.backend.exception.exceptions;

public class DogNotFoundException extends RuntimeException{

    public DogNotFoundException(){ super("Dog not found"); }
}
