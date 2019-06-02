package com.tales.apiparserbackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.tales.apiparserbackend.utils.FileReadUtils;
import com.tales.apiparserbackend.utils.LogParserUtils;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public FileReadUtils fileReader() {
		return new FileReadUtils();
	}

	@Bean
	public LogParserUtils logParser() {
		return new LogParserUtils();
	}

	

}
