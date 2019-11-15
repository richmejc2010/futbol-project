package com.richmejia.techtalk.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.richmejia.techtalk.entities.Position;

public interface PositionRepository extends MongoRepository<Position, String> {

	List<Position> findByNameLike(String fullName);

	Position findById(String idPosition);
}
