package com.richmejia.futbol.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Component;

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
	private PlayerRepository repository;

	@Override
	public String createPlayer(Player player) throws PlayerExistException, DataBaseException, GenericException {
		try {
			String result = "Player created successfully";
			if (playersByCc(player.getCc()) == null) {
				repository.save(player);
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
			if (repository.findByCc(player.getCc()) != null) {
				player.setId(repository.findByCc(player.getCc()).getId());
				repository.save(player);
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
	public String deletePlayer(long cc) throws PlayerNotFoundException, DataBaseException, GenericException {
		try {
			String result = "Player deleted successfully";
			if (repository.findByCc(cc) != null) {
				repository.delete(repository.findByCc(cc).getId());
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
	public List<Player> listPlayers() throws PlayerNotFoundException, DataBaseException, GenericException {
		return repository.findAll();
	}

	@Override
	public Player playersByCc(long cc) throws PlayerNotFoundException, DataBaseException, GenericException {
		Player player = repository.findByCc(cc);
		return player;
	}

	@Override
	public List<Player> listPlayersByFullName(String fullName)
			throws PlayerNotFoundException, DataBaseException, GenericException {
		List<Player> listPlayer = new ArrayList<>();
		listPlayer.addAll(repository.findByFullNameLike(fullName) != null ? repository.findByFullNameLike(fullName)
				: new ArrayList<Player>());
		return listPlayer;
	}
}
