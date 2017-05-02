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
		Player player = new Player(id, 0, "", 0, 0, 0);
		return playerService.searchPlayer(player);
	}

	@RequestMapping(value = "/api/player/{id}", method = RequestMethod.PUT)
	public Player editPlayer(@PathVariable(value = "id") String id) {
		Player player = new Player(id, 0, "", 0, 0, 0);
		return playerService.editPlayer(player);
	}

	@RequestMapping(value = "/api/player/{id}", method = RequestMethod.DELETE)
	public Player deletePlayer(@PathVariable(value = "id") String id) {
		return playerService.deletePlayer(new Player("", 2, "Barcelona", 2, 2, 2));
	}

	@RequestMapping(value = "/api/player/lists/", method = RequestMethod.GET)
	public List<Player> listPlayers() {
		return playerService.listPlayer();
	}
}
