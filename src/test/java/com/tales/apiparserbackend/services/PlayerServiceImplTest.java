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
import com.tales.apiparserbackend.entities.Player;
import com.tales.apiparserbackend.repositories.PlayerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PlayerServiceImplTest {

	@MockBean
	private PlayerRepository playerRepository;

	@Autowired
	private PlayerService playerService;

	private static final Integer number = 2;

	private static final String name = "Mal";

	private static final Integer gameNumber = 4;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		BDDMockito.given(this.playerRepository.findPlayerByNumber(Mockito.anyInt())).willReturn(new Player());
		BDDMockito.given(this.playerRepository.findAll(Mockito.anyList())).willReturn(new ArrayList<Player>());
		BDDMockito.given(this.playerRepository.findPlayerByName(Mockito.anyString())).willReturn(new Player());
		BDDMockito.given(this.playerRepository.findPlayersByGameNumber(Mockito.anyInt())).willReturn(new ArrayList<Player>());
		BDDMockito.given(this.playerRepository.save(Mockito.any(Player.class))).willReturn(new Player());
	}

	@Test
	public void testSearchGameByNumber() {
		Optional<Player> player = this.playerService.findPlayerByNumber(number);
		assertTrue(player.isPresent());
	}

	@Test
	public void testSearchAllGames() {
		Optional<List<Player>> players = this.playerService.findAllPlayers();
		assertNotNull(players);
		assertTrue(players.isPresent());
	}


	@Test
	public void testPersistPlayer() {
		Player player = this.playerService.persistir(new Player());

		assertNotNull(player);
	}

	public static Integer getGamenumber() {
		return gameNumber;
	}

	public static String getName() {
		return name;
	}
}

