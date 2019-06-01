package com.tales.apiparserbackend.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1038869971280729101L;
	private Long id;
	private Integer number;
	private String name;
	private Integer kills;
	private Game game;
	
	
	public Player() {
		
	}
		
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Column(name = "number", nullable = false)
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer player_number) {
		this.number = player_number;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "kills", nullable = true)
	public Integer getKills() {
		return kills;
	}
	
	public void setKills(Integer kills) {
		this.kills = kills;
	}

	@ManyToOne(fetch= FetchType.EAGER)
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", kills=" + kills + "]";
	}

	

}
