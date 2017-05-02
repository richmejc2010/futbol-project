package com.richmejia.futbol.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.richmejia.futbol.entities.Team;
import com.richmejia.futbol.services.TeamService;

public class TeamServiceImpl implements TeamService {

	@Override
	public Team createTeam(Team team) {
		// TODO Auto-generated method stub
		team.setId("");
		team.setPoints(3);
		team.setName("Richard Futbol Club");
		return team;
	}

	@Override
	public Team searchTeam(Team team) {
		// TODO Auto-generated method stub
		return new Team("", "Junior Found", 0);
	}

	@Override
	public Team addTeam(Team team) {
		// TODO Auto-generated method stub
		return new Team("", "Team Junior Added", 0);
	}

	@Override
	public Team editTeam(Team team) {
		// TODO Auto-generated method stub
		return new Team("", "Junior Edited", 1);
	}

	@Override
	public Team deleteTeam(Team team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> listTeam() {
		// TODO Auto-generated method stub
		List<Team> listTeam = new ArrayList<Team>();
		Team team = new Team();
		team.setId("");
		team.setPoints(3);
		team.setName("Richard Mejia PlayerServiceImpl listed");
		listTeam.add(team);

		return listTeam;
	}

}
