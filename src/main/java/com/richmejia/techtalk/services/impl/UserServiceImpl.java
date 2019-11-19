package com.richmejia.techtalk.services.impl;

import java.util.List;

import com.mongodb.MongoSocketOpenException;
import com.mongodb.MongoTimeoutException;
import com.richmejia.techtalk.entities.User;
import com.richmejia.techtalk.exceptions.DataBaseException;
import com.richmejia.techtalk.exceptions.GenericException;
import com.richmejia.techtalk.repositories.UserRepository;
import com.richmejia.techtalk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) throws DataBaseException, GenericException {
		// TODO Auto-generated method stub
		try {
			return userRepository.save(user);
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
	public List<User> listUsers() throws DataBaseException, GenericException {
		// TODO Auto-generated method stub
		try {
			return userRepository.findAll();
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
