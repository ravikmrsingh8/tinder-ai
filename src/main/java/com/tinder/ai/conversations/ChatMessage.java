package com.tinder.ai.conversations;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ChatMessage {
    @Id
    @Column(name="MessageId")
    private String id;
    private String text;
    private String authorId;
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name="ConversationId")
    private Conversation conversation;

    public ChatMessage() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    @Override
    public String toString() {
        return "ChatMessage[" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", authorId='" + authorId + '\'' +
                ", time=" + time +
                ", conversation=" + conversation.getId() +
                ']';
    }
}
