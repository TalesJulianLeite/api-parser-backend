package com.tales.apiparserbackend.services;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.tales.apiparserbackend.utils.LogParserUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ParserServiceImplTest {

	@Autowired
	private LogParserUtils logParser;
	
	@Autowired
	private LogParseService parserService;
	
}
