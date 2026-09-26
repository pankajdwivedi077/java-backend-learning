package com.example.step5MicroservicesQuizS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Step5MicroservicesQuizSApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step5MicroservicesQuizSApplication.class, args);
	}

}
