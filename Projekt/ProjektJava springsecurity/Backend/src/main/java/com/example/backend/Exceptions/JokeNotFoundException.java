package com.example.backend.Exceptions;

public class JokeNotFoundException extends RuntimeException{

    public JokeNotFoundException(){ super("Joke not found"); }
}
