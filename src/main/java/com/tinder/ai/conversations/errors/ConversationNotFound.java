package com.tinder.ai.conversations.errors;

public class ConversationNotFound extends RuntimeException {
    public ConversationNotFound(String message) {
        super(message);
    }
}
