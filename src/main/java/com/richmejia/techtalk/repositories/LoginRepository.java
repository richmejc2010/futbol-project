package com.richmejia.techtalk.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.richmejia.techtalk.entities.Login;

public interface LoginRepository extends MongoRepository<Login, String> {

	List<Login> findByNameLike(String fullName);

	Login findById(String idPosition);
}
