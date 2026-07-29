package com.example.step12Crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Step12CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Step12CrudApplication.class, args);

	}

}
