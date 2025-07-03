package com.onetouch.users.exception;

public class UserIdAlreadyExistsException extends RuntimeException {
    public UserIdAlreadyExistsException(String message) {
        super(message);
    }
}