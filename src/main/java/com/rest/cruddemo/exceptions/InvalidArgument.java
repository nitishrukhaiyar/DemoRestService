package com.rest.cruddemo.exceptions;

public class InvalidArgument extends RuntimeException {
    public InvalidArgument(String message)
    {
        super (message);
    }
}
