package com.richmejia.futbol.exceptions;

public class DataBaseException extends Exception {

	private static final long serialVersionUID = -931705536128921257L;
	private String message;

	public String getMessage() {
		return message;
	}

	public DataBaseException() {
		// TODO Auto-generated constructor stub
	}

	public DataBaseException(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}
}
