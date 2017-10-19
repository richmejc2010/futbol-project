package com.richmejia.futbol.entities;

public class MessageJson {

	private String result;
	private String message;

	public MessageJson() {
		// TODO Auto-generated constructor stub
	}

	public MessageJson(String result, String message) {
		// TODO Auto-generated constructor stub
		this.result = result;
		this.message = message;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
