package com.tales.apiparserbackend.repositories;

import java.util.List;

import javax.persistence.NamedQueries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.NamedQuery;
import com.tales.apiparserbackend.entities.Game;
import com.tales.apiparserbackend.entities.Player;

/**
 * @author Tales
 *
 */
@Transactional(readOnly = true)
@NamedQueries({
	@NamedQuery(name = "PlayerRepository.findPlayersByGameNumber",
			query = "SELECT p FROM player p WHERE p.game.number = :number")})
public interface PlayerRepository extends JpaRepository<Player, Long>{
	
	List<Player> findAll();
	
	List<Player> findPlayersByGameNumber(@Param("number") Integer gameNumber);
	
	List<Player> findPlayerByGame(Game game);
	
	Player findPlayerByNumber(Integer number);
	
	Player findPlayerByName(String name);
	
}
