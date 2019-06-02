package com.tales.apiparserbackend.utils;

import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileReaderUtils{
	
	private static final Logger log = LoggerFactory.getLogger(FileReaderUtils.class);
	
	private File file;
	
	public FileReaderUtils() {
		
	}
	/**
	 * Read lines from archive
	 * @throws IOException
	 * @return File
	 */
	public File readFile() throws IOException{
		String fileName = "log/games.log";
	    ClassLoader classLoader = new FileReaderUtils().getClass().getClassLoader();
	
	    File file = new File(classLoader.getResource(fileName).getFile());
		this.setFile(file);
		//Verify if file is found
		if(this.file.exists()) {
			System.out.println("File Found : " + file.exists());
		}
	    return file;
	}
	
	public static Logger getLog() {
		return log;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
}
