package com.example.step10SpringCore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.example")
public class Step10SpringCoreApplication {

	public static void main(String[] args) {
		ApplicationContext context =
				SpringApplication.run(Step10SpringCoreApplication.class, args);


		OrderService orderService = context.getBean(OrderService.class);
		orderService.placeOrder();


	}


}
