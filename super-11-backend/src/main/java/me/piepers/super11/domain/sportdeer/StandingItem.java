package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * The standing of a particular team and the statistics of the team for this
 * standing.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class StandingItem {

	@JsonProperty("_id")
	private final String id;
	@JsonProperty("id_team_season")
	private final Long teamSeasonId;
	@JsonProperty("team_season_name")
	private final String teamSeasonName;
	@JsonProperty("p")
	private final Integer played;
	@JsonProperty("w_home")
	private final Integer winsHome;
	@JsonProperty("d_home")
	private final Integer drawsHome;
	@JsonProperty("l_home")
	private final Integer lossesHome;
	@JsonProperty("w_away")
	private final Integer winsAway;
	@JsonProperty("d_away")
	private final Integer drawsAway;
	@JsonProperty("l_away")
	private final Integer lossesAway;
	@JsonProperty("gf_home")
	private final Integer goalsScoredHome;
	@JsonProperty("ga_home")
	private final Integer goalsAwayHome;
	@JsonProperty("gf_away")
	private final Integer goalsScoredAway;
	@JsonProperty("ga_away")
	private final Integer goalsAwayAway;
	@JsonProperty("pts")
	private final Integer points;
	@JsonProperty("w_tot")
	private final Integer winsTotal;
	@JsonProperty("d_tot")
	private final Integer drawsTotal;
	@JsonProperty("l_tot")
	private final Integer lossesTotal;
	@JsonProperty("gf_tot")
	private final Integer goalsTotal;
	@JsonProperty("ga_tot")
	private final Integer goalsAwayTotal;
	@JsonProperty("gd_home")
	private final Integer goalDifferenceHome;
	@JsonProperty("gd_away")
	private final Integer goalDifferenceAway;
	@JsonProperty("gd_tot")
	private final Integer goalDifferenceTotal;
	@JsonProperty("position")
	private final Integer position;

	public StandingItem(JsonObject jsonObject) {
		this.id = jsonObject.getString("_id");
		this.teamSeasonId = jsonObject.getLong("id_team_season");
		this.teamSeasonName = jsonObject.getString("team_season_name");
		this.played = jsonObject.getInteger("p");
		this.winsHome = jsonObject.getInteger("w_home");
		this.drawsHome = jsonObject.getInteger("d_home");
		this.lossesHome = jsonObject.getInteger("l_home");
		this.winsAway = jsonObject.getInteger("w_away");
		this.drawsAway = jsonObject.getInteger("d_away");
		this.lossesAway = jsonObject.getInteger("l_away");
		this.goalsScoredHome = jsonObject.getInteger("gf_home");
		this.goalsAwayHome = jsonObject.getInteger("ga_home");
		this.goalsScoredAway = jsonObject.getInteger("gf_away");
		this.goalsAwayAway = jsonObject.getInteger("ga_away");
		this.points = jsonObject.getInteger("pts");
		this.winsTotal = jsonObject.getInteger("w_tot");
		this.drawsTotal = jsonObject.getInteger("d_tot");
		this.lossesTotal = jsonObject.getInteger("l_tot");
		this.goalsTotal = jsonObject.getInteger("gf_tot");
		this.goalsAwayTotal = jsonObject.getInteger("ga_tot");
		this.goalDifferenceHome = jsonObject.getInteger("gd_home");
		this.goalDifferenceAway = jsonObject.getInteger("gd_away");
		this.goalDifferenceTotal = jsonObject.getInteger("gd_tot");
		this.position = jsonObject.getInteger("position");
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
		this.id = id;
		this.teamSeasonId = teamSeasonId;
		this.teamSeasonName = teamSeasonName;
		this.played = played;
		this.winsHome = winsHome;
		this.drawsHome = drawsHome;
		this.lossesHome = lossesHome;
		this.winsAway = winsAway;
		this.drawsAway = drawsAway;
		this.lossesAway = lossesAway;
		this.goalsScoredHome = goalsScoredHome;
		this.goalsAwayHome = goalsAwayHome;
		this.goalsScoredAway = goalsScoredAway;
		this.goalsAwayAway = goalsAwayAway;
		this.points = points;
		this.winsTotal = totalWins;
		this.drawsTotal = drawsTotal;
		this.lossesTotal = lossesTotal;
		this.goalsTotal = goalsTotal;
		this.goalsAwayTotal = goalsAwayTotal;
		this.goalDifferenceHome = goalDifferenceHome;
		this.goalDifferenceAway = goalDifferenceAway;
		this.goalDifferenceTotal = goalDifferenceTotal;
		this.position = position;
	}

	public String getId() {
		return this.id;
	}

	public Long getTeamSeasonId() {
		return this.teamSeasonId;
	}

	public String getTeamSeasonName() {
		return this.teamSeasonName;
	}

	public Integer getPlayed() {
		return this.played;
	}

	public Integer getWinsHome() {
		return this.winsHome;
	}

	public Integer getDrawsHome() {
		return this.drawsHome;
	}

	public Integer getLossesHome() {
		return this.lossesHome;
	}

	public Integer getWinsAway() {
		return this.winsAway;
	}

	public Integer getDrawsAway() {
		return this.drawsAway;
	}

	public Integer getLossesAway() {
		return this.lossesAway;
	}

	public Integer getGoalsScoredHome() {
		return this.goalsScoredHome;
	}

	public Integer getGoalsAwayHome() {
		return this.goalsAwayHome;
	}

	public Integer getGoalsScoredAway() {
		return this.goalsScoredAway;
	}

	public Integer getGoalsAwayAway() {
		return this.goalsAwayAway;
	}

	public Integer getPoints() {
		return this.points;
	}

	public Integer getWinsTotal() {
		return this.winsTotal;
	}

	public Integer getDrawsTotal() {
		return this.drawsTotal;
	}

	public Integer getLossesTotal() {
		return this.lossesTotal;
	}

	public Integer getGoalsTotal() {
		return this.goalsTotal;
	}

	public Integer getGoalsAwayTotal() {
		return this.goalsAwayTotal;
	}

	public Integer getGoalDifferenceHome() {
		return this.goalDifferenceHome;
	}

	public Integer getGoalDifferenceAway() {
		return this.goalDifferenceAway;
	}

	public Integer getGoalDifferenceTotal() {
		return this.goalDifferenceTotal;
	}

	public Integer getPosition() {
		return this.position;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.drawsAway == null ? 0 : this.drawsAway.hashCode());
		result = prime * result + (this.drawsHome == null ? 0 : this.drawsHome.hashCode());
		result = prime * result + (this.drawsTotal == null ? 0 : this.drawsTotal.hashCode());
		result = prime * result + (this.goalDifferenceAway == null ? 0 : this.goalDifferenceAway.hashCode());
		result = prime * result + (this.goalDifferenceHome == null ? 0 : this.goalDifferenceHome.hashCode());
		result = prime * result + (this.goalDifferenceTotal == null ? 0 : this.goalDifferenceTotal.hashCode());
		result = prime * result + (this.goalsAwayAway == null ? 0 : this.goalsAwayAway.hashCode());
		result = prime * result + (this.goalsAwayHome == null ? 0 : this.goalsAwayHome.hashCode());
		result = prime * result + (this.goalsAwayTotal == null ? 0 : this.goalsAwayTotal.hashCode());
		result = prime * result + (this.goalsScoredAway == null ? 0 : this.goalsScoredAway.hashCode());
		result = prime * result + (this.goalsScoredHome == null ? 0 : this.goalsScoredHome.hashCode());
		result = prime * result + (this.goalsTotal == null ? 0 : this.goalsTotal.hashCode());
		result = prime * result + (this.id == null ? 0 : this.id.hashCode());
		result = prime * result + (this.lossesAway == null ? 0 : this.lossesAway.hashCode());
		result = prime * result + (this.lossesHome == null ? 0 : this.lossesHome.hashCode());
		result = prime * result + (this.lossesTotal == null ? 0 : this.lossesTotal.hashCode());
		result = prime * result + (this.played == null ? 0 : this.played.hashCode());
		result = prime * result + (this.points == null ? 0 : this.points.hashCode());
		result = prime * result + (this.position == null ? 0 : this.position.hashCode());
		result = prime * result + (this.teamSeasonId == null ? 0 : this.teamSeasonId.hashCode());
		result = prime * result + (this.teamSeasonName == null ? 0 : this.teamSeasonName.hashCode());
		result = prime * result + (this.winsTotal == null ? 0 : this.winsTotal.hashCode());
		result = prime * result + (this.winsAway == null ? 0 : this.winsAway.hashCode());
		result = prime * result + (this.winsHome == null ? 0 : this.winsHome.hashCode());
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
		StandingItem other = (StandingItem) obj;
		if (this.drawsAway == null) {
			if (other.drawsAway != null) {
				return false;
			}
		} else if (!this.drawsAway.equals(other.drawsAway)) {
			return false;
		}
		if (this.drawsHome == null) {
			if (other.drawsHome != null) {
				return false;
			}
		} else if (!this.drawsHome.equals(other.drawsHome)) {
			return false;
		}
		if (this.drawsTotal == null) {
			if (other.drawsTotal != null) {
				return false;
			}
		} else if (!this.drawsTotal.equals(other.drawsTotal)) {
			return false;
		}
		if (this.goalDifferenceAway == null) {
			if (other.goalDifferenceAway != null) {
				return false;
			}
		} else if (!this.goalDifferenceAway.equals(other.goalDifferenceAway)) {
			return false;
		}
		if (this.goalDifferenceHome == null) {
			if (other.goalDifferenceHome != null) {
				return false;
			}
		} else if (!this.goalDifferenceHome.equals(other.goalDifferenceHome)) {
			return false;
		}
		if (this.goalDifferenceTotal == null) {
			if (other.goalDifferenceTotal != null) {
				return false;
			}
		} else if (!this.goalDifferenceTotal.equals(other.goalDifferenceTotal)) {
			return false;
		}
		if (this.goalsAwayAway == null) {
			if (other.goalsAwayAway != null) {
				return false;
			}
		} else if (!this.goalsAwayAway.equals(other.goalsAwayAway)) {
			return false;
		}
		if (this.goalsAwayHome == null) {
			if (other.goalsAwayHome != null) {
				return false;
			}
		} else if (!this.goalsAwayHome.equals(other.goalsAwayHome)) {
			return false;
		}
		if (this.goalsAwayTotal == null) {
			if (other.goalsAwayTotal != null) {
				return false;
			}
		} else if (!this.goalsAwayTotal.equals(other.goalsAwayTotal)) {
			return false;
		}
		if (this.goalsScoredAway == null) {
			if (other.goalsScoredAway != null) {
				return false;
			}
		} else if (!this.goalsScoredAway.equals(other.goalsScoredAway)) {
			return false;
		}
		if (this.goalsScoredHome == null) {
			if (other.goalsScoredHome != null) {
				return false;
			}
		} else if (!this.goalsScoredHome.equals(other.goalsScoredHome)) {
			return false;
		}
		if (this.goalsTotal == null) {
			if (other.goalsTotal != null) {
				return false;
			}
		} else if (!this.goalsTotal.equals(other.goalsTotal)) {
			return false;
		}
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		if (this.lossesAway == null) {
			if (other.lossesAway != null) {
				return false;
			}
		} else if (!this.lossesAway.equals(other.lossesAway)) {
			return false;
		}
		if (this.lossesHome == null) {
			if (other.lossesHome != null) {
				return false;
			}
		} else if (!this.lossesHome.equals(other.lossesHome)) {
			return false;
		}
		if (this.lossesTotal == null) {
			if (other.lossesTotal != null) {
				return false;
			}
		} else if (!this.lossesTotal.equals(other.lossesTotal)) {
			return false;
		}
		if (this.played == null) {
			if (other.played != null) {
				return false;
			}
		} else if (!this.played.equals(other.played)) {
			return false;
		}
		if (this.points == null) {
			if (other.points != null) {
				return false;
			}
		} else if (!this.points.equals(other.points)) {
			return false;
		}
		if (this.position == null) {
			if (other.position != null) {
				return false;
			}
		} else if (!this.position.equals(other.position)) {
			return false;
		}
		if (this.teamSeasonId == null) {
			if (other.teamSeasonId != null) {
				return false;
			}
		} else if (!this.teamSeasonId.equals(other.teamSeasonId)) {
			return false;
		}
		if (this.teamSeasonName == null) {
			if (other.teamSeasonName != null) {
				return false;
			}
		} else if (!this.teamSeasonName.equals(other.teamSeasonName)) {
			return false;
		}
		if (this.winsTotal == null) {
			if (other.winsTotal != null) {
				return false;
			}
		} else if (!this.winsTotal.equals(other.winsTotal)) {
			return false;
		}
		if (this.winsAway == null) {
			if (other.winsAway != null) {
				return false;
			}
		} else if (!this.winsAway.equals(other.winsAway)) {
			return false;
		}
		if (this.winsHome == null) {
			if (other.winsHome != null) {
				return false;
			}
		} else if (!this.winsHome.equals(other.winsHome)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "StandingItem [id=" + this.id + ", teamSeasonId=" + this.teamSeasonId + ", teamSeasonName="
				+ this.teamSeasonName + ", played=" + this.played + ", winsHome=" + this.winsHome + ", drawsHome="
				+ this.drawsHome + ", lossesHome=" + this.lossesHome + ", winsAway=" + this.winsAway + ", drawsAway="
				+ this.drawsAway + ", lossesAway=" + this.lossesAway + ", goalsScoredHome=" + this.goalsScoredHome
				+ ", goalsAwayHome=" + this.goalsAwayHome + ", goalsScoredAway=" + this.goalsScoredAway
				+ ", goalsAwayAway=" + this.goalsAwayAway + ", points=" + this.points + ", totalWins=" + this.winsTotal
				+ ", drawsTotal=" + this.drawsTotal + ", lossesTotal=" + this.lossesTotal + ", goalsTotal="
				+ this.goalsTotal + ", goalsAwayTotal=" + this.goalsAwayTotal + ", goalDifferenceHome="
				+ this.goalDifferenceHome + ", goalDifferenceAway=" + this.goalDifferenceAway + ", goalDifferenceTotal="
				+ this.goalDifferenceTotal + ", position=" + this.position + "]";
	}

}
