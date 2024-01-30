package com.example.backend.exception.exceptions;

public class JokeNotFoundException extends RuntimeException{

    public JokeNotFoundException(){ super("Joke not found"); }
}
