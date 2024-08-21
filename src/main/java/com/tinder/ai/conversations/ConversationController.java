package com.tinder.ai.conversations;

import com.tinder.ai.conversations.errors.ConversationNotFound;
import com.tinder.ai.conversations.errors.ProfileNotFoundException;
import com.tinder.ai.profiles.ProfileRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class ConversationController {

    final private ConversationRepository conversationRepository;
    final private ProfileRepository profileRepository;

    public ConversationController(ConversationRepository conversationRepository, ProfileRepository profileRepository) {
        this.conversationRepository = conversationRepository;
        this.profileRepository = profileRepository;
    }


    @PostMapping("/conversations")
    public Conversation createConversation(@RequestBody CreateConversationRequest request) {
        String profileId = request.profileId();
        profileRepository.findById(profileId)
                .orElseThrow(() -> new ProfileNotFoundException(String.format("Profile %s not found!", profileId)));
        Conversation conversation = new Conversation();
        conversation.setId(UUID.randomUUID().toString());
        conversation.setProfileId(profileId);
        conversation.setMessages(new ArrayList<>());
        conversationRepository.save(conversation);
        return conversation;
    }


    @PostMapping("/conversations/{id}")
    public ChatMessage addMessageToConversation(@PathVariable("id") String conversationId,
                                                @RequestBody ChatMessage chatMessage) {
        //Validate conversationId
        Conversation conversation = conversationRepository.findById(conversationId)
                .orElseThrow(()-> new ConversationNotFound(
                        String.format("Conversation with id %s not found", conversationId)));

        //Validate authorId in chat message
        profileRepository.findById(chatMessage.getAuthorId())
                .orElseThrow(() -> new ProfileNotFoundException(
                        String.format("Profile %s not found!", chatMessage.getAuthorId())));

        // Add message in conversation
        chatMessage.setTime(LocalDateTime.now());
        chatMessage.setId(UUID.randomUUID().toString());

        // Update conversation object and save it
        conversation.getMessages().add(chatMessage);
        conversationRepository.save(conversation);


        return chatMessage;
    }


    @GetMapping("/conversations/{id}")
    public Conversation getConversation(@PathVariable("id") String conversationId) {
        return conversationRepository.findById(conversationId)
                .orElseThrow(()-> new ConversationNotFound(
                        String.format("Conversation with id %s not found", conversationId)));
    }

}
