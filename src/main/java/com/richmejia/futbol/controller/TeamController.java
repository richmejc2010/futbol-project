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
import org.springframework.web.bind.annotation.RestController;

import com.richmejia.futbol.entities.MessageJson;
import com.richmejia.futbol.entities.Team;
import com.richmejia.futbol.exceptions.DataBaseException;
import com.richmejia.futbol.exceptions.GenericException;
import com.richmejia.futbol.exceptions.TeamExistException;
import com.richmejia.futbol.services.TeamService;
import com.richmejia.futbol.services.impl.TeamServiceImpl;

@RestController
public class TeamController {

	@Autowired
	TeamService teamService;

	@RequestMapping(value = "/api/team/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createTeam(@RequestBody Team newTeam) {
		try {
			//Validar que name venga
			//Validar que name venga
			//Validar que name venga
			//Validar que name venga
			//Validar que name venga
			//Validar que name venga
			String jsonResp = teamService.createTeam(newTeam);
			return new ResponseEntity<>(new MessageJson("OK", jsonResp), HttpStatus.OK);
		} catch (TeamExistException pe) {
			return new ResponseEntity<>(new MessageJson("TeamExistException", pe.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (DataBaseException db) {
			return new ResponseEntity<>(new MessageJson("DataBaseException", db.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GenericException ge) {
			return new ResponseEntity<>(new MessageJson("GenericException", ge.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/api/team/{id}")
	public Team searchTeam(@PathVariable(value = "id") String id) {
		TeamService teamService = new TeamServiceImpl();
		Team team = new Team(id, "", 0);
		return teamService.searchTeam(team);
	}

	@RequestMapping(value = "/api/team/{id}", method = RequestMethod.PUT)
	public Team editTeam(@PathVariable(value = "id") String id) {
		TeamService teamService = new TeamServiceImpl();
		Team team = new Team(id, "", 0);
		return teamService.editTeam(team);
	}

	@RequestMapping(value = "/api/team/{id}", method = RequestMethod.DELETE)
	public Team deleteTeam(@PathVariable(value = "id") String id) {
		TeamService teamService = new TeamServiceImpl();
		return teamService.deleteTeam(new Team("0", "Barcelona", 1));
	}

	@RequestMapping(value = "/api/team/lists/", method = RequestMethod.GET)
	public List<Team> listTeams() {
		TeamService teamService = new TeamServiceImpl();
		return teamService.listTeam();
	}

}
