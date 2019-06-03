package com.tales.apiparserbackend.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tales.apiparserbackend.dtos.GameDto;
import com.tales.apiparserbackend.dtos.PlayerDto;
import com.tales.apiparserbackend.entities.Game;
import com.tales.apiparserbackend.entities.Player;
import com.tales.apiparserbackend.responses.ResponseGames;
import com.tales.apiparserbackend.services.impl.GameServiceImpl;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class GameController {
	
	private static final Logger log = LoggerFactory.getLogger(GameController.class);
	
	@Autowired
	private GameServiceImpl gameService;
	
	/**
	 * Return a list of games
	 * 
	 * @return ResponseEntity<Response<GameDto>>
	 */
	@GetMapping(value = "/games")
	public ResponseEntity<ResponseGames<GameDto>> findGames() {
		log.info("Parsing log file...");
		gameService.doParser();
		log.info("Searching games");
		ResponseGames<GameDto> response = new ResponseGames<GameDto>();
		Optional<List<Game>> games = gameService.findAllGames();
//		Optional<List<Game>> games = gameService.findGameByNumber(number);
		Optional<List<GameDto>> gamesDto = games.map(obj -> converterGameDto(obj)); 
		if (!gamesDto.isPresent()) {
			log.info("Games not find");
			response.getErrors().add("Games not find");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(gamesDto);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Popula um DTO com os dados de um game.
	 * 
	 * @param game
	 * @return GameDto
	 */
	private List<GameDto> converterGameDto(List<Game> games) {
		List<PlayerDto> players = new ArrayList<>();
		List<GameDto> gamesDto = new ArrayList<>();
		
		for(Game game : games) {
			GameDto gameDto = new GameDto();
			gameDto.setId(game.getId());
			gameDto.setNumber(game.getNumber());
			gameDto.setTotal_kills(game.getTotal_kills());
			for(Player player : game.getPlayers()) {
				PlayerDto playerDto = new PlayerDto();
				playerDto.setId(player.getId());
				playerDto.setName(player.getName());
				playerDto.setNumber(player.getNumber());
				playerDto.setKills(player.getKills());
				players.add(playerDto);
			}
			gameDto.setPlayers(players);
			gamesDto.add(gameDto);
		}
		return gamesDto;
	}
}
