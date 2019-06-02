package com.tales.apiparserbackend.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.tales.apiparserbackend.entities.Game;
import com.tales.apiparserbackend.repositories.GameRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class GameServiceTest {

	@MockBean
	private GameRepository gameRepository;

	@Autowired
	private GameService gameService;
	
	private static final Integer number = 2;
	
	@Before
	public void setUp() throws Exception {
		BDDMockito.given(this.gameRepository.findGameByNumber(Mockito.anyInt())).willReturn(new Game());
		BDDMockito.given(this.gameRepository.findAll(Mockito.anyList())).willReturn(new ArrayList<Game>());
		BDDMockito.given(this.gameRepository.save(Mockito.any(Game.class))).willReturn(new Game());
	}

	@Test
	public void testSearchGameByNumber() {
		Optional<Game> game = this.gameService.findGameByNumber(number);
		assertTrue(game.isPresent());
	}
	
	@Test
	public void testSearchAllGames() {
		Optional<List<Game>> games = this.gameService.findAllGames();
		assertTrue(games.isPresent());
	}
	
	
	@Test
	public void testPersistGame() {
		Game game = this.gameService.persistir(new Game());

		assertNotNull(game);
	}
}
