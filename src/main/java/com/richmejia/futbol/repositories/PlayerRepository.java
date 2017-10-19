package com.richmejia.futbol.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.richmejia.futbol.entities.Player;

public interface PlayerRepository extends MongoRepository<Player, String> {
	
	public Player findByCc(long cc);

	public List<Player> findByFullNameLike(String fullName);
	
	public Player findByIdTeam(int idTeam);
}
