package com.example.interviewproject.exceptions;

public class UserAlreadyExistsException extends ObjectAlreadyExistsException {
    public UserAlreadyExistsException() {
        super();
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
