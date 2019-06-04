package com.tales.apiparserbackend.dtos;

public class PlayerDto {
	
	private String name;
	private Integer kills;


	public PlayerDto() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getKills() {
		return kills;
	}

	public void setKills(Integer kills) {
		this.kills = kills;
	}

	@Override
	public String toString() {
		return name + ", kills=" + kills + "]";
	}


}
