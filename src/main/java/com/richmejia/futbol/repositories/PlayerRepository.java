package com.richmejia.futbol.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.richmejia.futbol.entities.Player;

public interface PlayerRepository extends MongoRepository<Player, String> {

	public Player findById(String id);
}
