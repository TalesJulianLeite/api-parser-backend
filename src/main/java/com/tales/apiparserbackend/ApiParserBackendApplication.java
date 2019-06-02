package com.tales.apiparserbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.tales.apiparserbackend.repositories", "com.tales.apiparserbackend.services,"
		+ "com.tales.apiparserbackend.services.impl", "com.tales.apiparserbackend.utils"})
@EntityScan("com.tales.apiparserbackend.entities")
public class ApiParserBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiParserBackendApplication.class, args);
	}

}
