package com.richmejia.futbol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.richmejia.futbol.entities.MessageJson;
import com.richmejia.futbol.entities.Player;
import com.richmejia.futbol.exceptions.DataBaseException;
import com.richmejia.futbol.exceptions.GenericException;
import com.richmejia.futbol.exceptions.PlayerExistException;
import com.richmejia.futbol.exceptions.PlayerNotFoundException;
import com.richmejia.futbol.services.PlayerService;

@RestController
public class PlayerController {

	@Autowired
	PlayerService playerService;

	@RequestMapping(value = "/api/player/", method = RequestMethod.POST)
	public ResponseEntity<?> createPlayer(Player newPlayer) {
		try {
			String jsonResp = playerService.createPlayer(newPlayer);
			return new ResponseEntity<>(new MessageJson("OK", jsonResp), HttpStatus.OK);
		} catch (PlayerExistException pe) {
			return new ResponseEntity<>(new MessageJson("PlayerExistException", pe.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (DataBaseException db) {
			return new ResponseEntity<>(new MessageJson("DataBaseException", db.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GenericException ge) {
			return new ResponseEntity<>(new MessageJson("GenericException", ge.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/api/player/{cc}", method = RequestMethod.POST)
	public ResponseEntity<?> updatePlayer(@PathVariable(value = "cc") long cc, Player newPlayer) {
		try {
			newPlayer.setCc(cc);
			String jsonResp = playerService.updatePlayer(newPlayer);
			return new ResponseEntity<>(new MessageJson("OK", jsonResp), HttpStatus.OK);
		} catch (PlayerNotFoundException pe) {
			return new ResponseEntity<>(new MessageJson("PlayerNotFoundException", pe.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (DataBaseException db) {
			return new ResponseEntity<>(new MessageJson("DataBaseException", db.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GenericException ge) {
			return new ResponseEntity<>(new MessageJson("GenericException", ge.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/api/player/{cc}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePlayer(@PathVariable(value = "cc") long cc) {
		try {
			String jsonResp = playerService.deletePlayer(cc);
			return new ResponseEntity<>(new MessageJson("OK", jsonResp), HttpStatus.OK);
		} catch (PlayerNotFoundException pe) {
			return new ResponseEntity<>(new MessageJson("PlayerNotFoundException", pe.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (DataBaseException db) {
			return new ResponseEntity<>(new MessageJson("DataBaseException", db.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GenericException ge) {
			return new ResponseEntity<>(new MessageJson("GenericException", ge.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/api/player/findBy/cc/{cc}", method = RequestMethod.GET)
	public ResponseEntity<?> listPlayersByCc(@PathVariable(value = "cc") long cc) {
		try {
			Player player = playerService.playersByCc(cc);
			return new ResponseEntity<>(player, HttpStatus.OK);
		} catch (PlayerNotFoundException pe) {
			return new ResponseEntity<>(new MessageJson("PlayerNotFoundException", pe.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (DataBaseException db) {
			return new ResponseEntity<>(new MessageJson("DataBaseException", db.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GenericException ge) {
			return new ResponseEntity<>(new MessageJson("GenericException", ge.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/api/player/findBy/fullName/{fullName}", method = RequestMethod.GET)
	public ResponseEntity<?> listPlayersByFullName(@PathVariable(value = "fullName") String fullName) {
		try {
			List<Player> listPlayer = playerService.listPlayersByFullName(fullName);
			return new ResponseEntity<>(listPlayer, HttpStatus.OK);
		} catch (PlayerNotFoundException pe) {
			return new ResponseEntity<>(new MessageJson("PlayerNotFoundException", pe.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (DataBaseException db) {
			return new ResponseEntity<>(new MessageJson("DataBaseException", db.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GenericException ge) {
			return new ResponseEntity<>(new MessageJson("GenericException", ge.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/api/player/findBy/", method = RequestMethod.GET)
	public ResponseEntity<?> listPlayers() {
		try {
			List<Player> listPlayer = playerService.listPlayers();
			return new ResponseEntity<>(listPlayer, HttpStatus.OK);
		} catch (PlayerNotFoundException pe) {
			return new ResponseEntity<>(new MessageJson("PlayerNotFoundException", pe.toString()), HttpStatus.BAD_REQUEST);
		} catch (DataBaseException db) {
			return new ResponseEntity<>(new MessageJson("DataBaseException", db.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GenericException ge) {
			return new ResponseEntity<>(new MessageJson("GenericException", ge.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
