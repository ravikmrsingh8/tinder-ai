package com.tinder.ai.conversations;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Conversation {
    @Id
    @Column(name="ConversationId")
    private String id;
    private String profileId;

    @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ChatMessage> messages;

    public Conversation() {
    }

    public String getId() {
        return id;
    }

    public void setId(String conversationId) {
        this.id = conversationId;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Conversation[" +
                "conversationId='" + id + '\'' +
                ", profileId='" + profileId + '\'' +
                ", messages=" + messages +
                ']';
    }
}
