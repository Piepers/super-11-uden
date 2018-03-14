package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * The Fixture domain object of the SportDeer API contains data about when a
 * match was scheduled and when it started and ended as well as references to
 * other data like teams etc.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 *         TODO: create structure by clubbing corresponding properties into
 *         classes.
 */
@DataObject
public class Fixture extends SportdeerDomainObject {

	@JsonProperty("id_country")
	private final Long countryId;
	@JsonProperty("id_league")
	private final Long leagueId;
	@JsonProperty("id_season")
	private final Long seasonId;
	@JsonProperty("id_stage")
	private final Long stageId;
	@JsonProperty("first_half_ended_at")
	private final String firstHalfEnd; // Formatted as yyyy-MM-ddTHH:mm:ss.SSSZ
	@JsonProperty("fixture_status") // TODO: make an enum of this.
	private final String status;
	@JsonProperty("fixture_status_short")
	private final String statusShort;
	@JsonProperty("game_ended_at")
	private final String gameEnd;
	@JsonProperty("game_started_at")
	private final String gameStart;
	@JsonProperty("id_referee")
	private final Long refereeId;
	@JsonProperty("id_team_season_away")
	private final Long teamSeasonAwyId;
	@JsonProperty("id_team_season_home")
	private final Long teamSeasonHmeId;
	@JsonProperty("lineup_confirmed")
	private final String lineUpConfirmed;
	@JsonProperty("number_goal_team_away")
	private final Integer goalsTeamAwy;
	@JsonProperty("number_goal_team_home")
	private final Integer goalsTeamHme;
	@JsonProperty("referee_name")
	private final String refereeName;
	@JsonProperty("round")
	private final Integer round;
	@JsonProperty("schedule_date")
	private final String scheduled;
	@JsonProperty("second_half_ended_at")
	private final String secondHalfEnd;
	@JsonProperty("second_half_started_at")
	private final String secondHalfStart;
	@JsonProperty("spectators")
	private final Integer spectators;
	@JsonProperty("stadium")
	private final String stadium;
	@JsonProperty("team_season_away_name")
	private final String teamSeasonAwy;
	@JsonProperty("team_season_home_name")
	private final String teamSeasonHme;

	public Fixture(JsonObject jsonObject) {
		super(jsonObject);
		this.countryId = this.docs.getLong("id_country");
		this.leagueId = this.docs.getLong("id_league");
		this.seasonId = this.docs.getLong("id_season");
		this.stageId = this.docs.getLong("id_stage");
		this.firstHalfEnd = this.docs.getString("first_half_ended_at");
		this.status = this.docs.getString("fixture_status");
		this.statusShort = this.docs.getString("fixture_status_short");
		this.gameEnd = this.docs.getString("game_ended_at");
		this.gameStart = this.docs.getString("game_started_at");
		this.refereeId = this.docs.getLong("id_referee");
		this.teamSeasonAwyId = this.docs.getLong("id_team_season_away");
		this.teamSeasonHmeId = this.docs.getLong("id_team_season_home");
		this.lineUpConfirmed = this.docs.getString("lineup_confirmed");
		this.goalsTeamAwy = this.docs.getInteger("number_goal_team_away");
		this.goalsTeamHme = this.docs.getInteger("number_goal_team_home");
		this.refereeName = this.docs.getString("referee_name");
		this.round = this.docs.getInteger("round");
		this.scheduled = this.docs.getString("schedule_date");
		this.secondHalfEnd = this.docs.getString("second_half_ended_at");
		this.secondHalfStart = this.docs.getString("second_half_started_at");
		this.spectators = this.docs.getInteger("spectators");
		this.stadium = this.docs.getString("stadium");
		this.teamSeasonAwy = this.docs.getString("team_season_away_name");
		this.teamSeasonHme = this.docs.getString("team_season_home_name");
	}

	private Fixture(Builder builder) {
		super(builder.id);
		this.countryId = builder.countryId;
		this.leagueId = builder.leagueId;
		this.seasonId = builder.seasonId;
		this.stageId = builder.stageId;
		this.firstHalfEnd = builder.firstHalfEnd;
		this.status = builder.status;
		this.statusShort = builder.statusShort;
		this.gameEnd = builder.gameEnd;
		this.gameStart = builder.gameStart;
		this.refereeId = builder.refereeId;
		this.teamSeasonAwyId = builder.teamSeasonAwyId;
		this.teamSeasonHmeId = builder.teamSeasonHmeId;
		this.lineUpConfirmed = builder.lineUpConfirmed;
		this.goalsTeamAwy = builder.goalsTeamAwy;
		this.goalsTeamHme = builder.goalsTeamHme;
		this.refereeName = builder.refereeName;
		this.round = builder.round;
		this.scheduled = builder.scheduled;
		this.secondHalfEnd = builder.secondHalfEnd;
		this.secondHalfStart = builder.secondHalfStart;
		this.spectators = builder.spectators;
		this.stadium = builder.stadium;
		this.teamSeasonAwy = builder.teamSeasonAwy;
		this.teamSeasonHme = builder.teamSeasonHme;
	}

	public Long getCountryId() {
		return this.countryId;
	}

	public Long getLeagueId() {
		return this.leagueId;
	}

	public Long getSeasonId() {
		return this.seasonId;
	}

	public Long getStageId() {
		return this.stageId;
	}

	public String getFirstHalfEnd() {
		return this.firstHalfEnd;
	}

	public String getStatus() {
		return this.status;
	}

	public String getStatusShort() {
		return this.statusShort;
	}

	public String getGameEnd() {
		return this.gameEnd;
	}

	public String getGameStart() {
		return this.gameStart;
	}

	public Long getRefereeId() {
		return this.refereeId;
	}

	public Long getTeamSeasonAwyId() {
		return this.teamSeasonAwyId;
	}

	public Long getTeamSeasonHmeId() {
		return this.teamSeasonHmeId;
	}

	public String getLineUpConfirmed() {
		return this.lineUpConfirmed;
	}

	public Integer getGoalsTeamAwy() {
		return this.goalsTeamAwy;
	}

	public Integer getGoalsTeamHme() {
		return this.goalsTeamHme;
	}

	public String getRefereeName() {
		return this.refereeName;
	}

	public Integer getRound() {
		return this.round;
	}

	public String getScheduled() {
		return this.scheduled;
	}

	public String getSecondHalfEnd() {
		return this.secondHalfEnd;
	}

	public String getSecondHalfStart() {
		return this.secondHalfStart;
	}

	public Integer getSpectators() {
		return this.spectators;
	}

	public String getStadium() {
		return this.stadium;
	}

	public String getTeamSeasonAwy() {
		return this.teamSeasonAwy;
	}

	public String getTeamSeasonHme() {
		return this.teamSeasonHme;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (this.countryId == null ? 0 : this.countryId.hashCode());
		result = prime * result + (this.firstHalfEnd == null ? 0 : this.firstHalfEnd.hashCode());
		result = prime * result + (this.gameEnd == null ? 0 : this.gameEnd.hashCode());
		result = prime * result + (this.gameStart == null ? 0 : this.gameStart.hashCode());
		result = prime * result + (this.goalsTeamAwy == null ? 0 : this.goalsTeamAwy.hashCode());
		result = prime * result + (this.goalsTeamHme == null ? 0 : this.goalsTeamHme.hashCode());
		result = prime * result + (this.leagueId == null ? 0 : this.leagueId.hashCode());
		result = prime * result + (this.lineUpConfirmed == null ? 0 : this.lineUpConfirmed.hashCode());
		result = prime * result + (this.refereeId == null ? 0 : this.refereeId.hashCode());
		result = prime * result + (this.refereeName == null ? 0 : this.refereeName.hashCode());
		result = prime * result + (this.round == null ? 0 : this.round.hashCode());
		result = prime * result + (this.scheduled == null ? 0 : this.scheduled.hashCode());
		result = prime * result + (this.seasonId == null ? 0 : this.seasonId.hashCode());
		result = prime * result + (this.secondHalfEnd == null ? 0 : this.secondHalfEnd.hashCode());
		result = prime * result + (this.secondHalfStart == null ? 0 : this.secondHalfStart.hashCode());
		result = prime * result + (this.spectators == null ? 0 : this.spectators.hashCode());
		result = prime * result + (this.stadium == null ? 0 : this.stadium.hashCode());
		result = prime * result + (this.stageId == null ? 0 : this.stageId.hashCode());
		result = prime * result + (this.status == null ? 0 : this.status.hashCode());
		result = prime * result + (this.statusShort == null ? 0 : this.statusShort.hashCode());
		result = prime * result + (this.teamSeasonAwy == null ? 0 : this.teamSeasonAwy.hashCode());
		result = prime * result + (this.teamSeasonAwyId == null ? 0 : this.teamSeasonAwyId.hashCode());
		result = prime * result + (this.teamSeasonHme == null ? 0 : this.teamSeasonHme.hashCode());
		result = prime * result + (this.teamSeasonHmeId == null ? 0 : this.teamSeasonHmeId.hashCode());
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
		Fixture other = (Fixture) obj;
		if (this.countryId == null) {
			if (other.countryId != null) {
				return false;
			}
		} else if (!this.countryId.equals(other.countryId)) {
			return false;
		}
		if (this.firstHalfEnd == null) {
			if (other.firstHalfEnd != null) {
				return false;
			}
		} else if (!this.firstHalfEnd.equals(other.firstHalfEnd)) {
			return false;
		}
		if (this.gameEnd == null) {
			if (other.gameEnd != null) {
				return false;
			}
		} else if (!this.gameEnd.equals(other.gameEnd)) {
			return false;
		}
		if (this.gameStart == null) {
			if (other.gameStart != null) {
				return false;
			}
		} else if (!this.gameStart.equals(other.gameStart)) {
			return false;
		}
		if (this.goalsTeamAwy == null) {
			if (other.goalsTeamAwy != null) {
				return false;
			}
		} else if (!this.goalsTeamAwy.equals(other.goalsTeamAwy)) {
			return false;
		}
		if (this.goalsTeamHme == null) {
			if (other.goalsTeamHme != null) {
				return false;
			}
		} else if (!this.goalsTeamHme.equals(other.goalsTeamHme)) {
			return false;
		}
		if (this.leagueId == null) {
			if (other.leagueId != null) {
				return false;
			}
		} else if (!this.leagueId.equals(other.leagueId)) {
			return false;
		}
		if (this.lineUpConfirmed == null) {
			if (other.lineUpConfirmed != null) {
				return false;
			}
		} else if (!this.lineUpConfirmed.equals(other.lineUpConfirmed)) {
			return false;
		}
		if (this.refereeId == null) {
			if (other.refereeId != null) {
				return false;
			}
		} else if (!this.refereeId.equals(other.refereeId)) {
			return false;
		}
		if (this.refereeName == null) {
			if (other.refereeName != null) {
				return false;
			}
		} else if (!this.refereeName.equals(other.refereeName)) {
			return false;
		}
		if (this.round == null) {
			if (other.round != null) {
				return false;
			}
		} else if (!this.round.equals(other.round)) {
			return false;
		}
		if (this.scheduled == null) {
			if (other.scheduled != null) {
				return false;
			}
		} else if (!this.scheduled.equals(other.scheduled)) {
			return false;
		}
		if (this.seasonId == null) {
			if (other.seasonId != null) {
				return false;
			}
		} else if (!this.seasonId.equals(other.seasonId)) {
			return false;
		}
		if (this.secondHalfEnd == null) {
			if (other.secondHalfEnd != null) {
				return false;
			}
		} else if (!this.secondHalfEnd.equals(other.secondHalfEnd)) {
			return false;
		}
		if (this.secondHalfStart == null) {
			if (other.secondHalfStart != null) {
				return false;
			}
		} else if (!this.secondHalfStart.equals(other.secondHalfStart)) {
			return false;
		}
		if (this.spectators == null) {
			if (other.spectators != null) {
				return false;
			}
		} else if (!this.spectators.equals(other.spectators)) {
			return false;
		}
		if (this.stadium == null) {
			if (other.stadium != null) {
				return false;
			}
		} else if (!this.stadium.equals(other.stadium)) {
			return false;
		}
		if (this.stageId == null) {
			if (other.stageId != null) {
				return false;
			}
		} else if (!this.stageId.equals(other.stageId)) {
			return false;
		}
		if (this.status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!this.status.equals(other.status)) {
			return false;
		}
		if (this.statusShort == null) {
			if (other.statusShort != null) {
				return false;
			}
		} else if (!this.statusShort.equals(other.statusShort)) {
			return false;
		}
		if (this.teamSeasonAwy == null) {
			if (other.teamSeasonAwy != null) {
				return false;
			}
		} else if (!this.teamSeasonAwy.equals(other.teamSeasonAwy)) {
			return false;
		}
		if (this.teamSeasonAwyId == null) {
			if (other.teamSeasonAwyId != null) {
				return false;
			}
		} else if (!this.teamSeasonAwyId.equals(other.teamSeasonAwyId)) {
			return false;
		}
		if (this.teamSeasonHme == null) {
			if (other.teamSeasonHme != null) {
				return false;
			}
		} else if (!this.teamSeasonHme.equals(other.teamSeasonHme)) {
			return false;
		}
		if (this.teamSeasonHmeId == null) {
			if (other.teamSeasonHmeId != null) {
				return false;
			}
		} else if (!this.teamSeasonHmeId.equals(other.teamSeasonHmeId)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Fixture [id=" + this.getId() + ", countryId=" + this.countryId + ", leagueId=" + this.leagueId
				+ ", seasonId=" + this.seasonId + ", stageId=" + this.stageId + ", firstHalfEnd=" + this.firstHalfEnd
				+ ", status=" + this.status + ", statusShort=" + this.statusShort + ", gameEnd=" + this.gameEnd
				+ ", gameStart=" + this.gameStart + ", refereeId=" + this.refereeId + ", teamSeasonAwyId="
				+ this.teamSeasonAwyId + ", teamSeasonHmeId=" + this.teamSeasonHmeId + ", lineUpConfirmed="
				+ this.lineUpConfirmed + ", goalsTeamAwy=" + this.goalsTeamAwy + ", goalsTeamHme=" + this.goalsTeamHme
				+ ", refereeName=" + this.refereeName + ", round=" + this.round + ", scheduled=" + this.scheduled
				+ ", secondHalfEnd=" + this.secondHalfEnd + ", secondHalfStart=" + this.secondHalfStart
				+ ", spectators=" + this.spectators + ", stadium=" + this.stadium + ", teamSeasonAwy="
				+ this.teamSeasonAwy + ", teamSeasonHme=" + this.teamSeasonHme + "]";
	}

	@JsonPOJOBuilder
	static class Builder {
		private final Long id;
		private Long countryId;
		private Long leagueId;
		private Long seasonId;
		private Long stageId;
		private String firstHalfEnd;
		private String status;
		private String statusShort;
		private String gameEnd;
		private String gameStart;
		private Long refereeId;
		private Long teamSeasonAwyId;
		private Long teamSeasonHmeId;
		private String lineUpConfirmed;
		private Integer goalsTeamAwy;
		private Integer goalsTeamHme;
		private String refereeName;
		private Integer round;
		private String scheduled;
		private String secondHalfEnd;
		private String secondHalfStart;
		private Integer spectators;
		private String stadium;
		private String teamSeasonAwy;
		private String teamSeasonHme;

		public Builder(Long id) {
			this.id = id;
		}

		public Builder countryId(Long countryId) {
			this.countryId = countryId;
			return this;
		}

		public Builder leagueId(Long leagueId) {
			this.leagueId = leagueId;
			return this;
		}

		public Builder seasonId(Long seasonId) {
			this.seasonId = seasonId;
			return this;
		}

		public Builder stageId(Long stageId) {
			this.stageId = stageId;
			return this;
		}

		public Builder firstHalfEnd(String firstHalfEnd) {
			this.firstHalfEnd = firstHalfEnd;
			return this;
		}

		public Builder status(String status) {
			this.status = status;
			return this;
		}

		public Builder statusShort(String statusShort) {
			this.statusShort = statusShort;
			return this;
		}

		public Builder gameEnd(String gameEnd) {
			this.gameEnd = gameEnd;
			return this;
		}

		public Builder gameStart(String gameStart) {
			this.gameStart = gameStart;
			return this;
		}

		public Builder refereeId(Long refereeId) {
			this.refereeId = refereeId;
			return this;
		}

		public Builder teamSeasonAwyId(Long teamSeasonAwyId) {
			this.teamSeasonAwyId = teamSeasonAwyId;
			return this;
		}

		public Builder teamSeasonHmeId(Long teamSeasonHmeId) {
			this.teamSeasonHmeId = teamSeasonHmeId;
			return this;
		}

		public Builder lineUpConfirmed(String lineUpConfirmed) {
			this.lineUpConfirmed = lineUpConfirmed;
			return this;
		}

		public Builder goalsTeamAwy(Integer goalsTeamAwy) {
			this.goalsTeamAwy = goalsTeamAwy;
			return this;
		}

		public Builder goalsTeamHme(Integer goalsTeamHme) {
			this.goalsTeamHme = goalsTeamHme;
			return this;
		}

		public Builder refereeName(String refereeName) {
			this.refereeName = refereeName;
			return this;
		}

		public Builder round(Integer round) {
			this.round = round;
			return this;
		}

		public Builder scheduled(String scheduled) {
			this.scheduled = scheduled;
			return this;
		}

		public Builder secondHalfEnd(String secondHalfEnd) {
			this.secondHalfEnd = secondHalfEnd;
			return this;
		}

		public Builder secondHalfStart(String secondHalfStart) {
			this.secondHalfStart = secondHalfStart;
			return this;
		}

		public Builder spectators(Integer spectators) {
			this.spectators = spectators;
			return this;
		}

		public Builder stadium(String stadium) {
			this.stadium = stadium;
			return this;
		}

		public Builder teamSeasonAwy(String teamSeasonAwy) {
			this.teamSeasonAwy = teamSeasonAwy;
			return this;
		}

		public Builder teamSeasonHme(String teamSeasonHme) {
			this.teamSeasonHme = teamSeasonHme;
			return this;
		}

		public Fixture build() {
			return new Fixture(this);
		}
	}

}
