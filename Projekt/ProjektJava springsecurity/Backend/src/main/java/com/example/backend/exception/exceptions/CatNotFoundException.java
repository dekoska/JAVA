package com.example.backend.exception.exceptions;

public class CatNotFoundException extends RuntimeException{
    public CatNotFoundException(){ super("Cat not found"); }

}
