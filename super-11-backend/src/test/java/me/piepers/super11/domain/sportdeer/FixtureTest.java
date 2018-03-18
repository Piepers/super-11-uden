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

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(JUnit4.class)
public class FixtureTest {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Test
	public void test_example_mapping_document() throws Exception {
		String exampleResponse = "{\r\n" + "    \"docs\": [\r\n" + "        {\r\n" + "            \"_id\": 1,\r\n"
				+ "            \"id_country\": 46,\r\n" + "            \"id_league\": 8,\r\n"
				+ "            \"id_season\": 2,\r\n" + "            \"id_stage\": 1,\r\n"
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
				+ "            \"team_season_home_name\": \"Watford\"\r\n" + "        }\r\n" + "    ]\r\n" + "}";

		JavaType type = this.objectMapper.getTypeFactory().constructParametricType(Docs.class, Fixture.class);
		// We always work with a list of "data" because that's how the API communicates.
		Docs<Fixture> docs = this.objectMapper.readValue(exampleResponse, type);
		assertNotNull(docs);
		List<Fixture> fixtures = docs.getData();
		assertThat(fixtures, hasSize(1));
		assertThat(fixtures, notNullValue());
		// Expect no pagination
		assertThat(docs.getPagination(), is(nullValue()));
		Fixture fixture = fixtures.get(0);
		assertNotNull(fixture);
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

	// Although it's a read only interface, check if serializing back to a Json
	// string is also working (since that is what's going over the Vertx event bus.
	@Test
	public void test_example_mapping_object_to_json() throws Exception {
		Fixture fixture = new Fixture.Builder(1L).countryId(CountryId.of(11L)).leagueId(LeagueId.of(2L))
				.seasonId(SeasonId.of(3L)).stageId(StageId.of(4L))
				.gameTimings(GameTimings.of("2018-03-18T13:00:00.000Z", "2018-03-18T14:35:00.000Z",
						"2018-03-18T13:45:00.000Z", "2018-03-18T13:50:00.000Z", "2018-03-18T14:35:00.000Z"))
				.goals(Goals.of(1, 2)).lineupConfirmed("yes").referee(Referee.of(RefereeId.of(1L), "John Doe"))
				.round(100).scheduled("2018-03-18T13:00:00.000Z").spectators(100000).stadium("Stadium Of Dreams")
				.stageId(StageId.of(5L)).teamSeasonIds(TeamSeasonIds.of(20L, 30L))
				.teamSeasonNames(TeamSeasonNames.of("Ajax", "PSV")).build();
		Docs<Fixture> docs = new Docs<>(Arrays.asList(fixture), null);

		String json = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(docs);
		String fixtureJson = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fixture);
		System.out.println(json);
		System.out.println(fixtureJson);
		// Docs<Fixture> docs = new Docs<>(Arrays.asList(Fixture), pagination)
	}
}
