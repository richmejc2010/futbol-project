package com.richmejia.futbol.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.richmejia.futbol.entities.Match;
import com.richmejia.futbol.services.MatchService;
import com.richmejia.futbol.services.impl.MatchServiceImpl;

@RestController
public class MatchController {

	@RequestMapping(value = "/api/match/", method = RequestMethod.POST)
	public Match createMatch(Match newMatch) {
		MatchService matchService = new MatchServiceImpl();
		return matchService.createMatch(newMatch);
	}

	@RequestMapping("/api/match/{id}")
	public Match searchMatch(@PathVariable(value = "id") int id) {
		MatchService matchService = new MatchServiceImpl();
		Match match = new Match("", 0, 0, false, new Date(0, 0, 0), 0);
		return matchService.searchMatch(match);
	}

	@RequestMapping(value = "/api/match/{id}", method = RequestMethod.PUT)
	public Match editMatch(@PathVariable(value = "id") int id) {
		MatchService matchService = new MatchServiceImpl();
		Match match = new Match("", 0, 0, false, new Date(0, 0, 0), 0);
		return matchService.editMatch(match);
	}

	@RequestMapping(value = "/api/match/{id}", method = RequestMethod.DELETE)
	public Match deleteMatch(@PathVariable(value = "id") int id) {
		MatchService matchService = new MatchServiceImpl();
		Match match = new Match("", 0, 0, false, new Date(0, 0, 0), 0);
		return matchService.deleteMatch(match);
	}

	@RequestMapping(value = "/api/match/lists/", method = RequestMethod.GET)
	public List<Match> listMatchs() {
		MatchService matchService = new MatchServiceImpl();
		return matchService.listMatch();
	}

}
