package com.javatechie.handler;

public class DuplicateProductException extends RuntimeException{

    public DuplicateProductException(String message) {
        super(message);
    }
}
