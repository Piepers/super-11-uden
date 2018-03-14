package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;

/**
 * Convenience id class in domain objects where home and away team ids are used.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class TeamSeasonIds {
	@JsonProperty("id_team_season_home")
	private final Long teamSeasonIdHme;
	@JsonProperty("id_team_season_away")
	private final Long teamSeasonIdAwy;

	private TeamSeasonIds(Long teamSeasonIdHme, Long teamSeasonIdAwy) {
		this.teamSeasonIdHme = teamSeasonIdHme;
		this.teamSeasonIdAwy = teamSeasonIdAwy;
	}

	@JsonCreator
	public static TeamSeasonIds of(@JsonProperty("id_team_season_home") Long teamSeasonIdHme,
			@JsonProperty("id_team_season_away") Long teamSeasonIdAwy) {
		return new TeamSeasonIds(teamSeasonIdHme, teamSeasonIdAwy);
	}

	public Long getTeamSeasonIdHme() {
		return this.teamSeasonIdHme;
	}

	public Long getTeamSeasonIdAwy() {
		return this.teamSeasonIdAwy;
	}

}
