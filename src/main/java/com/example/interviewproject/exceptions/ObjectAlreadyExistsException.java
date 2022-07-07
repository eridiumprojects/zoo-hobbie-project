package com.example.interviewproject.exceptions;

public class ObjectAlreadyExistsException extends GeneralException {
    public ObjectAlreadyExistsException() {
        super();
    }

    public ObjectAlreadyExistsException(String message) {
        super(message);
    }
}
