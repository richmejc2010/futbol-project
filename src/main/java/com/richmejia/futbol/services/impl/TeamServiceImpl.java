package com.richmejia.futbol.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Component;

import com.mongodb.MongoSocketOpenException;
import com.mongodb.MongoTimeoutException;
import com.richmejia.futbol.entities.Team;
import com.richmejia.futbol.exceptions.DataBaseException;
import com.richmejia.futbol.exceptions.GenericException;
import com.richmejia.futbol.exceptions.TeamExistException;
import com.richmejia.futbol.repositories.TeamRepository;
import com.richmejia.futbol.services.TeamService;

@Component
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository repositoryTeam;
	
	@Override
	public String createTeam(Team team) throws TeamExistException, DataBaseException, GenericException {
		try {
			String result = "Team created successfully";
			
				repositoryTeam.save(team);
			return result;
		} catch (MongoSocketOpenException mse) {
			throw new DataBaseException(mse.toString());
		} catch (MongoTimeoutException mte) {
			throw new DataBaseException(mte.toString());
		} catch (DataAccessResourceFailureException darf) {
			throw new DataBaseException(darf.toString());
		} catch (Exception e) {
			throw new GenericException(e.toString());
		}
	}

	@Override
	public Team searchTeam(Team team) {
		// TODO Auto-generated method stub
		return new Team("0", "Junior Found", 0);
	}

	@Override
	public Team addTeam(Team team) {
		// TODO Auto-generated method stub
		return new Team("0", "Team Junior Added", 0);
	}

	@Override
	public Team editTeam(Team team) {
		// TODO Auto-generated method stub
		return new Team("0", "Junior Edited", 1);
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
		team.setId("0");
		team.setPoints(3);
		team.setName("Richard Mejia PlayerServiceImpl listed");
		listTeam.add(team);

		return listTeam;
	}

}
