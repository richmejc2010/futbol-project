package com.richmejia.techtalk.services;

import java.util.List;

import com.richmejia.techtalk.entities.User;
import com.richmejia.techtalk.exceptions.DataBaseException;
import com.richmejia.techtalk.exceptions.GenericException;

public interface UserService {
	User addUser(User user) throws DataBaseException, GenericException;

	List<User> listUsers() throws DataBaseException, GenericException;
}
