package com.robots.bumblebee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;


@EnableMongoAuditing
@SpringBootApplication
public class BumblebeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BumblebeeApplication.class, args);
	}

}
