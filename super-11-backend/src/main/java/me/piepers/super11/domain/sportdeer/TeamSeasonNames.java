package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;

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

}
