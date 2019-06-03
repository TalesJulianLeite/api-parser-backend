package com.tales.apiparserbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.tales.apiparserbackend.controllers.GameController;
import com.tales.apiparserbackend.services.impl.FileReaderUtilsServiceImpl;
import com.tales.apiparserbackend.services.impl.LogParserServiceImpl;
import com.tales.apiparserbackend.utils.FileReaderUtils;
import com.tales.apiparserbackend.utils.LogParserUtils;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public FileReaderUtils fileReader() {
		return new FileReaderUtils();
	}

	@Bean
	public LogParserUtils logParser() {
		return new LogParserUtils();
	}

	@Bean 
	public LogParserServiceImpl logParserService() {
		return new LogParserServiceImpl();
	}
	
	@Bean 
	public FileReaderUtilsServiceImpl fileReaderUtilsServiceImpl() {
		return new FileReaderUtilsServiceImpl();
	}
	
	@Bean
	public GameController gameController() {
		return new GameController();
	}

}
