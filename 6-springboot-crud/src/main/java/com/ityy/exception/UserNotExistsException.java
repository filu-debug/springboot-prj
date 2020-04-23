package com.ityy.exception;

public class UserNotExistsException extends RuntimeException{
    public UserNotExistsException(String msg) {
        super(msg);
    }
}
