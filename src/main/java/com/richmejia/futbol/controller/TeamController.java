package com.richmejia.futbol.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.richmejia.futbol.entities.Team;
import com.richmejia.futbol.services.TeamService;
import com.richmejia.futbol.services.impl.TeamServiceImpl;

@RestController
public class TeamController {

	@RequestMapping(value = "/api/team/", method = RequestMethod.POST)
	public Team createTeam(Team newTeam) {
		TeamService teamService = new TeamServiceImpl();
		return teamService.createTeam(newTeam);
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
		return teamService.deleteTeam(new Team("", "Barcelona", 1));
	}

	@RequestMapping(value = "/api/team/lists/", method = RequestMethod.GET)
	public List<Team> listTeams() {
		TeamService teamService = new TeamServiceImpl();
		return teamService.listTeam();
	}

}
