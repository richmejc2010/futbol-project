package com.richmejia.futbol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.richmejia.futbol.entities.MessageJson;
import com.richmejia.futbol.entities.Position;
import com.richmejia.futbol.exceptions.DataBaseException;
import com.richmejia.futbol.exceptions.GenericException;
import com.richmejia.futbol.exceptions.PositionExistException;
import com.richmejia.futbol.services.PositionService;
import com.richmejia.futbol.services.impl.PositionServiceImpl;

@RestController
public class PositionController {

	@Autowired
	PositionService positionService;

	@RequestMapping(value = "/api/position/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createPosition(@RequestBody Position newPosition) {
		try {
			String jsonResp = positionService.createPosition(newPosition);
			return new ResponseEntity<>(new MessageJson("OK", jsonResp), HttpStatus.OK);
		} catch (PositionExistException pe) {
			return new ResponseEntity<>(new MessageJson("PositionExistException", pe.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (DataBaseException db) {
			return new ResponseEntity<>(new MessageJson("DataBaseException", db.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (GenericException ge) {
			return new ResponseEntity<>(new MessageJson("GenericException", ge.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/api/position/{id}")
	public Position searchPosition(@PathVariable(value = "id") String id) {
		PositionService positionService = new PositionServiceImpl();
		Position position = new Position(id, "GoalKeeper");
		return positionService.searchPosition(position);
	}

	@RequestMapping(value = "/api/position/{id}", method = RequestMethod.PUT)
	public Position editPosition(@PathVariable(value = "id") String id) {
		PositionService positionService = new PositionServiceImpl();
		Position position = new Position(id, "GoalKeeper");
		return positionService.editPosition(position);
	}

	@RequestMapping(value = "/api/position/{id}", method = RequestMethod.DELETE)
	public Position deletePosition(@PathVariable(value = "id") String id) {
		PositionService positionService = new PositionServiceImpl();
		return positionService.deletePosition(new Position("0", "GoalKeeper"));
	}

	@RequestMapping(value = "/api/position/lists/", method = RequestMethod.GET)
	public List<Position> listPositions() {
		PositionService positionService = new PositionServiceImpl();
		return positionService.listPosition();
	}

}
