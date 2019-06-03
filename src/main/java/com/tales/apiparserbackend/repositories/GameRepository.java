package com.tales.apiparserbackend.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tales.apiparserbackend.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
	
	List<Game> findAll();
	
	Game findGameByNumber(Integer number);
	
}
