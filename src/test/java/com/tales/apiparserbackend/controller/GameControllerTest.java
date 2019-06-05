package com.tales.apiparserbackend.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;

import com.tales.apiparserbackend.controllers.GameController;
import com.tales.apiparserbackend.entities.Game;

public class GameControllerTest {
	@LocalServerPort
    private static final int port = 8080;

    @Autowired
    private GameController gameController;
    
    @Before
    public void setUp() throws Exception{
    	
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
    	Game game = new Game();
    	extracted(game).setId(21L);
    	extracted(game).setTotal_kills(131);
        assert(gameController.getAllGames().contains(extracted(game)));
    }

	private Game extracted(Game game) {
		return game;
	}
}
