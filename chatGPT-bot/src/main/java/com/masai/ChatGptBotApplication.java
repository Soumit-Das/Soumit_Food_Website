package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.masai")
public class ChatGptBotApplication {

	public static void main(String[] args) {
		System.out.println();
		System.out.println("                                  -=-=-=-=-=-=-=-=-=-=-=-=-=- Application is starting to run -=-=-=-=-=-=-=-=-=-=-=-=-=-");
		SpringApplication.run(ChatGptBotApplication.class, args);
		System.out.println();
		System.out.println("                                  -=-=-=-=-=-=-=-=-=-=-=-=-=- Application is working fine -=-=-=-=-=-=-=-=-=-=-=-=-=-");
	}

}
