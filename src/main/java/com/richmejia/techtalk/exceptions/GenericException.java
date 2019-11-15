package com.richmejia.techtalk.exceptions;

public class GenericException extends Exception {

	private static final long serialVersionUID = -4004455909262611847L;
	private String message;

	public String getMessage() {
		return message;
	}

	public GenericException() {
		// TODO Auto-generated constructor stub
	}

	public GenericException(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}
}
