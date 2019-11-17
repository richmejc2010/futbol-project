package com.richmejia.techtalk.services.impl;

import java.util.List;

import com.mongodb.MongoSocketOpenException;
import com.mongodb.MongoTimeoutException;
import com.richmejia.techtalk.entities.Login;
import com.richmejia.techtalk.exceptions.DataBaseException;
import com.richmejia.techtalk.exceptions.GenericException;
import com.richmejia.techtalk.repositories.LoginRepository;
import com.richmejia.techtalk.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public Login createUser(Login login) throws DataBaseException, GenericException {
		// TODO Auto-generated method stub
		try {
			return loginRepository.save(login);
		} catch (MongoSocketOpenException mse) {
			throw new DataBaseException(mse.toString());
		} catch (MongoTimeoutException mte) {
			throw new DataBaseException(mte.toString());
		} catch (DataAccessResourceFailureException darf) {
			throw new DataBaseException(darf.toString());
		} catch (Exception e) {
			throw new GenericException(e.toString());
		}
	}

	@Override
	public List<Login> listUsers() throws DataBaseException, GenericException {
		// TODO Auto-generated method stub
		try {
			return loginRepository.findAll();
		} catch (MongoSocketOpenException mse) {
			throw new DataBaseException(mse.toString());
		} catch (MongoTimeoutException mte) {
			throw new DataBaseException(mte.toString());
		} catch (DataAccessResourceFailureException darf) {
			throw new DataBaseException(darf.toString());
		} catch (Exception e) {
			throw new GenericException(e.toString());
		}
	}

}
