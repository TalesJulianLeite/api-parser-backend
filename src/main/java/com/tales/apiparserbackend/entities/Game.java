package com.tales.apiparserbackend.entities;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4436419272875921363L;
	
	private Long id;
	private Integer number;
	private Integer total_kills;
	List<Player> players;
	private boolean game_shutdown;
	
	public Game() {
		
	}
	
	/**
	 * 
	 * @param id
	 * @param number
	 * @param total_kills
	 * @param players
	 */
	public Game(Integer number, Integer total_kills, List<Player> players) {
		this.number = number;
		this.total_kills = total_kills;
		this.players = players;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="number", nullable = false)
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer game_number) {
		this.number = game_number;
	}

	@Column(name="total_kills", nullable = true)
	public Integer getTotal_kills() {
		return total_kills;
	}
	
	public void setTotal_kills(Integer total_kills) {
		this.total_kills = total_kills;
	}
	
	@OneToMany(mappedBy= "game", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Transient
	public boolean isGame_shutdown() {
		return game_shutdown;
	}

	public void setGame_shutdown(boolean game_shutdown) {
		this.game_shutdown = game_shutdown;
	}

	@Override
	public String toString() {
		return "Game [number=" + number + ", total_kills=" + total_kills + "]";
	}	
	
}
