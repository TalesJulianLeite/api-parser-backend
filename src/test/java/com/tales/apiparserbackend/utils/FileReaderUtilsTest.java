package com.tales.apiparserbackend.utils;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FileReaderUtilsTest {

	@Autowired
	private FileReaderUtils fileReader;
	
	@Before
	public void setUp() throws Exception {
		this.fileReader = new FileReaderUtils();
	}
	
	@Test
	public void testFileIsNotNull() throws IOException {
		assertNotNull(this.fileReader.readFile());
	}
}
