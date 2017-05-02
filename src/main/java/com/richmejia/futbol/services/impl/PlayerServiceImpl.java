package com.richmejia.futbol.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.richmejia.futbol.entities.Player;
import com.richmejia.futbol.repositories.PlayerRepository;
import com.richmejia.futbol.services.PlayerService;

@Component
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository repository;

	@Override
	public Player createPlayer(Player player) {
		// TODO Auto-generated method stub
		Player playerBack = new Player("", 1, "Junior PlayerServiceImpl created", 1, 1, 1);
		return repository.save(player);
	}

	@Override
	public Player searchPlayer(Player player) {
		// TODO Auto-generated method stub
		return new Player("", 1, "Junior PlayerServiceImpl Searched", 1, 1, 1);
	}

	@Override
	public Player addPlayer(Player player) {
		// TODO Auto-generated method stub
		player.setId("");
		player.setIdTeam(2);
		player.setPosition(3);
		player.setFullName("Richard Mejia PlayerServiceImpl added");
		return player;
	}

	@Override
	public Player editPlayer(Player player) {
		// TODO Auto-generated method stub
		return new Player("", 99999, "Ricardo Mejia Cerquera PlayerServiceImpl edited", 3333, 1111, 22222);
	}

	@Override
	public Player deletePlayer(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> listPlayer() {
		return repository.findAll();
	}

}
