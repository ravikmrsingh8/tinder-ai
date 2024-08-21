package com.tinder.ai.config;

import org.springframework.ai.azure.openai.AzureOpenAiChatModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfig {

    @Autowired
    private AzureOpenAiChatModel chatModel;

    @Bean
    public ChatClient chatClient() {
        ChatClient.Builder builder = ChatClient.builder(chatModel);
        return builder.build();
    }
}
