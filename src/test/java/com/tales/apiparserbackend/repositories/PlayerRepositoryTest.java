package com.tales.apiparserbackend.repositories;

import static org.junit.Assert.assertEquals;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.tales.apiparserbackend.entities.Game;
import com.tales.apiparserbackend.entities.Player;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PlayerRepositoryTest {

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private PlayerRepository playerRepository;
	
	private static final Integer number = 2;
	private static final Integer kills = 0;
	private static final Integer gameNumber = 1;
	
	@Before
	public void setUp() throws Exception {	
		Game game = this.gameRepository.save(getDataGame());
		this.playerRepository.save(getDataPlayer(game));
		
	}
	
	
	@After
	public final void tearDown() {
		this.gameRepository.deleteAll();
	}
	
	@Test
	public void testSearchPlayerByGameNumber() {
		List<Player> player = this.playerRepository.findPlayersByGameNumber(gameNumber);
		
		assertEquals(1, player.size());
	}
	
	@Test
	public void testSearchPlayerByNumber() {
		Player player = this.playerRepository.findPlayerByNumber(number);
		
		assertEquals(number, player.getNumber());
	}
	
	@Test
	public void testSearchPlayerByName() {
		Player player = this.playerRepository.findPlayerByName("Isgalamido");
		
		assertEquals("Isgalamido", player.getName());
	}
	
	@Test
	public void testQtdPlayerKills() {
		Player player = this.playerRepository.findPlayerByNumber(number);
		
		assertEquals(kills, player.getKills());
	}
	
	
	private Game getDataGame() {
		Game game = new Game();
		game.setNumber(1);
		game.setTotal_kills(0);
		return game;
	}
	
	private Player getDataPlayer(Game game) throws NoSuchAlgorithmException {
		Player player = new Player();
		player.setName("Isgalamido");
		player.setKills(0);
		player.setNumber(2);
		player.setGame(game);
		return player;
	}
	
}
