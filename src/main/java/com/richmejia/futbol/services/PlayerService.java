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

	String deletePlayer(String id) throws PlayerNotFoundException, DataBaseException, GenericException;

	List<Player> listPlayers(Player player) throws DataBaseException, GenericException;
}
