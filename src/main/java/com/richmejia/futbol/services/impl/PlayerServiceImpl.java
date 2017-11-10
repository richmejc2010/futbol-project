package com.richmejia.futbol.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.mongodb.MongoSocketOpenException;
import com.mongodb.MongoTimeoutException;
import com.richmejia.futbol.entities.Player;
import com.richmejia.futbol.exceptions.DataBaseException;
import com.richmejia.futbol.exceptions.GenericException;
import com.richmejia.futbol.exceptions.PlayerExistException;
import com.richmejia.futbol.exceptions.PlayerNotFoundException;
import com.richmejia.futbol.repositories.PlayerRepository;
import com.richmejia.futbol.services.PlayerService;

@Component
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository repositoryPlayer;

	@Override
	public String createPlayer(Player player) throws PlayerExistException, DataBaseException, GenericException {
		try {
			String result = "Player created successfully";
			if (playersById(player.getId()) == null) {
				repositoryPlayer.save(player);
			} else {
				result = "Player already exists";
				throw new PlayerExistException(result);
			}
			return result;
		} catch (PlayerExistException pe) {
			throw new PlayerExistException(pe.getMessage());
		} catch (MongoSocketOpenException mse) {
			throw new DataBaseException(mse.toString());
		} catch (MongoTimeoutException mte) {
			throw new DataBaseException(mte.toString());
		} catch (DataAccessResourceFailureException darf) {
			throw new DataBaseException(darf.toString());
		} catch (Exception e) {
			throw new GenericException(e.toString());
		}
	}

	@Override
	public String updatePlayer(Player player) throws PlayerNotFoundException, DataBaseException, GenericException {
		try {
			String result = "Player updated successfully";
			if (repositoryPlayer.findById(player.getId()) != null) {
				repositoryPlayer.save(player);
			} else {
				result = "Player not updated";
				throw new PlayerNotFoundException(result);
			}
			return result;
		} catch (PlayerNotFoundException pe) {
			throw new PlayerNotFoundException(pe.getMessage());
		} catch (MongoSocketOpenException mse) {
			throw new DataBaseException(mse.toString());
		} catch (MongoTimeoutException mte) {
			throw new DataBaseException(mte.toString());
		} catch (DataAccessResourceFailureException darf) {
			throw new DataBaseException(darf.toString());
		} catch (Exception e) {
			throw new GenericException(e.toString());
		}
	}

	@Override
	public String deletePlayer(String id) throws PlayerNotFoundException, DataBaseException, GenericException {
		try {
			String result = "Player deleted successfully";
			if (repositoryPlayer.findById(id) != null) {
				repositoryPlayer.delete(id);
			} else {
				result = "Player not deleted";
				throw new PlayerNotFoundException(result);
			}
			return result;
		} catch (PlayerNotFoundException pe) {
			throw new PlayerNotFoundException(pe.getMessage());
		} catch (MongoSocketOpenException mse) {
			throw new DataBaseException(mse.toString());
		} catch (MongoTimeoutException mte) {
			throw new DataBaseException(mte.toString());
		} catch (DataAccessResourceFailureException darf) {
			throw new DataBaseException(darf.toString());
		} catch (Exception e) {
			throw new GenericException(e.toString());
		}
	}

	@Override
	public List<Player> listPlayers(Player player) throws PlayerNotFoundException, DataBaseException, GenericException {
		if (!StringUtils.isEmpty(player.getId())) {
			List<Player> listPlayer = new ArrayList<>();
			listPlayer.add(repositoryPlayer.findById(player.getId()));
			return listPlayer;
		} else if (!StringUtils.isEmpty(player.getFullName())) {
			return repositoryPlayer.findByFullNameContainingIgnoreCase(player.getFullName());
		} else if (!StringUtils.isEmpty(player.getTeam().getId())) {
			return repositoryPlayer.findByTeam(player.getTeam().getId());
		} else{
			return repositoryPlayer.findAll();
		}

	}

	@Override
	public Player playersById(String id) throws PlayerNotFoundException, DataBaseException, GenericException {
		Player player = repositoryPlayer.findById(id);
		return player;
	}
}
