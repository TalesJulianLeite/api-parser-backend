package com.tales.apiparserbackend.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.tales.apiparserbackend.dtos.GameDto;
import com.tales.apiparserbackend.dtos.PlayerDto;
import com.tales.apiparserbackend.entities.Game;
import com.tales.apiparserbackend.entities.Player;
import com.tales.apiparserbackend.repositories.GameRepository;
import com.tales.apiparserbackend.services.GameService;

@Service
public class GameServiceImpl implements GameService{
	
	private static final Logger log = LoggerFactory.getLogger(GameServiceImpl.class);
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private PlayerServiceImpl playerService = getPlayerService();
	
	@Autowired
	private LogParserServiceImpl logService;
	
	private List<Game> gameList;
	
	private List<Player> playerList;
	
	private HashMap<Integer, Player> playerMap;
	
	@Override
	public List<Game> findAllGames() {
		log.info("Searching all games");
		return gameRepository.findAll();
	}

	@Override
	public Optional<Game> findGameByNumber(Integer number) {
		log.info("Searching game number: {}", number);
		return Optional.ofNullable(gameRepository.findGameByNumber(number));
	}

	@Override
	public Game persistir(Game game) {
		log.info("Persisting game : {}", game);
		return this.gameRepository.save(game);
	}
	
	public void deleteAll() {
		if(this.gameList != null) {
			gameRepository.deleteAll();
		}
	}
	
	public static Logger getLog() {
		return log;
	}

	@Override
	public List<Game> persistAllGames(List<Game> games) {
		List<Game> gamesPersisted = new ArrayList<>();
		for(Game game : games) {
		    this.gameRepository.save(game);
		    gamesPersisted.add(game);
		}
		return gamesPersisted;
		
	}
	
	public void doParser() {
		this.playerService.deletePlayers();
		this.deleteAll();
		log.info("Parsing file...");
		this.logService.doParser();
		log.info("Persisting games...");
		this.setGameList();
		for(Game game : this.gameList) {
			this.persistir(game);
		}
		log.info("Persisting players...");
		this.setPlayerList();
		for(Player player : this.playerList) {
			System.out.println(player.toString());
			this.playerService.persistir(player);
		}
		
	}
		
	public void setGameList() {
		this.gameList = logService.getLogParser().getGameList();
	}
	
	public void setPlayerList() {
		this.playerList = this.logService.getLogParser().getPlayerList();
	}
	
	@Bean
	public PlayerServiceImpl getPlayerService() {
		return new PlayerServiceImpl();
	}

	public HashMap<Integer, Player> getPlayerMap() {
		return playerMap;
	}

	public void setPlayerMap(HashMap<Integer, Player> playerMap) {
		this.playerMap = playerMap;
	}
	
	public GameDto converterGameDto(Game game) {
		List<PlayerDto> playersDto = new ArrayList<>();
		GameDto gameDto = new GameDto();
		gameDto.setGame_(game.getId());
//		gameDto.setNumber(game.getNumber());
		gameDto.setTotal_kills(game.getTotal_kills());
		for(Player player : game.getPlayers()) {
			PlayerDto playerDto = new PlayerDto();
			playerDto.setName(player.getName());
			playerDto.setKills(player.getKills());
			playersDto.add(playerDto);
		}
		gameDto.setPlayers(playersDto);
		
		return gameDto;
	}
}
