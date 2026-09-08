package com.example.step33OAuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Step33OAuthApplication {

	public static void main(String[] args) {

		SpringApplication.run(Step33OAuthApplication.class, args);
		System.out.println("name " + System.getProperty("PANKAJ"));
		System.out.println("ID: " + System.getProperty("GOOGLE_CLIENT_ID", System.getenv("GOOGLE_CLIENT_ID")));
	}

}
