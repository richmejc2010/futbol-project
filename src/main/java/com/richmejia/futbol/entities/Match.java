package com.richmejia.futbol.entities;

import java.sql.Date;

import org.springframework.data.annotation.Id;

public class Match {
	@Id
	private String id;
	
	private int team1;
	private int team2;
	private boolean team1Visitor;
	private Date date;
	private int stadium;

	public Match() {
	}

	public Match(String id, int team1, int team2, boolean team1Visitor, Date date, int stadium) {
		this.id = id;
		this.team1 = team1;
		this.team2 = team2;
		this.team1Visitor = team1Visitor;
		this.date = date;
		this.stadium = stadium;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTeam1() {
		return team1;
	}

	public void setTeam1(int team1) {
		this.team1 = team1;
	}

	public int getTeam2() {
		return team2;
	}

	public void setTeam2(int team2) {
		this.team2 = team2;
	}

	public boolean getTeam1Visitor() {
		return team1Visitor;
	}

	public void setTeam1Visitor(boolean team1Visitor) {
		this.team1Visitor = team1Visitor;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getStadium() {
		return stadium;
	}

	public void setStadium(int stadium) {
		this.stadium = stadium;
	}

}
