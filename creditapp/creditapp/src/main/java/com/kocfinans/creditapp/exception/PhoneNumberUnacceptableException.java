package com.kocfinans.creditapp.exception;


public class PhoneNumberUnacceptableException extends IllegalArgumentException {

    private final String phoneNumber;

    private PhoneNumberUnacceptableException(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static PhoneNumberUnacceptableException create(String phoneNumber) {
        return new PhoneNumberUnacceptableException(phoneNumber);
    }

    @Override
    public String getMessage() {
        return "Phone number cannot be  : " + phoneNumber;
    }
}
