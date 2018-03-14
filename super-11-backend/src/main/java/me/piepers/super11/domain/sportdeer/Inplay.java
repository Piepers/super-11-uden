package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * Represents all the live matches that are currently active (may return an
 * empty result).
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class Inplay extends SportdeerDomainObject {

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

	public Inplay(JsonObject jsonObject) {
		super(jsonObject);
		// TODO Auto-generated constructor stub
	}

}
