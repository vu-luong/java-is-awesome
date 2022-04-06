package com.vuluong.exception;

public class AuthenticationException extends RuntimeException {

    public AuthenticationException() {
        super("Username or password is incorrect!");
    }
}
