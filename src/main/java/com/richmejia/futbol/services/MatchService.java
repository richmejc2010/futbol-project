package com.richmejia.futbol.services;

import java.util.List;

import com.richmejia.futbol.entities.Match;

public interface MatchService {

	Match createMatch(Match match);

	Match searchMatch(Match match);

	Match addMatch(Match match);

	Match editMatch(Match match);

	Match deleteMatch(Match match);

	List<Match> listMatch();
}
