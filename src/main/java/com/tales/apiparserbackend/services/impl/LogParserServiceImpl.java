package com.tales.apiparserbackend.services.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.tales.apiparserbackend.services.LogParserService;
import com.tales.apiparserbackend.utils.LogParserUtils;

@Service
public class LogParserServiceImpl implements LogParserService{

	@Autowired
	private LogParserUtils logParser = this.getLogParser();
	
	@Autowired
	private FileReaderUtilsServiceImpl fileReader;
	
	@Override
	public void doParser() {
		try {
			this.fileReader.readFile();
			FileReader fr = new FileReader(this.fileReader.getFile());
		    BufferedReader br = new BufferedReader(fr);
		    if(logParser == null) {
		    	logParser = new LogParserUtils();
		    }
		    String line;
		    if(fileReader.getFile().exists()) {
		    	logParser = new LogParserUtils();
			    while((line = br.readLine()) != null)
			    {
			    	logParser.parserLog(line);
			    }
			    br.close();
			    fr.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public LogParserUtils getLogParser() {
		return logParser;
	}

	public void setLogParser(LogParserUtils logParser) {
		this.logParser = logParser;
	}
	
	@Bean
	public LogParserUtils logParser() {
		return new LogParserUtils();
	}

}
