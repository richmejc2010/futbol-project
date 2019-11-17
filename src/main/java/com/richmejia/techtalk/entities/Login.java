package com.richmejia.techtalk.entities;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Login {
	@Id
	@NotNull(message = "Id cannot be null")
	@NotBlank(message = "Id cannot be empty")
	private int id;

	@NotNull(message = "user cannot be null")
	@NotBlank(message = "user cannot be empty")
	private String user;

	@NotNull(message = "password cannot be null")
	@NotBlank(message = "password cannot be empty")
	private String password;

	@NotNull(message = "name cannot be null")
	@NotBlank(message = "name cannot be empty")
	private String name;

	@Min(value = 0, message = "profile should not be less than 0")
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
