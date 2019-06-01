package com.tales.apiparserbackend.services;

import java.util.List;
import java.util.Optional;

import com.tales.apiparserbackend.entities.Game;

public interface GameService {

	
	/**
	 * Return all games
	 * @return
	 */
	Optional<List<Game>> findAllGames();
	
	/**
	 * Return game by number
	 * @return
	 */
	Optional<Game> findGameByNumber(Integer number);
	
	/**
	 * Persist a game
	 * @param game
	 * @return
	 */
	Game persistir(Game game);
	
	/**
	 * Persist a list of games
	 * @param games
	 * @return
	 */
	List<Game> persistAllGames(List<Game> games);
	
}
