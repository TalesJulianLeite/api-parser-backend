package com.tales.apiparserbackend.controllers;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.tales.apiparserbackend.dtos.GameDto;
import com.tales.apiparserbackend.entities.Game;
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
	@GetMapping(value = "/all/games")
	@ResponseBody
	public List<GameDto> getAllGames() {
		log.info("Parsing log file...");
		gameService.doParser();
		log.info("Searching games");
		List<Game> games = gameService.findAllGames();
		List<GameDto> gamesDto = new ArrayList<>();
		for(Game game : games) {
			GameDto gameDto = new GameDto();
				gameDto = gameService.converterGameDto(game);
				gamesDto.add(gameDto);
		}
			System.out.println(gamesDto.toString());
		
		if (gamesDto.isEmpty()) {
            return null;
        }
		return gamesDto;
		
	}
	
}
