package com.example.interviewproject.exceptions;

public class AnimalAlreadyExistsException extends ObjectAlreadyExistsException {
    public AnimalAlreadyExistsException() {
        super();
    }

    public AnimalAlreadyExistsException(String message) {
        super(message);
    }
}
