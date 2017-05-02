package com.richmejia.futbol.services.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.richmejia.futbol.entities.Match;
import com.richmejia.futbol.services.MatchService;

public class MatchServiceImpl implements MatchService {
	Date date = new Date(17, 04, 25);

	@Override
	public Match createMatch(Match match) {
		// TODO Auto-generated method stub
		return new Match("555555", 1, 2, true, date, 1);
	}

	@Override
	public Match searchMatch(Match match) {
		// TODO Auto-generated method stub
		return new Match("", 1, 2, true, date, 1);
	}

	@Override
	public Match addMatch(Match match) {
		// TODO Auto-generated method stub
		match.setId("");
		match.setTeam1(888);
		match.setTeam2(999);
		match.setTeam1Visitor(false);
		return match;
	}

	@Override
	public Match editMatch(Match match) {
		// TODO Auto-generated method stub
		return new Match("", 3333, 4444, true, date, 1);
	}

	@Override
	public Match deleteMatch(Match match) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Match> listMatch() {
		// TODO Auto-generated method stub
		List<Match> listMatch = new ArrayList<Match>();
		Match match = new Match();
		match.setId("");
		match.setTeam1(2);
		match.setTeam2(3);
		match.setTeam1Visitor(true);
		listMatch.add(match);

		return listMatch;
	}

}
