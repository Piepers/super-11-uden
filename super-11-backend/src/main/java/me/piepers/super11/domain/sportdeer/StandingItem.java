package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * The standing of a particular team and the statistics of the team for this
 * standing. It is identical to the {@link Standing} domain object but adds the
 * "_id" field (which is different in type from the
 * {@link SportdeerDomainObject}'s id field.
 *
 * @author Bas Piepers
 *
 */
@DataObject
public class StandingItem extends Standing {

	@JsonProperty("_id")
	private final String id;

	public StandingItem(JsonObject jsonObject) {
		super(jsonObject);
		this.id = jsonObject.getString("_id");
	}

	public StandingItem(@JsonProperty("_id") String id, @JsonProperty("id_team_season") Long teamSeasonId,
			@JsonProperty("team_season_name") String teamSeasonName, @JsonProperty("p") Integer played,
			@JsonProperty("w_home") Integer winsHome, @JsonProperty("d_home") Integer drawsHome,
			@JsonProperty("l_home") Integer lossesHome, @JsonProperty("w_away") Integer winsAway,
			@JsonProperty("d_away") Integer drawsAway, @JsonProperty("l_away") Integer lossesAway,
			@JsonProperty("gf_home") Integer goalsScoredHome, @JsonProperty("ga_home") Integer goalsAwayHome,
			@JsonProperty("gf_away") Integer goalsScoredAway, @JsonProperty("ga_away") Integer goalsAwayAway,
			@JsonProperty("pts") Integer points, @JsonProperty("w_tot") Integer totalWins,
			@JsonProperty("d_tot") Integer drawsTotal, @JsonProperty("l_tot") Integer lossesTotal,
			@JsonProperty("gf_total") Integer goalsTotal, @JsonProperty("ga_total") Integer goalsAwayTotal,
			@JsonProperty("gd_home") Integer goalDifferenceHome, @JsonProperty("gd_away") Integer goalDifferenceAway,
			@JsonProperty("gd_total") Integer goalDifferenceTotal, @JsonProperty("position") Integer position) {
		super(teamSeasonId, teamSeasonName, played, winsHome, drawsHome, lossesHome, winsAway, drawsAway, lossesAway,
				goalsScoredHome, goalsAwayHome, goalsScoredAway, goalsAwayAway, points, totalWins, drawsTotal,
				lossesTotal, goalsTotal, goalsAwayTotal, goalDifferenceHome, goalDifferenceAway, goalDifferenceTotal,
				position);
		this.id = id;

	}

	public String getId() {
		return this.id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (this.id == null ? 0 : this.id.hashCode());
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
		StandingItem other = (StandingItem) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "StandingItem [id=" + this.id + ", toString()=" + super.toString() + "]";
	}

}
