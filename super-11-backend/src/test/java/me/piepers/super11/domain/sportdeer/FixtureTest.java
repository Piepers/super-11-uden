package me.piepers.super11.domain.sportdeer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

@RunWith(JUnit4.class)
public class FixtureTest {

	@Test
	public void test_example_mapping_document() throws Exception {
		String exampleResponse = this.createDefaultDocsExampleResponse();

		// We always work with a "docs" object because that's how the API communicates.
		Docs<Fixture> docs = SportdeerMapper.from(exampleResponse, Fixture.class);
		assertNotNull(docs);
		List<Fixture> fixtures = docs.getData();
		assertThat(fixtures, hasSize(1));
		assertThat(fixtures, notNullValue());
		// Expect no pagination
		assertThat(docs.getPagination(), is(nullValue()));
		Fixture fixture = fixtures.get(0);
		assertNotNull(fixture);
		this.assertExpectedDefaultFixture(fixture);
	}

	// Although it's a read only interface, check if serializing back to a Json
	// string is also working (since that is what's going over the Vertx event bus.
	@Test
	public void test_example_mapping_object_to_json() throws Exception {
		Docs<Fixture> docs = new Docs<>(Arrays.asList(this.createDefaultValidFixture()), null);
		String json = SportdeerMapper.to(docs);
		// Expecting the generated json to look like the document we are creating
		// underneath
		String expected = this.createExpectedDocsCreatedJsonStringFromDefault();
		assertThat(json, is(equalTo(expected)));
	}

	// Test if the object mappping serialization and de-serialization also works as
	// expected.
	@Test
	public void test_data_object_mapping() {
		Fixture fixture = this.createDefaultValidFixture();
		JsonObject jsonObject = new JsonObject(Json.encode(fixture));
		String expected = this.createExpectedFixtureCreatedJsonStringFromDefault();
		assertThat(expected, is(equalTo(jsonObject.toString())));
	}

	// Test if an incoming string is mapped as expected. Only the fixture itself
	// will be mapped, not "docs".
	@Test
	public void test_data_mapping_to_object() {
		String exampleResponse = this.createDefaultExampleResponse();
		JsonObject jsonObject = new JsonObject(exampleResponse);
		Fixture fixture = new Fixture(jsonObject);
		this.assertExpectedDefaultFixture(fixture);

	}

	private void assertExpectedDefaultFixture(Fixture fixture) {
		assertThat(fixture.getCountryId(), is(equalTo(CountryId.of(46L))));
		assertThat(fixture.getLeagueId(), is(equalTo(LeagueId.of(8L))));
		assertThat(fixture.getSeasonId(), is(equalTo(SeasonId.of(2L))));
		assertThat(fixture.getStageId(), is(equalTo(StageId.of(1L))));
		assertThat(fixture.getGameTimings(), is(not(nullValue())));
		assertThat(fixture.getGameTimings().getFirstHalfEnd(), is(equalTo("2018-02-05T20:48:14.000Z")));
		assertThat(fixture.getGameTimings().getGameEnd(), is(equalTo("2018-02-05T21:54:45.000Z")));
		assertThat(fixture.getGameTimings().getGameStart(), is(equalTo("2018-02-05T20:01:00.000Z")));
		assertThat(fixture.getGameTimings().getSecondHalfStart(), is(equalTo("2018-02-05T21:03:07.000Z")));
		assertThat(fixture.getGameTimings().getSecondHalfEnd(), is(equalTo("2018-02-05T22:54:45.000Z")));
		assertThat(fixture.getFixtureStatus(), is(not(nullValue())));
		assertThat(fixture.getFixtureStatus().getFixtureStatus(), is(equalTo("Finished")));
		assertThat(fixture.getFixtureStatus().getFixtureStatusShort(), is(equalTo("FIN")));
		assertThat(fixture.getReferee(), is(not(nullValue())));
		assertThat(fixture.getReferee().getId(), is(equalTo(RefereeId.of(4L))));
		assertThat(fixture.getReferee().getName(), is(equalTo("Mike Dean")));
		assertThat(fixture.getTeamSeasonIds(), is(not(nullValue())));
		assertThat(fixture.getTeamSeasonIds().getTeamSeasonIdHme(), is(equalTo(7L)));
		assertThat(fixture.getTeamSeasonIds().getTeamSeasonIdAwy(), is(equalTo(8L)));
		assertThat(fixture.getLineUpConfirmed(), is(equalTo("yes")));
		assertThat(fixture.getGoals(), is(not(nullValue())));
		assertThat(fixture.getGoals().getGoalsHme(), is(4));
		assertThat(fixture.getGoals().getGoalsAwy(), is(1));
		assertThat(fixture.getStadium(), is("Vicarage Road Stadium"));
		assertThat(fixture.getSpectators(), is(20157));
		assertThat(fixture.getTeamSeasonNames(), is(not(nullValue())));
		assertThat(fixture.getTeamSeasonNames().getTeamSeasonHme(), is("Watford"));
		assertThat(fixture.getTeamSeasonNames().getTeamSeasonAwy(), is("Chelsea"));
	}

	// An example response as it will arrive from the API (so with the "docs"
	// attribute).
	private String createDefaultDocsExampleResponse() {
		return "{\r\n" + "    \"docs\": [\r\n" + this.createDefaultExampleResponse() + "\r\n" + "    ]\r\n" + "}";
	}

	// An example body response as it is passed around internally (so only the body
	// of the docs element).
	private String createDefaultExampleResponse() {
		return "{\r\n" + "            \"_id\": 1,\r\n" + "            \"id_country\": 46,\r\n"
				+ "            \"id_league\": 8,\r\n" + "            \"id_season\": 2,\r\n"
				+ "            \"id_stage\": 1,\r\n"
				+ "            \"first_half_ended_at\": \"2018-02-05T20:48:14.000Z\",\r\n"
				+ "            \"fixture_status\": \"Finished\",\r\n"
				+ "            \"fixture_status_short\": \"FIN\",\r\n"
				+ "            \"game_ended_at\": \"2018-02-05T21:54:45.000Z\",\r\n"
				+ "            \"game_started_at\": \"2018-02-05T20:01:00.000Z\",\r\n"
				+ "            \"id_referee\": 4,\r\n" + "            \"id_team_season_away\": 8,\r\n"
				+ "            \"id_team_season_home\": 7,\r\n" + "            \"lineup_confirmed\": \"yes\",\r\n"
				+ "            \"number_goal_team_away\": 1,\r\n" + "            \"number_goal_team_home\": 4,\r\n"
				+ "            \"referee_name\": \"Mike Dean\",\r\n" + "            \"round\": \"26\",\r\n"
				+ "            \"schedule_date\": \"2018-02-05T20:00:00.000Z\",\r\n"
				+ "            \"second_half_ended_at\": \"2018-02-05T22:54:45.000Z\",\r\n"
				+ "            \"second_half_started_at\": \"2018-02-05T21:03:07.000Z\",\r\n"
				+ "            \"spectators\": 20157,\r\n" + "            \"stadium\": \"Vicarage Road Stadium\",\r\n"
				+ "            \"team_season_away_name\": \"Chelsea\",\r\n"
				+ "            \"team_season_home_name\": \"Watford\"\r\n" + "}";
	}

	private Fixture createDefaultValidFixture() {
		return new Fixture.Builder(1L).countryId(CountryId.of(11L)).leagueId(LeagueId.of(2L)).seasonId(SeasonId.of(3L))
				.stageId(StageId.of(4L))
				.gameTimings(GameTimings.of("2018-03-18T13:00:00.000Z", "2018-03-18T14:35:00.000Z",
						"2018-03-18T13:45:00.000Z", "2018-03-18T13:50:00.000Z", "2018-03-18T14:35:00.000Z"))
				.goals(Goals.of(1, 2)).lineupConfirmed("yes").referee(Referee.of(RefereeId.of(1L), "John Doe"))
				.round("100").scheduled("2018-03-18T13:00:00.000Z").spectators(100000).stadium("Stadium Of Dreams")
				.stageId(StageId.of(5L)).teamSeasonIds(TeamSeasonIds.of(20L, 30L))
				.teamSeasonNames(TeamSeasonNames.of("Ajax", "PSV")).build();
	}

	private String createExpectedFixtureCreatedJsonStringFromDefault() {
		return String.format(
				"{\"_id\":%d,\"id_country\":%d,\"id_league\":%d,\"id_season\":%d,\"id_stage\":%d,\"game_started_at\":\"%s\",\"game_ended_at\":\"%s\",\"first_half_ended_at\":\"%s\",\"second_half_started_at\":\"%s\",\"second_half_ended_at\":\"%s\",\"referee_name\":\"%s\",\"id_referee\":%d,\"id_team_season_home\":%d,\"id_team_season_away\":%d,\"team_season_home_name\":\"%s\",\"team_season_away_name\":\"%s\",\"number_goal_team_home\":%d,\"number_goal_team_away\":%d,\"lineup_confirmed\":\"%s\",\"round\":\"%s\",\"schedule_date\":\"%s\",\"spectators\":%d,\"stadium\":\"%s\"}",
				1, 11, 2, 3, 5, "2018-03-18T13:00:00.000Z", "2018-03-18T14:35:00.000Z", "2018-03-18T13:45:00.000Z",
				"2018-03-18T13:50:00.000Z", "2018-03-18T14:35:00.000Z", "John Doe", 1, 20, 30, "Ajax", "PSV", 1, 2,
				"yes", "100", "2018-03-18T13:00:00.000Z", 100000, "Stadium Of Dreams");
	}

	private String createExpectedDocsCreatedJsonStringFromDefault() {
		return String.format(
				"{\"docs\":[{\"_id\":%d,\"id_country\":%d,\"id_league\":%d,\"id_season\":%d,\"id_stage\":%d,\"game_started_at\":\"%s\",\"game_ended_at\":\"%s\",\"first_half_ended_at\":\"%s\",\"second_half_started_at\":\"%s\",\"second_half_ended_at\":\"%s\",\"referee_name\":\"%s\",\"id_referee\":%d,\"id_team_season_home\":%d,\"id_team_season_away\":%d,\"team_season_home_name\":\"%s\",\"team_season_away_name\":\"%s\",\"number_goal_team_home\":%d,\"number_goal_team_away\":%d,\"lineup_confirmed\":\"%s\",\"round\":\"%s\",\"schedule_date\":\"%s\",\"spectators\":%d,\"stadium\":\"%s\"}]}",
				1, 11, 2, 3, 5, "2018-03-18T13:00:00.000Z", "2018-03-18T14:35:00.000Z", "2018-03-18T13:45:00.000Z",
				"2018-03-18T13:50:00.000Z", "2018-03-18T14:35:00.000Z", "John Doe", 1, 20, 30, "Ajax", "PSV", 1, 2,
				"yes", "100", "2018-03-18T13:00:00.000Z", 100000, "Stadium Of Dreams");
	}
}
