package com.tales.apiparserbackend.services;

import java.util.List;
import java.util.Optional;
import com.tales.apiparserbackend.entities.Player;

public interface PlayerService {

	/**
	 * Return all players
	 * @return
	 */
	Optional<List<Player>> findAllPlayers();
	
	/**
	 * Return players by game number
	 * @param gameNumber
	 * @return
	 */
	Optional<List<Player>> findPlayersByGameNumber(Integer gameNumber);
	
	/**
	 * Return player by number
	 * @param number
	 * @return
	 */
	Optional<Player> findPlayerByNumber(Integer number);
	
	/**
	 * 
	 * Return player by name
	 * @param name
	 * @return
	 */
	Optional<Player> findPlayerByName(String name);
	
	/**
	 * Persist a player
	 * @param player
	 * @return
	 */
	public Player persistir(Player player);
	
	
	/**
	 * Persist a list of players
	 * @param players
	 * @return
	 */
	public List<Player> persistAllPlayers(List<Player> players);
	
}
