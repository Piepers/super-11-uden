package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;

/**
 * Represents the amount of goals for the home and away team in various domain
 * objects.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class Goals {

	@JsonProperty("number_goal_team_home")
	private final Integer goalsHme;
	@JsonProperty("number_goal_team_away")
	private final Integer goalsAwy;

	private Goals(Integer goalsHme, Integer goalsAwy) {
		this.goalsHme = goalsHme;
		this.goalsAwy = goalsAwy;
	}

	@JsonCreator
	public static Goals of(@JsonProperty("number_goal_team_home") Integer goalsHme,
			@JsonProperty("number_goal_team_away") Integer goalsAwy) {
		return new Goals(goalsHme, goalsAwy);
	}

}
