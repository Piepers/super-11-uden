package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import me.piepers.super11.domain.JsonDomainObject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Compound object that is generated based on a composite statement to the SportDeer API in this case all the
 * line-ups and events for fixtures of a particular season. Typically, a Season id is bound to a particular league
 * e.g. Season Id 287 (2017/1028) should reflect the fixtures of league 144 (Eredivisie).
 * <p>
 * It does not extend {@link SportdeerDomainObject} because it is a wrapper that contains a Fixture (which extends
 * SportDeerDomainObject).
 *
 * @author Bas Piepers
 */
@DataObject
public class FixtureEventsLineUps implements JsonDomainObject {

    @JsonUnwrapped
    private Fixture fixture;
    @JsonProperty("events")
    private List<Event> events;
    @JsonProperty("lineups")
    private List<LineUp> lineUps;

    public FixtureEventsLineUps(JsonObject jsonObject) {
        this.fixture = new Fixture.Builder(jsonObject.getLong("_id"))
                .countryId(CountryId.of(jsonObject.getLong("id_country")))
                .seasonId(SeasonId.of(jsonObject.getLong("id_season")))
                .stageId(StageId.of(jsonObject.getLong("id_stage")))
                .gameTimings(GameTimings.of(jsonObject.getString("game_started_at"),
                        jsonObject.getString("game_ended_at"),
                        jsonObject.getString("first_half_ended_at"),
                        jsonObject.getString("second_half_started_at"),
                        jsonObject.getString("second_half_ended_at")))
                .fixtureStatus(FixtureStatus.of(jsonObject.getString("fixture_status"), jsonObject.getString("fixture_status_short")))
                .referee(Referee.of(RefereeId.of(jsonObject.getLong("id_referee")),
                        jsonObject.getString("referee_name")))
                .teamSeasonIds(TeamSeasonIds.of(jsonObject.getLong("id_team_season_home"), jsonObject.getLong("id_team_season_away")))
                .lineupConfirmed(jsonObject.getString("lineup_confirmed"))
                .goals(Goals.of(jsonObject.getInteger("number_goal_team_home"), jsonObject.getInteger("number_goal_team_away")))
                .round(jsonObject.getString("round"))
                .scheduled(jsonObject.getString("schedule_date"))
                .spectators(jsonObject.getInteger("spectators"))
                .stadium(jsonObject.getString("stadium"))
                .teamSeasonNames(TeamSeasonNames.of(jsonObject.getString("team_season_home_name"), jsonObject.getString("team_season_away_name")))
                .build();
        this.events = jsonObject.getJsonArray("events").stream().map(event -> new Event((JsonObject) event)).collect(Collectors.toList());
        this.lineUps = jsonObject.getJsonArray("lineups").stream().map(lineUp -> new LineUp((JsonObject) lineUp)).collect(Collectors.toList());
    }

    // The fixture should be set by Jackson because of the property on the field.
    @JsonCreator
    public FixtureEventsLineUps(@JsonProperty("events") List<Event> events, @JsonProperty("lineups") List<LineUp> lineUps) {
        this.events = events;
        this.lineUps = lineUps;
    }

    public Fixture getFixture() {
        return fixture;
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<LineUp> getLineUps() {
        return lineUps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FixtureEventsLineUps that = (FixtureEventsLineUps) o;

        if (!fixture.equals(that.fixture)) return false;
        if (events != null ? !events.equals(that.events) : that.events != null) return false;
        return lineUps != null ? lineUps.equals(that.lineUps) : that.lineUps == null;
    }

    @Override
    public int hashCode() {
        int result = fixture.hashCode();
        result = 31 * result + (events != null ? events.hashCode() : 0);
        result = 31 * result + (lineUps != null ? lineUps.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FixtureEventsLineUps{" +
                "fixture=" + fixture +
                ", events=" + events +
                ", lineUps=" + lineUps +
                '}';
    }
}
