package com.richmejia.futbol.services;

import java.util.List;

import com.richmejia.futbol.entities.Position;
import com.richmejia.futbol.exceptions.DataBaseException;
import com.richmejia.futbol.exceptions.GenericException;
import com.richmejia.futbol.exceptions.PositionExistException;

public interface PositionService {

	String createPosition(Position position) throws PositionExistException, DataBaseException, GenericException;

	Position searchPosition(Position position);

	Position addPosition(Position position);

	Position editPosition(Position position);

	Position deletePosition(Position position);

	List<Position> listPosition();
}
