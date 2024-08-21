package com.tinder.ai;

import com.tinder.ai.conversations.ChatMessage;
import com.tinder.ai.conversations.Conversation;
import com.tinder.ai.conversations.ConversationRepository;
import com.tinder.ai.profiles.Gender;
import com.tinder.ai.profiles.Profile;
import com.tinder.ai.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class TinderAiApplication implements CommandLineRunner {

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	ConversationRepository conversationRepository;

	public static void main(String[] args) {
		SpringApplication.run(TinderAiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		saveProfile();
		saveConversation();
	}

	private void saveConversation() {

		ChatMessage message = new ChatMessage();
		message.setId("1");
		message.setText("Boom Boom ?");
		message.setTime(LocalDateTime.now());
		message.setAuthorId("1");

		Conversation conversation = new Conversation();
		conversation.setId("123");
		conversation.setProfileId("1");
		conversation.setMessages(List.of(message));
		message.setConversation(conversation);
		System.out.println("Printing COnversation" + conversation);
		conversationRepository.save(conversation);


		conversationRepository.findAll().forEach(System.out::println);
	}
	private void saveProfile() {
		Profile profile= new Profile();
		profile.setId("1");
		profile.getAge();
		profile.setFirstName("Ravi");
		profile.setLastName("Singh");
		profile.setAge(30);
		profile.setGender(Gender.MALE);
		profile.setEthnicity("Indian");
		profile.setBio("Boom!");
		profile.setImageUrl("ravi.jpg");
		profile.setPersonalityType("INTP");

		profileRepository.save(profile);

		profileRepository.findAll().forEach(System.out::println);
	}
}
