package com.richmejia.futbol.services;

import java.util.List;

import com.richmejia.futbol.entities.Team;

public interface TeamService {

	Team createTeam(Team team);

	Team searchTeam(Team team);

	Team addTeam(Team team);

	Team editTeam(Team team);

	Team deleteTeam(Team team);

	List<Team> listTeam();
}
