package com.richmejia.techtalk.entities;

import org.springframework.data.annotation.Id;

public class Login {
	@Id
	private int id;
	private String user;
	private String password;
	private String name;
	private int profile;

	public Login(int id, String user, String password, String name, int profile) {
		this.id = id;
		this.user = user;
		this.password = password;
		this.name = name;
		this.profile = profile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProfile() {
		return profile;
	}

	public void setProfile(int profile) {
		this.profile = profile;
	}

}
