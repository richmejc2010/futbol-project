package com.richmejia.futbol.services;

import java.util.List;

import com.richmejia.futbol.entities.Player;

public interface PlayerService {

	Player createPlayer(Player player);

	Player searchPlayer(Player player);

	Player addPlayer(Player player);

	Player editPlayer(Player player);

	Player deletePlayer(Player player);

	List<Player> listPlayer();
}
