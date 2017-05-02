package com.richmejia.futbol.services;

import java.util.List;

import com.richmejia.futbol.entities.Login;

public interface LoginService {

	Login createUser(Login login);

	Login searchUser(Login login);

	Login addUser(Login login);

	Login editUser(Login login);

	Login deleteUser(Login login);

	List<Login> listUsers();
}
