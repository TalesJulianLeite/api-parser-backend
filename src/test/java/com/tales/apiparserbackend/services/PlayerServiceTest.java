package com.tales.apiparserbackend.services;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.tales.apiparserbackend.entities.Player;
import com.tales.apiparserbackend.repositories.PlayerRepository;

public class PlayerServiceTest {


	@MockBean
	private PlayerRepository playerRepository;

	@Autowired
	private PlayerService PlayerService;
	
	private static final Integer number = 4;
	private static final Integer game_number = 5;
	private static final String name = "Mal";
	
	@Before
	public void setUp() throws Exception {
		BDDMockito.given(this.playerRepository.findPlayerByNumber(Mockito.anyInt())).willReturn(new Player());
		BDDMockito.given(this.playerRepository.findAll(Mockito.anyList())).willReturn(new ArrayList<Player>());
		BDDMockito.given(this.playerRepository.findPlayerByGameNumber(Mockito.anyInt(), Mockito.anyInt())).willReturn(new Player());
		BDDMockito.given(this.playerRepository.findPlayersByGameNumber(Mockito.anyInt())).willReturn(new ArrayList<Player>());
		BDDMockito.given(this.playerRepository.save(Mockito.any(Player.class))).willReturn(new Player());
	}

	@Test
	public void testSearchPlayerByNumber() {
		Optional<Player> player = this.PlayerService.findPlayerByNumber(number);
		assertTrue(player.isPresent());
	}
	
	@Test
	public void testSearchPlayerByName() {
		Optional<Player> player = this.PlayerService.findPlayerByName(name);
		assertTrue(player.isPresent());
	}
	
	@Test
	public void testSearchPlayersByGameNumber() {
		Optional<List<Player>> player = this.PlayerService.findPlayersByGameNumber(game_number);
		assertTrue(player.isPresent());
	}
	
	@Test
	public void testSearchPlayerByGameNumber() {
		Optional<Player> player = this.PlayerService.findPlayerByGameNumber(game_number, number);
		assertTrue(player.isPresent());
	}
	
	@Test
	public void testSearchAllPlayers() {
		Optional<List<Player>> players = this.PlayerService.findAllPlayers();
		assertTrue(players.isPresent());
	}
	
	

}
