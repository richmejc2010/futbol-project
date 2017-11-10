package com.richmejia.futbol.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;

import com.richmejia.futbol.entities.Player;

public interface PlayerRepository extends MongoRepository<Player, String> {

	public Player findById(String id);

	public List<Player> findByFullNameContainingIgnoreCase(String fullName);

	public List<Player> findByTeam(String idTeam);

	// @Query("{'$or' : [{'fullName' : {$regex : ?0, $options: 'i'}}, "
	// + "{'team' : ?1}]}") //or
	// @Query("{'fullName' : {$regex : ?0, $options: 'i'}, 'id' : ?1}") //AND
	// @Query(value="{'fullName' : {$regex : ?0, $options: 'i'}}", fields="{
	// 'fullName' : 0}, {'id' : ?1}") //AND
	// public List<Player> findAllRegexIgnoreCase(String fullName, String id);
}
