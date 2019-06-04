package com.tales.apiparserbackend.dtos;

import java.util.List;

public class GameDto {
	
	private Long game_;
	List<PlayerDto> players;
	private Integer total_kills;
		
	public GameDto() {
			
	}
		
	/**
	 * 
	 * @param game_number
	 * @param total_kills
	 * @param players
	 */
	public GameDto(Long game_, Integer total_kills, List<PlayerDto> players) {
		this.game_ = game_;
		this.total_kills = total_kills;
		this.players = players;
	}
	
	public Long getGame_() {
		return game_;
	}

	public void setGame_(Long id) {
		this.game_ = id;
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


//	@Override
//	public String toString() {
//		String players = "";
//		String kills = "";
//		for(int i = 0; i <= this.getPlayers().size()-1; i++) {
//			if(i == 0) {
//				players += " \"" + this.getPlayers().get(i).getName()+ "\"";
//				kills += "	 \"" + this.getPlayers().get(i).getName()+ "\"" 
//				+ ": " + this.getPlayers().get(i).getKills();
//			}
//			else {
//				players += ", \"" +  this.getPlayers().get(i).getName() + "\"";
//				kills += "\n	 \"" + this.getPlayers().get(i).getName()+ "\"" 
//				+ ", " +  + this.getPlayers().get(i).getKills();
//			}
//		}
//		return "\ngame_" + number + ": {\n"
//		+ "	total_kills: " + total_kills + ";\n"
//		+ " 	players: [" + players + " ]\n"
//		+ " 	kills: {\n" + kills + "\n	}\n} \n\n";
//	}

}
