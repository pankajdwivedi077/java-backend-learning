package com.example.step5MicroservicesServiceRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Step5MicroservicesServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step5MicroservicesServiceRegistryApplication.class, args);
	}

}
