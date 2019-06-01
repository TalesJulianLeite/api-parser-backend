package com.tales.apiparserbackend.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.tales.apiparserbackend.entities.Game;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class GameRepositoryTest {

	@Autowired
	private GameRepository gameRepository;
	
	private static final Integer number = 1;
	private static final Integer total_kills = 17;
	
	
	@Before
	public void setUp() throws Exception {
		Game game = new Game();
		game.setNumber(number);
		game.setTotal_kills(total_kills);
		this.gameRepository.save(game);
	}
	
	
	@After
	public final void tearDown() {
		this.gameRepository.deleteAll();
	}
	
	@Test
	public void testSearchByNumber() {
		Game game = this.gameRepository.findGameByNumber(number);
		
		assertEquals(number, game.getNumber());
	}

	
}
