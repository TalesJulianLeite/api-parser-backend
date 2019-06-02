package com.tales.apiparserbackend.dtos;

import java.util.List;

public class GameDto {
	
	private Long id;
	private Integer number;
	private Integer total_kills;
	List<PlayerDto> players;
	private boolean game_shutdown;
		
	public GameDto() {
			
	}
		
	/**
	 * 
	 * @param game_number
	 * @param total_kills
	 * @param players
	 */
	public GameDto(Long id, Integer game_number, Integer total_kills, List<PlayerDto> players) {
		this.number = game_number;
		this.total_kills = total_kills;
		this.players = players;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer game_number) {
		this.number = game_number;
	}

	public Integer getTotal_kills() {
		return total_kills;
	}

	public void setTotal_kills(Integer total_kills) {
		this.total_kills = total_kills;
	}

	public List<PlayerDto> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerDto> players) {
		this.players = players;
	}

	public boolean isGame_shutdown() {
		return game_shutdown;
	}

	public void setGame_shutdown(boolean game_shutdown) {
		this.game_shutdown = game_shutdown;
	}

	@Override
	public String toString() {
		String players = "";
		String kills = "";
		for(int i = 0; i <= this.getPlayers().size()-1; i++) {
			if(i == 0) {
				players += " \"" + this.getPlayers().get(i).getName()+ "\"";
				kills += "	 \"" + this.getPlayers().get(i).getName()+ "\"" + ": " + this.getPlayers().get(i).getKills();
			}
			else {
				players += ", \"" +  this.getPlayers().get(i).getName() + "\"";
				kills += "\n	 \"" + this.getPlayers().get(i).getName()+ "\"" + ", " +  + this.getPlayers().get(i).getKills();
			}
		}
		return "game_" + number + "{\n"
		+ "	total_kills: " + total_kills + ";\n"
		+ " 	players: [" + players + " ]\n"
		+ " 	kills: {\n" + kills + "\n	}\n}";
	}

}
