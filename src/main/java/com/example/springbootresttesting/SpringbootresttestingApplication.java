package com.example.springbootresttesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootresttestingApplication {
	public static final String BASE_PATH = "/api";

	public static void main(String[] args) {
		SpringApplication.run(SpringbootresttestingApplication.class, args);
	}
}
