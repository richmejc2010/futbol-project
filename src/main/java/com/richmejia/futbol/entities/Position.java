package com.richmejia.futbol.entities;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Position {

	@Id
	@NotNull(message = "Position Id cannot be null")
	@NotBlank(message = "Position Id cannot be empty")
	private String id;

	private String name;

	public Position() {
	}

	public Position(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
