package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

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

	public TeamSeasonIds(JsonObject jsonObject) {
		this.teamSeasonIdHme = jsonObject.getLong("id_team_season_home");
		this.teamSeasonIdAwy = jsonObject.getLong("id_team_season_away");
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.teamSeasonIdAwy == null ? 0 : this.teamSeasonIdAwy.hashCode());
		result = prime * result + (this.teamSeasonIdHme == null ? 0 : this.teamSeasonIdHme.hashCode());
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
		TeamSeasonIds other = (TeamSeasonIds) obj;
		if (this.teamSeasonIdAwy == null) {
			if (other.teamSeasonIdAwy != null) {
				return false;
			}
		} else if (!this.teamSeasonIdAwy.equals(other.teamSeasonIdAwy)) {
			return false;
		}
		if (this.teamSeasonIdHme == null) {
			if (other.teamSeasonIdHme != null) {
				return false;
			}
		} else if (!this.teamSeasonIdHme.equals(other.teamSeasonIdHme)) {
			return false;
		}
		return true;
	}

}
