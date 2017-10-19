package com.richmejia.futbol.exceptions;

public class PlayerNotFoundException extends Exception {

	private static final long serialVersionUID = 5155385455330743559L;
	private String message;

	public String getMessage() {
		return message;
	}

	public PlayerNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public PlayerNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}
}
