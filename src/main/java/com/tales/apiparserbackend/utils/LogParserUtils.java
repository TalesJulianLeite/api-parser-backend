package com.tales.apiparserbackend.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tales.apiparserbackend.entities.Game;
import com.tales.apiparserbackend.entities.Player;

public class LogParserUtils {
	
	private static final Logger log = LoggerFactory.getLogger(LogParserUtils.class);
	
	private List<Game> games;
	private int id_game;
	private int total_kills;
	private int id_client = 0;
	private boolean game_shutdown;
	private List<Player> playersGame;
	private List<Player> players;
	private Matcher matchPlayer;
	HashMap<Integer, Player> mapPlayers;
	
	public LogParserUtils() {
		this.games = new ArrayList<Game>();
		this.id_game = 0;
		this.total_kills = 0;
		this.players = new ArrayList<Player>();
		this.playersGame = new ArrayList<Player>();
		this.mapPlayers = null;
	}
	

	//Do parser of log's archive
	public void parserLog(String line) {
		//Verify if game start and create a new Game
        if(line.contains("InitGame:")){
        		total_kills = 0;
	        	mapPlayers = new HashMap<>();
	        	playersGame = new ArrayList<Player>();
	        	id_game++;
	        	Game game = new Game();
	        	game.setNumber(id_game);
	        	game.setGame_shutdown(false);
	        	game.setPlayers(players);
	        	game.setTotal_kills(0);
	        	this.games.add(game);
        }
        else if(line.contains("ClientUserinfoChanged:")) {
        	String[] line_split = line.split(":");
				int player_id;
				String player_name = null;
				player_id = Integer.parseInt(line_split[2].trim().substring(0, 1));
				int nameStart = line_split[2].trim().indexOf("n\\");
				int nameEnd = line_split[2].trim().indexOf("\\t\\");
					if (nameStart == 0 || nameEnd == 0) {
						player_name = "";
					}
					else {
						player_name = line_split[2].substring(nameStart + 3, nameEnd + 1);
					}

					System.out.println("Game_" + id_game + " Id Player = " + player_id + " Name = " + player_name);
					Player player = new Player();
					player.setNumber(player_id);
					player.setName(player_name);
					player.setKills(0);
					if(mapPlayers != null) {
						if(mapPlayers.containsKey(player.getNumber())) {
							ReplaceNamePlayer(mapPlayers, player_id, player_name);
							mapPlayers.replace(player.getNumber(), player);
						}
						else {
							mapPlayers.put(player.getNumber(), player);
						}
					}
        }
        //Verify if list of games is null
        else if(line.contains("Kill:")) {
        	total_kills++;
        	Game game = new Game();
        	game = games.get(id_game-1);
        	Player killer = new Player();
        	Player killed = new Player();
        	game.setTotal_kills(total_kills);
        	String[] line_split_kill = line.split(":");
        	String[] split_cod_kill = line_split_kill[2].split(" ");
        	int id_killer = Integer.parseInt(split_cod_kill[1]);
        	int id_killed = Integer.parseInt(split_cod_kill[2]);
        	killer.setNumber(id_killer);
        	killed.setNumber(id_killed);
        	if(line_split_kill[3].contains("<world>") && id_killer == 1022) {
        		IncrementOrDecrementKill(mapPlayers, id_killed, false);
        	}
        	else if(id_killed != id_killer) {
        		IncrementOrDecrementKill(mapPlayers, id_killer, true);
        	}
        	else if(id_killed == id_killer) {
        		IncrementOrDecrementKill(mapPlayers, id_killed, false);
        	}
        	
        }
        else if(line.contains("ShutdownGame:") || line.contains("-------------")){
        	if(mapPlayers != null) {
        		setListPlayers();
        		for(Player player : playersGame) {
        			this.players.add(player);
        			System.out.println(player);
        		}
        		games.get(id_game-1).setPlayers(playersGame);
        		games.get(id_game-1).setTotal_kills(total_kills);
        		
        	}
        }
	}

	/**
	 * Replace name of player
	 * @param players
	 * @param player_id
	 * @param name
	 */
	public void ReplaceNamePlayer(HashMap<Integer, Player> players, Integer player_id, String name) {
		Player player = new Player();
		for(@SuppressWarnings("rawtypes") Map.Entry p : players.entrySet()) {
			if(p.getKey().equals(player_id)) {
				player = mapPlayers.get(player_id);
				player.setName(name);
				mapPlayers.put(player_id, player);
			}
		}
		
	}
	
	/**
	 * Increment or decrement kill of player
	 * @param players
	 * @param player_id
	 * @param increment
	 */
	public void IncrementOrDecrementKill(HashMap<Integer, Player> players, Integer player_id, boolean increment) {
		Player player = new Player();
		for(@SuppressWarnings("rawtypes") Map.Entry p : players.entrySet()) {
			if(p.getKey().equals(player_id)) {
				player = mapPlayers.get(player_id);
				if(increment) {
					player.setKills(player.getKills()+1);
				}
				else {
					player.setKills(player.getKills()-1);
				}
				mapPlayers.put(player_id, player);
			}
		}
	}
	
	/**
	 * Set list of players
	 */
	public void setListPlayers() {
		if(!this.games.get(id_game-1).isGame_shutdown()) {
			for(@SuppressWarnings("rawtypes") Map.Entry p : this.mapPlayers.entrySet()) {
				Player player = (Player) p.getValue();
				player.setGame(this.games.get(id_game-1));
				this.playersGame.add(player);
			}
			this.games.get(id_game-1).setGame_shutdown(true);
		}
	}

	public Integer getId_client() {
		return id_client;
	}


	public void setId_client(Integer id_client) {
		this.id_client = id_client;
	}


	public int getTotal_kills() {
		return total_kills;
	}


	public void setTotal_kills(int total_kills) {
		this.total_kills = total_kills;
	}


	public Matcher getMatchPlayer() {
		return matchPlayer;
	}


	public void setMatchPlayer(Matcher matchPlayer) {
		this.matchPlayer = matchPlayer;
	}


	public boolean isGame_shutdown() {
		return game_shutdown;
	}


	public void setGame_shutdown(boolean game_shutdown) {
		this.game_shutdown = game_shutdown;
	}

	

	public static Logger getLog() {
		return log;
	}

	public List<Player> getPlayerList(){
		return this.players; 
	}
	
	public List<Game> getGameList(){
		return this.games;
	}
}
