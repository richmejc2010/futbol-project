package com.richmejia.futbol.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Player {

	@Id
	private String id;

	@DBRef
	private Team team;
	
	private String fullName;
	private int position;
	private int yellowCard;
	private int redCard;

	public Player() {
	}

	public Player(String id, Team team, String fullName, int position, int yellowCard, int redCard) {
		this.id = id;
		this.team = team;
		this.fullName = fullName;
		this.position = position;
		this.yellowCard = yellowCard;
		this.redCard = redCard;
	}

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

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
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
