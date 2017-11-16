package com.richmejia.futbol.exceptions;

public class PositionExistException extends Exception {

	private static final long serialVersionUID = -4099902920627189885L;
	private String message;

	public String getMessage() {
		return message;
	}

	public PositionExistException() {
		// TODO Auto-generated constructor stub
	}

	public PositionExistException(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}
}
