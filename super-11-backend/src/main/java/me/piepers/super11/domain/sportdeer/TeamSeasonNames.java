package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * Represents the team names (home and away) in various domain objects.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class TeamSeasonNames {
	@JsonProperty("team_season_home_name")
	private final String teamSeasonHme;
	@JsonProperty("team_season_away_name")
	private final String teamSeasonAwy;

	public TeamSeasonNames(JsonObject jsonObject) {
		this.teamSeasonHme = jsonObject.getString("team_season_home_name");
		this.teamSeasonAwy = jsonObject.getString("team_season_away_name");
	}

	private TeamSeasonNames(String teamSeasonHme, String teamSeasonAwy) {
		this.teamSeasonHme = teamSeasonHme;
		this.teamSeasonAwy = teamSeasonAwy;
	}

	@JsonCreator
	public static TeamSeasonNames of(@JsonProperty("team_season_home_name") String teamSeasonHme,
			@JsonProperty("team_season_away_name") String teamSeasonAwy) {
		return new TeamSeasonNames(teamSeasonHme, teamSeasonAwy);
	}

	public String getTeamSeasonHme() {
		return this.teamSeasonHme;
	}

	public String getTeamSeasonAwy() {
		return this.teamSeasonAwy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.teamSeasonAwy == null ? 0 : this.teamSeasonAwy.hashCode());
		result = prime * result + (this.teamSeasonHme == null ? 0 : this.teamSeasonHme.hashCode());
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
		TeamSeasonNames other = (TeamSeasonNames) obj;
		if (this.teamSeasonAwy == null) {
			if (other.teamSeasonAwy != null) {
				return false;
			}
		} else if (!this.teamSeasonAwy.equals(other.teamSeasonAwy)) {
			return false;
		}
		if (this.teamSeasonHme == null) {
			if (other.teamSeasonHme != null) {
				return false;
			}
		} else if (!this.teamSeasonHme.equals(other.teamSeasonHme)) {
			return false;
		}
		return true;
	}

}
