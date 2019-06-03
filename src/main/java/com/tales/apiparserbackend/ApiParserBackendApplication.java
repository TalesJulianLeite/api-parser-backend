package com.tales.apiparserbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.tales.apiparserbackend.controllers.GameController;

@SpringBootApplication
@ComponentScan({"com.tales.apiparserbackend.services,"
		+ "com.tales.apiparserbackend.services.impl", "com.tales.apiparserbackend.utils"})
@EntityScan("com.tales.apiparserbackend.entities")
@EnableJpaRepositories("com.tales.apiparserbackend.repositories")
@EnableAutoConfiguration
public class ApiParserBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiParserBackendApplication.class, args);
	}

	@Bean
	public GameController gameController() {
		return new GameController();
	}
}
