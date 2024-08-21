package com.tinder.ai.conversations.errors;

public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException(String message){
        super(message);
    }
}
