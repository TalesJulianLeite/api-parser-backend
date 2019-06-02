package com.tales.apiparserbackend.dtos;

public class PlayerDto {
	
	private Long id;
	private Integer number;
	private String name;
	private Integer kills;


	public PlayerDto() {

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

	public void setNumber(Integer player_number) {
		this.number = player_number;
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
