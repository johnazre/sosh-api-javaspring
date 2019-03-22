package com.sosh.api.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String type, Long id){
        super("Could not find " + type + " with id: " + id);
    }
}
