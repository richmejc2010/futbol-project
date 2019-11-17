package com.richmejia.techtalk.controller;

import java.util.ArrayList;
import java.util.List;

import com.richmejia.techtalk.entities.MessageJson;
import com.richmejia.techtalk.exceptions.DataBaseException;
import com.richmejia.techtalk.exceptions.GenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.richmejia.techtalk.entities.Login;
import com.richmejia.techtalk.services.LoginService;
import com.richmejia.techtalk.services.impl.LoginServiceImpl;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	/*@RequestMapping(value = "/api/team/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createTeam(@RequestBody Login newLogin) {
		try {
			//Validar que name venga
			//Validar que name venga
			//Validar que name venga
			//Validar que name venga
			//Validar que name venga
			//Validar que name venga
			String jsonResp = loginService.createUser(newLogin);
			return new ResponseEntity<>(new MessageJson("OK", jsonResp), HttpStatus.OK);
		} catch (DataBaseException db) {
			return new ResponseEntity<>(new MessageJson("DataBaseException", db.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GenericException ge) {
			return new ResponseEntity<>(new MessageJson("GenericException", ge.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
*/
	@RequestMapping(value = "/api/login/", method = RequestMethod.POST)
	public Login createLogin() {
		try {
			LoginService loginService = new LoginServiceImpl();
			Login login = new Login(0,"rpmc","123", "richard", 0);
			return loginService.createUser(login);
		} catch (DataBaseException db) {
			db.getMessage();
			return new Login(0,db.getMessage(),"DataBaseException", "DataBaseException", 0);
		} catch (GenericException ge) {
			ge.getMessage();
			return new Login(0,ge.getMessage(),"GenericException", "GenericException", 0);
		}
	}

	@RequestMapping(value = "/api/login/listLogin/", method = RequestMethod.GET)
	public List<Login> listLogins() {
		try {
			LoginService loginService = new LoginServiceImpl();
			return loginService.listUsers();
		} catch (DataBaseException db) {
			db.getMessage();
			return new ArrayList<>();
		} catch (GenericException ge) {
			ge.getMessage();
			return new ArrayList<>();
		}
	}
}
