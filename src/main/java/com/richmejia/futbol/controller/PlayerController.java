package com.richmejia.futbol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.richmejia.futbol.entities.Player;
import com.richmejia.futbol.services.PlayerService;

@RestController
public class PlayerController {

	@Autowired
	PlayerService playerService;

	@RequestMapping(value = "/api/player/", method = RequestMethod.POST)
	public Player createPlayer(Player newPlayer) {
		return playerService.createPlayer(newPlayer);
	}

	@RequestMapping("/api/player/{id}")
	public Player searchPlayer(@PathVariable(value = "id") String id) {
		return playerService.searchPlayer(id);
	}

	@RequestMapping(value = "/api/player/{id}", method = RequestMethod.POST)
	public Player editPlayer(@PathVariable(value = "id") String id, Player newPlayer) {
		return playerService.editPlayer(newPlayer);
	}

	@RequestMapping(value = "/api/player/{id}", method = RequestMethod.DELETE)
	public String deletePlayer(@PathVariable(value = "id") String id) {
		return playerService.deletePlayer(id);
	}

	@RequestMapping(value = "/api/player/lists/", method = RequestMethod.GET)
	public List<Player> listPlayers() {
		return playerService.listPlayer();
	}
}
