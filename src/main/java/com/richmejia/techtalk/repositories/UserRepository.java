package com.richmejia.techtalk.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.richmejia.techtalk.entities.User;

public interface UserRepository extends MongoRepository<User, String> {
	List<User> findAll();
}
