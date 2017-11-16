package com.richmejia.futbol.entities;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Player {

	public Player(){
		
	}
	
	@Id
	@NotNull(message = "Player Id cannot be null")
	@NotBlank(message = "Player Id cannot be empty")
	private String id;

	@DBRef
	private Team team;

	private String fullName;

	@DBRef
	private Position position;

	@Min(value = 0, message = "Yellow Card should not be less than 0")
	private int yellowCard;

	@Min(value = 0, message = "Red Card should not be less than 0")
	private int redCard;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getYellowCard() {
		return yellowCard;
	}

	public void setYellowCard(int yellowCard) {
		this.yellowCard = yellowCard;
	}

	public int getRedCard() {
		return redCard;
	}

	public void setRedCard(int redCard) {
		this.redCard = redCard;
	}

}
