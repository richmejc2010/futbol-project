package com.richmejia.futbol.services;

import java.util.List;

import com.richmejia.futbol.entities.Team;
import com.richmejia.futbol.exceptions.DataBaseException;
import com.richmejia.futbol.exceptions.GenericException;
import com.richmejia.futbol.exceptions.TeamExistException;

public interface TeamService {

	String createTeam(Team team) throws TeamExistException, DataBaseException, GenericException;

	Team searchTeam(Team team);

	Team addTeam(Team team);

	Team editTeam(Team team);

	Team deleteTeam(Team team);

	List<Team> listTeam();
}
