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
		return repository.save(player);
	}

	@Override
	public Player searchPlayer(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
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
		return repository.save(player);
	}

	@Override
	public String deletePlayer(String id) {
		// TODO Auto-generated method stub
		String result = "Success";
		try{
			repository.delete(id);
		}
		catch (Exception e){
			result = "Error: "+e.toString();
		}
		return result;
	}

	@Override
	public List<Player> listPlayer() {
		return repository.findAll();
	}

}
