package com.richmejia.futbol.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Component;

import com.mongodb.MongoSocketOpenException;
import com.mongodb.MongoTimeoutException;
import com.richmejia.futbol.entities.Position;
import com.richmejia.futbol.exceptions.DataBaseException;
import com.richmejia.futbol.exceptions.GenericException;
import com.richmejia.futbol.exceptions.PositionExistException;
import com.richmejia.futbol.repositories.PositionRepository;
import com.richmejia.futbol.services.PositionService;

@Component
public class PositionServiceImpl implements PositionService {

	@Autowired
	private PositionRepository repositoryPosition;

	@Override
	public String createPosition(Position position) throws PositionExistException, DataBaseException, GenericException {
		try {
			String result = "Position created successfully";

			repositoryPosition.save(position);
			return result;
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
	public Position searchPosition(Position position) {
		// TODO Auto-generated method stub
		return new Position("0", "GoalKeeper");
	}

	@Override
	public Position addPosition(Position position) {
		// TODO Auto-generated method stub
		return new Position("0", "GoalKeeper");
	}

	@Override
	public Position editPosition(Position position) {
		// TODO Auto-generated method stub
		return new Position("0", "GoalKeeper");
	}

	@Override
	public Position deletePosition(Position position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Position> listPosition() {
		// TODO Auto-generated method stub
		List<Position> listPosition = new ArrayList<Position>();
		Position position = new Position("0", "GoalKeeper");
		listPosition.add(position);

		return listPosition;
	}

}
