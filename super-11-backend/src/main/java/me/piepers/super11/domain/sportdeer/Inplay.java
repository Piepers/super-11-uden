package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * Represents all the live matches that are currently active (may return an
 * empty result).
 *
 * @author Bas Piepers (bas@piepers.me)
 */
@DataObject
public class Inplay extends SportdeerDomainObject {

	@JsonUnwrapped
	private final CountryId countryId;
	@JsonUnwrapped
	private final LeagueId leagueId;
	@JsonUnwrapped
	private final SeasonId seasonId;
	@JsonUnwrapped
	private final StageId stageId;
	@JsonUnwrapped
	private final FixtureStatus fixtureStatus;
	@JsonUnwrapped
	private final TeamSeasonIds teamSeasonIds;
	@JsonUnwrapped
	private final Goals goals;
	@JsonProperty("round")
	private final String round;
	@JsonProperty("schedule_date")
	private final String scheduled;// Format: yyyy-MM-ddTHH:mm:ss.SSSZ
	@JsonProperty("stadium")
	private final String stadium;
	@JsonUnwrapped
	private final TeamSeasonNames teamSeasonNames;
	@JsonUnwrapped
	private Referee referee;
	@JsonProperty("lineup_confirmed")
	private final String lineupConfirmed;
	@JsonProperty("elapsed")
	private final Integer elapsed;
	@JsonProperty("game_started_at")
	private String gameStarted;
	@JsonProperty("first_half_ended_at")
	private String firstHalfEnded;
	@JsonProperty("second_half_started_at")
	private String secondHalfStarted;

	public Inplay(JsonObject jsonObject) {
		super(jsonObject);
		this.countryId = CountryId.of(jsonObject.getLong("id_country"));
		this.leagueId = LeagueId.of(jsonObject.getLong("id_league"));
		this.seasonId = SeasonId.of(jsonObject.getLong("id_season"));
		this.stageId = StageId.of(jsonObject.getLong("id_stage"));
		this.fixtureStatus = FixtureStatus.of(jsonObject.getString("fixture_status"),
				jsonObject.getString("fixture_status_short"));
		this.teamSeasonIds = TeamSeasonIds.of(jsonObject.getLong("team_season_id_home"),
				jsonObject.getLong("team_season_id_away"));
		this.goals = Goals.of(jsonObject.getInteger("number_goal_team_home"),
				jsonObject.getInteger("number_goal_team_away"));
		this.round = jsonObject.getString("round");
		this.scheduled = jsonObject.getString("schedule_date");
		this.stadium = jsonObject.getString("stadium");
		this.teamSeasonNames = TeamSeasonNames.of(jsonObject.getString("team_season_home_name"),
				jsonObject.getString("team_season_away_name"));
		this.lineupConfirmed = jsonObject.getString("lineup_confirmed");
		this.elapsed = jsonObject.getInteger("elapsed");
	}

	private Inplay(Builder builder) {
		super(builder.id);
		this.countryId = builder.countryId;
		this.leagueId = builder.leagueId;
		this.seasonId = builder.seasonId;
		this.stageId = builder.stageId;
		this.fixtureStatus = builder.fixtureStatus;
		this.teamSeasonIds = builder.teamSeasonIds;
		this.goals = builder.goals;
		this.round = builder.round;
		this.scheduled = builder.scheduled;
		this.stadium = builder.stadium;
		this.referee = builder.referee;
		this.teamSeasonNames = builder.teamSeasonNames;
		this.lineupConfirmed = builder.lineupConfirmed;
		this.elapsed = builder.elapsed;
		this.gameStarted = builder.gameStarted;
		this.firstHalfEnded = builder.firstHalfEnded;
		this.secondHalfStarted = builder.secondHalfStarted;
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

	public FixtureStatus getFixtureStatus() {
		return this.fixtureStatus;
	}

	public TeamSeasonIds getTeamSeasonIds() {
		return this.teamSeasonIds;
	}

	public Goals getGoals() {
		return this.goals;
	}

	public String getRound() {
		return this.round;
	}

	public String getScheduled() {
		return this.scheduled;
	}

	public String getStadium() {
		return this.stadium;
	}

	public TeamSeasonNames getTeamSeasonNames() {
		return this.teamSeasonNames;
	}

	public Referee getReferee() {
		return this.referee;
	}

	public String getLineupConfirmed() {
		return this.lineupConfirmed;
	}

	public Integer getElapsed() {
		return this.elapsed;
	}

	public String getGameStarted() {
		return this.gameStarted;
	}

	public String getFirstHalfEnded() {
		return this.firstHalfEnded;
	}

	@JsonPOJOBuilder(withPrefix = "")
	public static class Builder {

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
		private FixtureStatus fixtureStatus;
		@JsonUnwrapped
		private TeamSeasonIds teamSeasonIds;
		@JsonUnwrapped
		private Goals goals;
		@JsonProperty("round")
		private String round;
		@JsonProperty("schedule_date")
		private String scheduled;// Format: yyyy-MM-ddTHH:mm:ss.SSSZ
		@JsonProperty("stadium")
		private String stadium;
		@JsonUnwrapped
		private TeamSeasonNames teamSeasonNames;
		@JsonUnwrapped
		private Referee referee;
		@JsonProperty("lineup_confirmed")
		private String lineupConfirmed;
		@JsonProperty("elapsed")
		private Integer elapsed;
		@JsonProperty("game_started_at")
		private String gameStarted;
		@JsonProperty("first_half_ended_at")
		private String firstHalfEnded;
		@JsonProperty("second_half_started_at")
		private String secondHalfStarted;

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

		public Builder scheduled(String scheduled) {
			this.scheduled = scheduled;
			return this;
		}

		public Builder gameStarted(String gameStarted) {
			this.gameStarted = gameStarted;
			return this;
		}

		public Builder firstHalfEnded(String firstHalfEnded) {
			this.firstHalfEnded = firstHalfEnded;
			return this;
		}

		public Builder secondHalfStarted(String secondHalfStarted) {
			this.secondHalfStarted = secondHalfStarted;
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

		public Builder stadium(String stadium) {
			this.stadium = stadium;
			return this;
		}

		public Builder elapsed(Integer elapsed) {
			this.elapsed = elapsed;
			return this;
		}

		public Inplay build() {
			return new Inplay(this);
		}
	}

}
