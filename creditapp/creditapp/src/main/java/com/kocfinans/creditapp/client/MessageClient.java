package com.kocfinans.creditapp.client;

import com.kocfinans.creditapp.exception.PhoneNumberUnacceptableException;
import org.slf4j.Logger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageClient implements IClient {

    private static final String phoneNumberRegex = "^[+0-9-\\(\\)\\s]*{6,14}$";

    @Override
    public void sendMessage(final String phoneNumber) {

        if(!validatePhoneNumber(phoneNumber))
            throw PhoneNumberUnacceptableException.create(phoneNumber);


        log.info("Message send to phoneNumber: " + phoneNumber);
    }

    @Override
    public Boolean validatePhoneNumber(final String phoneNumber) {
        if(phoneNumber == null)
        return Boolean.FALSE;

        return phoneNumber.matches(phoneNumberRegex);
    }
}
