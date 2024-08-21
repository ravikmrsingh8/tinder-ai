package com.tinder.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TinderAiApplication implements CommandLineRunner {

	@Autowired
	ChatClient chatClient;

	public static void main(String[] args) {
		SpringApplication.run(TinderAiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String content = chatClient.prompt()
				.user("Who is jack sparrow?")
				.call()
				.content();
		System.out.println(content);
	}
}
