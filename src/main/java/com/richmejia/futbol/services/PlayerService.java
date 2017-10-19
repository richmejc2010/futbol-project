package com.richmejia.futbol.services;

import java.util.List;

import com.richmejia.futbol.entities.Player;
import com.richmejia.futbol.exceptions.DataBaseException;
import com.richmejia.futbol.exceptions.GenericException;
import com.richmejia.futbol.exceptions.PlayerExistException;
import com.richmejia.futbol.exceptions.PlayerNotFoundException;

public interface PlayerService {

	String createPlayer(Player player) throws PlayerExistException, DataBaseException, GenericException;

	String updatePlayer(Player player) throws PlayerNotFoundException, DataBaseException, GenericException;

	String deletePlayer(long cc) throws PlayerNotFoundException, DataBaseException, GenericException;

	List<Player> listPlayers() throws PlayerNotFoundException, DataBaseException, GenericException;

	Player playersByCc(long cc) throws PlayerNotFoundException, DataBaseException, GenericException;

	List<Player> listPlayersByFullName(String fullName)
			throws PlayerNotFoundException, DataBaseException, GenericException;
}
