package com.richmejia.futbol.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.richmejia.futbol.entities.Login;
import com.richmejia.futbol.services.LoginService;
import com.richmejia.futbol.services.impl.LoginServiceImpl;

@RestController
public class LoginController {

	@RequestMapping(value = "/api/login/", method = RequestMethod.POST)
	public Login createLogin(Login newLogin) {
		LoginService loginService = new LoginServiceImpl();
		return loginService.createUser(newLogin);
	}

	@RequestMapping("/api/login/{id}")
	public Login searchLogin(@PathVariable(value = "id") int id) {
		LoginService loginService = new LoginServiceImpl();
		Login login = new Login(0, "", "", "", 0);
		return loginService.searchUser(login);
	}

	@RequestMapping(value = "/api/login/{id}", method = RequestMethod.PUT)
	public Login editLogin(@PathVariable(value = "id") int id) {
		LoginService loginService = new LoginServiceImpl();
		Login login = new Login(0, "", "", "", 0);
		return loginService.editUser(login);
	}

	@RequestMapping(value = "/api/login/{id}", method = RequestMethod.DELETE)
	public Login deleteLogin(@PathVariable(value = "id") int id) {
		LoginService loginService = new LoginServiceImpl();
		return loginService.deleteUser(new Login(0, "", "", "", 0));
	}

	@RequestMapping(value = "/api/login/lists/", method = RequestMethod.POST)
	public List<Login> listLogins() {
		LoginService loginService = new LoginServiceImpl();
		return loginService.listUsers();
	}
}
