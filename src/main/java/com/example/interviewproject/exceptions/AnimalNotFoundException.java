package com.example.interviewproject.exceptions;

public class AnimalNotFoundException extends ObjectNotFoundException {
    public AnimalNotFoundException() {
        super();
    }

    public AnimalNotFoundException(String message) {
        super(message);
    }
}
