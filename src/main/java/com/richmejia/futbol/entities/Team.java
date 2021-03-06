package com.richmejia.futbol.entities;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Team {

	@Id
	@NotNull(message = "Team Id cannot be null")
	@NotBlank(message = "Team Id cannot be empty")
	private String id;
	
	private String name;
	private int points;

	public Team() {
	}

	public Team(String id, String name, int points) {
		this.id = id;
		this.name = name;
		this.points = points;
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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
