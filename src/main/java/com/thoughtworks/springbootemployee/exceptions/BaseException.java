package com.thoughtworks.springbootemployee.exceptions;

public class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }
}
