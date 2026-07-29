package com.example.step11ApplicationProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Step11ApplicationPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext context =
				SpringApplication.run(Step11ApplicationPropertiesApplication.class, args);

	//	PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);

	//	paymentGateway.setType("paytm");
	//	paymentGateway.setRetryCount(5);

	//	System.out.println(paymentGateway.getType());
	//	System.out.println(paymentGateway.getRetryCount());

	//	paymentGateway.print();
	}

}
