package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
 */
@DataObject
@JsonDeserialize(builder = Fixture.Builder.class)
@JsonPropertyOrder({ "_id" })
public class Fixture extends SportdeerDomainObject {
	@JsonUnwrapped
	private final CountryId countryId;
	@JsonUnwrapped
	private final LeagueId leagueId;
	@JsonUnwrapped
	private final SeasonId seasonId;
	@JsonUnwrapped
	private final StageId stageId;
	@JsonUnwrapped
	private final GameTimings gameTimings;
	@JsonUnwrapped
	private final FixtureStatus fixtureStatus;
	@JsonUnwrapped
	private final Referee referee;
	@JsonUnwrapped
	private final TeamSeasonIds teamSeasonIds;
	@JsonUnwrapped
	private final TeamSeasonNames teamSeasonNames;
	@JsonUnwrapped
	private final Goals goals;
	@JsonProperty("lineup_confirmed")
	private final String lineUpConfirmed;
	@JsonProperty("round")
	private final String round;
	@JsonProperty("schedule_date")
	private final String scheduled;
	@JsonProperty("spectators")
	private final Integer spectators;
	@JsonProperty("stadium")
	private final String stadium;

	// FIXME: use ObjectMapper of Jackson to map this if possible.
	public Fixture(JsonObject jsonObject) {
		super(jsonObject);
		this.countryId = CountryId.of(jsonObject.getLong("id_country"));
		this.leagueId = LeagueId.of(jsonObject.getLong("id_league"));
		this.seasonId = SeasonId.of(jsonObject.getLong("id_season"));
		this.stageId = StageId.of(jsonObject.getLong("id_stage"));
		this.gameTimings = GameTimings.of(jsonObject.getString("game_started_at"),
				jsonObject.getString("game_ended_at"), jsonObject.getString("first_half_ended_at"),
				jsonObject.getString("second_half_started_at"), jsonObject.getString("second_half_ended_at"));
		this.fixtureStatus = FixtureStatus.of(jsonObject.getString("fixture_status"),
				jsonObject.getString("fixture_status_short"));
		this.referee = Referee.of(RefereeId.of(jsonObject.getLong("id_referee")), jsonObject.getString("referee_name"));
		this.teamSeasonIds = TeamSeasonIds.of(jsonObject.getLong("id_team_season_home"),
				jsonObject.getLong("id_team_season_away"));
		this.lineUpConfirmed = jsonObject.getString("lineup_confirmed");
		this.goals = Goals.of(jsonObject.getInteger("number_goal_team_home"),
				jsonObject.getInteger("number_goal_team_away"));
		this.round = jsonObject.getString("round");
		this.scheduled = jsonObject.getString("schedule_date");
		this.spectators = jsonObject.getInteger("spectators");
		this.stadium = jsonObject.getString("stadium");
		this.teamSeasonNames = TeamSeasonNames.of(jsonObject.getString("team_season_home_name"),
				jsonObject.getString("team_season_away_name"));
	}

	private Fixture(Builder builder) {
		super(builder.id);
		this.countryId = builder.countryId;
		this.leagueId = builder.leagueId;
		this.seasonId = builder.seasonId;
		this.stageId = builder.stageId;
		this.gameTimings = builder.gameTimings;
		this.fixtureStatus = builder.fixtureStatus;
		this.referee = builder.referee;
		this.teamSeasonIds = builder.teamSeasonIds;
		this.teamSeasonNames = builder.teamSeasonNames;
		this.goals = builder.goals;
		this.lineUpConfirmed = builder.lineupConfirmed;
		this.round = builder.round;
		this.scheduled = builder.scheduled;
		this.spectators = builder.spectators;
		this.stadium = builder.stadium;
	}

	public CountryId getCountryId() {
		return this.countryId;
	}

	public LeagueId getLeagueId() {
		return this.leagueId;
	}

	public SeasonId getSeasonId() {
		return this.seasonId;
	}

	public StageId getStageId() {
		return this.stageId;
	}

	public GameTimings getGameTimings() {
		return this.gameTimings;
	}

	public FixtureStatus getFixtureStatus() {
		return this.fixtureStatus;
	}

	public Referee getReferee() {
		return this.referee;
	}

	public TeamSeasonIds getTeamSeasonIds() {
		return this.teamSeasonIds;
	}

	public TeamSeasonNames getTeamSeasonNames() {
		return this.teamSeasonNames;
	}

	public Goals getGoals() {
		return this.goals;
	}

	public String getLineUpConfirmed() {
		return this.lineUpConfirmed;
	}

	public String getRound() {
		return this.round;
	}

	public String getScheduled() {
		return this.scheduled;
	}

	public Integer getSpectators() {
		return this.spectators;
	}

	public String getStadium() {
		return this.stadium;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Fixture fixture = (Fixture) o;

		if (!countryId.equals(fixture.countryId)) return false;
		if (!leagueId.equals(fixture.leagueId)) return false;
		if (!seasonId.equals(fixture.seasonId)) return false;
		if (!stageId.equals(fixture.stageId)) return false;
		if (!gameTimings.equals(fixture.gameTimings)) return false;
		if (!fixtureStatus.equals(fixture.fixtureStatus)) return false;
		if (!referee.equals(fixture.referee)) return false;
		if (!teamSeasonIds.equals(fixture.teamSeasonIds)) return false;
		if (!teamSeasonNames.equals(fixture.teamSeasonNames)) return false;
		if (!goals.equals(fixture.goals)) return false;
		if (!lineUpConfirmed.equals(fixture.lineUpConfirmed)) return false;
		if (!round.equals(fixture.round)) return false;
		if (!scheduled.equals(fixture.scheduled)) return false;
		if (!spectators.equals(fixture.spectators)) return false;
		return stadium.equals(fixture.stadium);
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + countryId.hashCode();
		result = 31 * result + leagueId.hashCode();
		result = 31 * result + seasonId.hashCode();
		result = 31 * result + stageId.hashCode();
		result = 31 * result + gameTimings.hashCode();
		result = 31 * result + fixtureStatus.hashCode();
		result = 31 * result + referee.hashCode();
		result = 31 * result + teamSeasonIds.hashCode();
		result = 31 * result + teamSeasonNames.hashCode();
		result = 31 * result + goals.hashCode();
		result = 31 * result + lineUpConfirmed.hashCode();
		result = 31 * result + round.hashCode();
		result = 31 * result + scheduled.hashCode();
		result = 31 * result + spectators.hashCode();
		result = 31 * result + stadium.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Fixture [id=" + this.getId() + ", countryId=" + this.countryId + ", leagueId=" + this.leagueId
				+ ", seasonId=" + this.seasonId + ", stageId=" + this.stageId + ", gameTimings=" + this.gameTimings
				+ ", fixtureStatus=" + this.fixtureStatus + ", referee=" + this.referee + ", teamSeasonIds="
				+ this.teamSeasonIds + ", teamSeasonNames=" + this.teamSeasonNames + ", goals=" + this.goals
				+ ", lineUpConfirmed=" + this.lineUpConfirmed + ", round=" + this.round + ", scheduled="
				+ this.scheduled + ", spectators=" + this.spectators + ", stadium=" + this.stadium + "]";
	}

	@JsonPOJOBuilder(withPrefix = "")
	public static class Builder {
		// TODO: how to make this generic if there is a Builder as the Creator?
		private final Long id;
		@JsonUnwrapped
		private CountryId countryId;
		@JsonUnwrapped
		private LeagueId leagueId;
		@JsonUnwrapped
		private SeasonId seasonId;
		@JsonUnwrapped
		private StageId stageId;
		@JsonUnwrapped
		private GameTimings gameTimings;
		@JsonUnwrapped
		private FixtureStatus fixtureStatus;
		@JsonUnwrapped
		private Referee referee;
		@JsonUnwrapped
		private TeamSeasonIds teamSeasonIds;
		@JsonUnwrapped
		private TeamSeasonNames teamSeasonNames;
		@JsonUnwrapped
		private Goals goals;
		@JsonProperty("lineup_confirmed")
		private String lineupConfirmed;
		@JsonProperty("round")
		private String round;
		@JsonProperty("schedule_date")
		private String scheduled;
		@JsonProperty("spectators")
		private Integer spectators;
		@JsonProperty("stadium")
		private String stadium;

		public Builder(@JsonProperty("_id") Long id) {
			this.id = id;
		}

		public Builder countryId(CountryId countryId) {
			this.countryId = countryId;
			return this;
		}

		public Builder leagueId(LeagueId leagueId) {
			this.leagueId = leagueId;
			return this;
		}

		public Builder seasonId(SeasonId seasonId) {
			this.seasonId = seasonId;
			return this;
		}

		public Builder stageId(StageId stageId) {
			this.stageId = stageId;
			return this;
		}

		public Builder gameTimings(GameTimings gameTimings) {
			this.gameTimings = gameTimings;
			return this;
		}

		public Builder fixtureStatus(FixtureStatus fixtureStatus) {
			this.fixtureStatus = fixtureStatus;
			return this;
		}

		public Builder referee(Referee referee) {
			this.referee = referee;
			return this;
		}

		public Builder teamSeasonIds(TeamSeasonIds teamSeasonIds) {
			this.teamSeasonIds = teamSeasonIds;
			return this;
		}

		public Builder teamSeasonNames(TeamSeasonNames teamSeasonNames) {
			this.teamSeasonNames = teamSeasonNames;
			return this;
		}

		public Builder goals(Goals goals) {
			this.goals = goals;
			return this;
		}

		public Builder lineupConfirmed(String lineupConfirmed) {
			this.lineupConfirmed = lineupConfirmed;
			return this;
		}

		public Builder round(String round) {
			this.round = round;
			return this;
		}

		public Builder scheduled(String scheduled) {
			this.scheduled = scheduled;
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

		public Fixture build() {
			return new Fixture(this);
		}
	}

}
