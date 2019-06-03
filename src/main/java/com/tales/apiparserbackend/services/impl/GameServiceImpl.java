package com.tales.apiparserbackend.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tales.apiparserbackend.entities.Game;
import com.tales.apiparserbackend.repositories.GameRepository;
import com.tales.apiparserbackend.services.GameService;

@Service
public class GameServiceImpl implements GameService{
	
	private static final Logger log = LoggerFactory.getLogger(GameServiceImpl.class);
	
	@Autowired
	private GameRepository gameRepository;
	
	@Override
	public Optional<List<Game>> findAllGames() {
		log.info("Searching all games");
		return Optional.ofNullable(gameRepository.findAll());
	}

	@Override
	public Optional<Game> findGameByNumber(Integer number) {
		log.info("Searching game number: {}", number);
		return Optional.ofNullable(gameRepository.findGameByNumber(number));
	}

	@Override
	public Game persistir(Game game) {
		log.info("Persisting game : {}", game);
		return this.gameRepository.save(game);
	}
	
	public static Logger getLog() {
		return log;
	}

	@Override
	public List<Game> persistAllGames(List<Game> games) {
		List<Game> gamesPersisted = new ArrayList<>();
		for(Game game : games) {
		    this.gameRepository.save(game);
		    gamesPersisted.add(game);
		}
		return gamesPersisted;
		
	}

}
