package com.richmejia.futbol.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.richmejia.futbol.entities.Position;

public interface PositionRepository extends MongoRepository<Position, String> {

	public List<Position> findByNameLike(String fullName);

	public Position findById(String idPosition);
}
