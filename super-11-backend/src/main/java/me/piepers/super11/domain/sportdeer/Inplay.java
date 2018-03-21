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
