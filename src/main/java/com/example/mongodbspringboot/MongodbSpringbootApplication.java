package com.example.mongodbspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.mongodbspringboot")
public class MongodbSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbSpringbootApplication.class, args);
	}

}
