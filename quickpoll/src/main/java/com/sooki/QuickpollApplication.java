package com.sooki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuickpollApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickpollApplication.class, args);
		System.out.println("the application was started");
	}
}