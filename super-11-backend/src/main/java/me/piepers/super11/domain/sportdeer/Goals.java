package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

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

	public Goals(JsonObject jsonObject) {
		this.goalsHme = jsonObject.getInteger("number_goal_team_home");
		this.goalsAwy = jsonObject.getInteger("number_goal_team_away");
	}

	@JsonCreator
	public static Goals of(@JsonProperty("number_goal_team_home") Integer goalsHme,
			@JsonProperty("number_goal_team_away") Integer goalsAwy) {
		return new Goals(goalsHme, goalsAwy);
	}

	public Integer getGoalsHme() {
		return this.goalsHme;
	}

	public Integer getGoalsAwy() {
		return this.goalsAwy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.goalsAwy == null ? 0 : this.goalsAwy.hashCode());
		result = prime * result + (this.goalsHme == null ? 0 : this.goalsHme.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Goals other = (Goals) obj;
		if (this.goalsAwy == null) {
			if (other.goalsAwy != null) {
				return false;
			}
		} else if (!this.goalsAwy.equals(other.goalsAwy)) {
			return false;
		}
		if (this.goalsHme == null) {
			if (other.goalsHme != null) {
				return false;
			}
		} else if (!this.goalsHme.equals(other.goalsHme)) {
			return false;
		}
		return true;
	}

}
