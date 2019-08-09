package com.sapient.springboot.contactservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("Starting the application...");
		SpringApplication.run(Application.class, args);
		System.out.println("Application started!");
	}

}
