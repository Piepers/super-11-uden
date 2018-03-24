package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * The team/season data for a particular season. The corresponding API request
 * typically contains each team for a season.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class TeamSeason extends SportdeerDomainObject {

	@JsonUnwrapped
	private final SeasonId seasonId;
	@JsonUnwrapped
	private final TeamId teamId;
	@JsonProperty("team_name")
	private final String teamName;
	@JsonProperty("season_name")
	private final String seasonName;

	public TeamSeason(JsonObject jsonObject) {
		super(jsonObject);
		this.seasonId = SeasonId.of(jsonObject.getLong("id_season"));
		this.teamId = TeamId.of(jsonObject.getLong("id_team"));
		this.teamName = jsonObject.getString("team_name");
		this.seasonName = jsonObject.getString("season_name");
	}

	public TeamSeason(@JsonProperty("_id") Long id, @JsonProperty("id_season") Long seasonId,
			@JsonProperty("id_team") Long teamId, @JsonProperty("team_name") String teamName,
			@JsonProperty("season_name") String seasonName) {
		super(id);
		this.seasonId = SeasonId.of(seasonId);
		this.teamId = TeamId.of(teamId);
		this.teamName = teamName;
		this.seasonName = seasonName;
	}

	public SeasonId getSeasonId() {
		return this.seasonId;
	}

	public TeamId getTeamId() {
		return this.teamId;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public String getSeasonName() {
		return this.seasonName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (this.seasonId == null ? 0 : this.seasonId.hashCode());
		result = prime * result + (this.seasonName == null ? 0 : this.seasonName.hashCode());
		result = prime * result + (this.teamId == null ? 0 : this.teamId.hashCode());
		result = prime * result + (this.teamName == null ? 0 : this.teamName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		TeamSeason other = (TeamSeason) obj;
		if (this.seasonId == null) {
			if (other.seasonId != null) {
				return false;
			}
		} else if (!this.seasonId.equals(other.seasonId)) {
			return false;
		}
		if (this.seasonName == null) {
			if (other.seasonName != null) {
				return false;
			}
		} else if (!this.seasonName.equals(other.seasonName)) {
			return false;
		}
		if (this.teamId == null) {
			if (other.teamId != null) {
				return false;
			}
		} else if (!this.teamId.equals(other.teamId)) {
			return false;
		}
		if (this.teamName == null) {
			if (other.teamName != null) {
				return false;
			}
		} else if (!this.teamName.equals(other.teamName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "TeamSeason [id=" + this.getId() + ", seasonId=" + this.seasonId + ", teamId=" + this.teamId
				+ ", teamName=" + this.teamName + ", seasonName=" + this.seasonName + "]";
	}

}
