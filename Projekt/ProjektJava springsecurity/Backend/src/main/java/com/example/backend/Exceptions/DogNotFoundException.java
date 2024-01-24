package com.example.backend.Exceptions;

public class DogNotFoundException extends RuntimeException{

    public DogNotFoundException(){ super("Dog not found"); }
}
