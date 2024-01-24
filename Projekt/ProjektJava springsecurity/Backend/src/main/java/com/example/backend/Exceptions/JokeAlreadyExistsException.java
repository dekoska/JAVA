package com.example.backend.Exceptions;

public class JokeAlreadyExistsException extends RuntimeException{

    public JokeAlreadyExistsException(){ super("Joke already exists"); }
}
