package com.sala.salas.exceptions;

public class SalaNotFoundException extends RuntimeException{
    public SalaNotFoundException(String message) {
        super(message);
    }
}
