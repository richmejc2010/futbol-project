package com.richmejia.techtalk.services;

import java.util.List;

import com.richmejia.techtalk.entities.Login;
import com.richmejia.techtalk.exceptions.DataBaseException;
import com.richmejia.techtalk.exceptions.GenericException;

public interface LoginService {
	Login createUser(Login login) throws DataBaseException, GenericException;

	List<Login> listUsers() throws DataBaseException, GenericException;
}
