package com.kocfinans.creditapp.exception;


public class IdentityNotFoundException extends IllegalArgumentException {

    private final String message;

    private IdentityNotFoundException(String message) {
        this.message = message;
    }

    public static IdentityNotFoundException create(String message) {
        return new IdentityNotFoundException(message);
    }

    @Override
    public String getMessage() {
        return "Credit Score not found for Identity Number : " + message;
    }
}
