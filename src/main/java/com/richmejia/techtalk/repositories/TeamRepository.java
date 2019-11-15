package com.richmejia.techtalk.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.richmejia.techtalk.entities.Team;

public interface TeamRepository extends MongoRepository<Team, String> {

	List<Team> findByNameLike(String fullName);

	Team findById(String idTeam);
}
