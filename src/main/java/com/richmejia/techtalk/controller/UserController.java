package com.richmejia.techtalk.controller;

import java.util.ArrayList;
import java.util.List;

import com.richmejia.techtalk.exceptions.DataBaseException;
import com.richmejia.techtalk.exceptions.GenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.richmejia.techtalk.entities.User;
import com.richmejia.techtalk.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/api/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User user) {
		try {
			return userService.addUser(user);
		} catch (DataBaseException db) {
			db.getMessage();
			return null;
		} catch (GenericException ge) {
			ge.getMessage();
			return null;
		}
	}

	@RequestMapping(value = "/api/login/listLogin/", method = RequestMethod.GET)
	public List<User> listLogins() {
		try {
			return userService.listUsers();
		} catch (DataBaseException db) {
			db.getMessage();
			return new ArrayList<>();
		} catch (GenericException ge) {
			ge.getMessage();
			return new ArrayList<>();
		}
	}
}
