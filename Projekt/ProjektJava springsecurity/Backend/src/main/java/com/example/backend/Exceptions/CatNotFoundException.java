package com.example.backend.Exceptions;

public class CatNotFoundException extends RuntimeException{
    public CatNotFoundException(){ super("Cat not found"); }

}
