package com.tales.apiparserbackend.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tales.apiparserbackend.entities.Game;


public class FileReadUtils{
	
	private static final Logger log = LoggerFactory.getLogger(FileReadUtils.class);
	
	@Autowired
	private LogParserUtils logParser;

	private List<Game> list;
	
	public FileReadUtils() {
		
	}
	/**
	 * Read lines from archive
	 * @throws IOException
	 */
	public void readLinesUsingFileReader() throws IOException{
		String fileName = "log/games.log";
	    ClassLoader classLoader = new FileReadUtils().getClass().getClassLoader();
	
	    try {
	    	File file = new File(classLoader.getResource(fileName).getFile());
	     
		    //Verify if file is found
		    System.out.println("File Found : " + file.exists());
		 
		    FileReader fr = new FileReader(file);
		    BufferedReader br = new BufferedReader(fr);
		 
		    String line;
		    setList(new ArrayList<>());
		    if(file.exists()) {
			    while((line = br.readLine()) != null)
			    {
			    	this.logParser.parserLog(line);
			    }
			    br.close();
			    fr.close();
			}
	    }
	    catch(IOException ex) {
	    	ex.printStackTrace();
	    }
	}
	public static Logger getLog() {
		return log;
	}
	public List<Game> getList() {
		return list;
	}
	public void setList(List<Game> list) {
		this.list = list;
	}

}
