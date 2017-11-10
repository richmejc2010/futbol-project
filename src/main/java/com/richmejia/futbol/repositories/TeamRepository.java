package com.richmejia.futbol.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.richmejia.futbol.entities.Team;

public interface TeamRepository extends MongoRepository<Team, String> {

	public List<Team> findByNameLike(String fullName);

	public Team findById(String idTeam);
}
