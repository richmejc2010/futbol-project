package com.richmejia.futbol.entities;

import org.springframework.data.annotation.Id;

public class Player {
	
	@Id
	private String id;
	
	private int idTeam;
	private String fullName;
	private int position;
	private int yelowCard;
	private int redCard;

	public Player() {
	}

	public Player(String id, int idTeam, String fullName, int position, int yelowCard, int redCard) {
		this.id = id;
		this.idTeam = idTeam;
		this.fullName = fullName;
		this.position = position;
		this.yelowCard = yelowCard;
		this.redCard = redCard;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
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

	public int getYelowCard() {
		return yelowCard;
	}

	public void setYelowCard(int yelowCard) {
		this.yelowCard = yelowCard;
	}

	public int getRedCard() {
		return redCard;
	}

	public void setRedCard(int redCard) {
		this.redCard = redCard;
	}

}
