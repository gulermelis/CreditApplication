package com.kocfinans.creditapp.client;


public interface IClient {
    void sendMessage(final String phoneNumber);
    Boolean validatePhoneNumber(final String phoneNumber);
}
