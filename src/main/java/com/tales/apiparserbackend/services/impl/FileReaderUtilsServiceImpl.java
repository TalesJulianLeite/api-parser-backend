package com.tales.apiparserbackend.services.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import com.tales.apiparserbackend.services.FileReaderUtilsService;
import com.tales.apiparserbackend.utils.FileReaderUtils;

@Service
@ComponentScan("com.tales.apiparserbackend.utils")
public class FileReaderUtilsServiceImpl implements FileReaderUtilsService{

	@Autowired
	private FileReaderUtils fileReader = getFileReader();
	
	private File file = null;
	
	@Override
	public File readFile() throws IOException {
		try {
			if(fileReader != null) {
				this.file = fileReader.readFile();
			}
			else {
				fileReader = new FileReaderUtils();
				this.file = fileReader.readFile();
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return file;
	}

	public FileReaderUtils getFileReader() {
		return fileReader;
	}

	public void setFileReader(FileReaderUtils fileReader) {
		this.fileReader = fileReader;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Bean
	public FileReaderUtils getfileReader() {
		return new FileReaderUtils();
	}
}
