package com.richmejia.futbol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.richmejia.futbol.entities.MessageJson;
import com.richmejia.futbol.entities.Player;
import com.richmejia.futbol.entities.Team;
import com.richmejia.futbol.exceptions.DataBaseException;
import com.richmejia.futbol.exceptions.GenericException;
import com.richmejia.futbol.exceptions.PlayerExistException;
import com.richmejia.futbol.exceptions.PlayerNotFoundException;
import com.richmejia.futbol.services.PlayerService;

@RestController
public class PlayerController {

	@Autowired
	PlayerService playerService;

	@RequestMapping(value = "/api/player/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createPlayer(@RequestBody Player newPlayer) {
		try {
			String jsonResp = playerService.createPlayer(newPlayer);
			return new ResponseEntity<>(new MessageJson("OK", jsonResp), HttpStatus.OK);
		} catch (PlayerExistException pe) {
			return new ResponseEntity<>(new MessageJson("PlayerExistException", pe.getMessage()),
					HttpStatus.BAD_REQUEST);
		} catch (DataBaseException db) {
			return new ResponseEntity<>(new MessageJson("DataBaseException", db.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GenericException ge) {
			return new ResponseEntity<>(new MessageJson("GenericException", ge.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/api/player/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updatePlayer(@PathVariable("id") String id, @RequestBody Player newPlayer) {
		try {
			newPlayer.setId(id);
			String jsonResp = playerService.updatePlayer(newPlayer);
			return new ResponseEntity<>(new MessageJson("OK", jsonResp), HttpStatus.OK);
		} catch (PlayerNotFoundException pe) {
			return new ResponseEntity<>(new MessageJson("PlayerNotFoundException", pe.getMessage()),
					HttpStatus.BAD_REQUEST);
		} catch (DataBaseException db) {
			return new ResponseEntity<>(new MessageJson("DataBaseException", db.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GenericException ge) {
			return new ResponseEntity<>(new MessageJson("GenericException", ge.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/api/player/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePlayer(@PathVariable("id") String id) {
		try {
			String jsonResp = playerService.deletePlayer(id);
			return new ResponseEntity<>(new MessageJson("OK", jsonResp), HttpStatus.OK);
		} catch (PlayerNotFoundException pe) {
			return new ResponseEntity<>(new MessageJson("PlayerNotFoundException", pe.getMessage()),
					HttpStatus.BAD_REQUEST);
		} catch (DataBaseException db) {
			return new ResponseEntity<>(new MessageJson("DataBaseException", db.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GenericException ge) {
			return new ResponseEntity<>(new MessageJson("GenericException", ge.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/api/player", method = RequestMethod.GET)
	public ResponseEntity<?> listPlayers(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "fullName", required = false) String fullName,
			@RequestParam(value = "team", required = false) String codTeam) {
		try {
			Team team = new Team();
			team.setId(codTeam);
			Player player = new Player(id, team, fullName, 0, 0, 0);
			List<Player> listPlayer = playerService.listPlayers(player);
			return new ResponseEntity<>(listPlayer, HttpStatus.OK);
		} catch (DataBaseException db) {
			return new ResponseEntity<>(new MessageJson("DataBaseException", db.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GenericException ge) {
			return new ResponseEntity<>(new MessageJson("GenericException", ge.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
