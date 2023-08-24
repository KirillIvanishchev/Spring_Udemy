package com.myapp.RESTful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//In this Example we use Auto REST feature from Spring-rest.
// We don't need to use @RestController annotation, because REST API
// is created automatically by Spring-rest.
// As well, we don't need @Repository annotation, because DB connection
// is created automatically by Spring-rest.
//So no BASIC REPOSITORY and REST is needed.
@SpringBootApplication
public class ResTfulApplication {
	public static void main(String[] args) {
		SpringApplication.run(ResTfulApplication.class, args);
	}
}
