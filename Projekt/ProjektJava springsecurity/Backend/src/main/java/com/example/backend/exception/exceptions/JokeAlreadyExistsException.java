package com.example.backend.exception.exceptions;

public class JokeAlreadyExistsException extends RuntimeException{

    public JokeAlreadyExistsException(){ super("Joke already exists"); }
}
