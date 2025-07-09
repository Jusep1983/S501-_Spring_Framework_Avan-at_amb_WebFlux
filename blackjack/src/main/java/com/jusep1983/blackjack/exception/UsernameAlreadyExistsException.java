package com.jusep1983.blackjack.exception;

public class UsernameAlreadyExistsException extends IllegalArgumentException {
    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}
