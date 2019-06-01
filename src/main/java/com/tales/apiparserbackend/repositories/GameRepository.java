package com.tales.apiparserbackend.repositories;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tales.apiparserbackend.entities.Game;

@Transactional(readOnly = true)
public interface GameRepository extends JpaRepository<Game, Long>{
	
	List<Game> findAll();
	
	Game findGameByNumber(Integer number);

}
