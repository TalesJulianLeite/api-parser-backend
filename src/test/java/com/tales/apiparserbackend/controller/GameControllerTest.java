package com.tales.apiparserbackend.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.tales.apiparserbackend.services.impl.GameServiceImpl;

public class GameControllerTest {
	@LocalServerPort
	private static final int port = 8080;

	@Autowired
	private MockMvc mvc;

	
	@MockBean
	private GameServiceImpl gameService;

	@Before
	public void setUp() throws Exception {

	}

	
	@Test
	public void testBuscarEmpresaCnpjInvalido() throws Exception {
		BDDMockito.given(this.gameService.findAllGames());
		
		mvc.perform(MockMvcRequestBuilders.get("localhost:8080/all/games").accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.errors").value("Games not find"));
	}

}
