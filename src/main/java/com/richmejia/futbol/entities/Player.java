package com.richmejia.futbol.entities;

import org.springframework.data.annotation.Id;

public class Player {

	@Id
	private String id;

	private long cc;
	private int idTeam;
	private String fullName;
	private int position;
	private int yellowCard;
	private int redCard;

	public Player() {
	}

	public Player(String id, long cc, int idTeam, String fullName, int position, int yellowCard, int redCard) {
		this.id = id;
		this.cc = cc;
		this.idTeam = idTeam;
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

	public long getCc() {
		return cc;
	}

	public void setCc(long cc) {
		this.cc = cc;
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
