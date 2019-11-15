package com.richmejia.techtalk.entities.builder;

import com.richmejia.techtalk.entities.Player;
import com.richmejia.techtalk.entities.Position;
import com.richmejia.techtalk.entities.Team;

public class PlayerBuilder {

	private static PlayerBuilder instance;

	private PlayerBuilder() {

	}

	public static PlayerBuilder getInstance() {
		if (instance == null) {
			instance = new PlayerBuilder();
		}
		return instance;
	}

	private Player player;

	public PlayerBuilder createPlayer() {
		player = new Player();
		return this;
	}

	public PlayerBuilder withId(String id) {
		player.setId(id);
		return this;
	}

	public PlayerBuilder withFullName(String fullName) {
		player.setFullName(fullName);
		return this;
	}

	public PlayerBuilder withTeam(Team team) {
		player.setTeam(team);
		return this;
	}

	public PlayerBuilder withPosition(Position position) {
		player.setPosition(position);
		return this;
	}

	public PlayerBuilder withYellowCard(int yellowCard) {
		player.setYellowCard(yellowCard);
		return this;
	}

	public PlayerBuilder withRedCard(int redCard) {
		player.setRedCard(redCard);
		return this;
	}

	public Player build() {
		return player;
	}
}
