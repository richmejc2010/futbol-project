package com.richmejia.futbol.services;

import java.util.List;

import com.richmejia.futbol.entities.Player;

public interface PlayerService {

	Player createPlayer(Player player);

	Player searchPlayer(String id);

	Player addPlayer(Player player);

	Player editPlayer(Player player);

	String deletePlayer(String id);

	List<Player> listPlayer();
}
