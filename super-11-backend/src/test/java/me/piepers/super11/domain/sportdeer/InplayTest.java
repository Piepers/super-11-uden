package me.piepers.super11.domain.sportdeer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class InplayTest {

	@Test
	public void test_that_example_json_payload_is_mapped_as_expected() throws Exception {
		Docs<Inplay> docs = SportdeerMapper.from(this.createDefaultExampleResponse(), Inplay.class);
		assertNotNull(docs);
		List<Inplay> inplays = docs.getData();
		assertThat(inplays, hasSize(1));
		assertThat(inplays, notNullValue());
		// Expect pagination
		assertThat(docs.getPagination(), notNullValue());
		Inplay inplay = inplays.get(0);
		assertNotNull(inplay);
		this.assertExpectedDefaultInplay(inplay);
	}

	private String createExpectedInplayCreatedJsonStringFromDefault() {
		return String.format(
				"{\"_id\":%d,\"id_country\":%d,\"id_league\":%d," + "\"id_season\":%d,\"id_stage\":%d,"
						+ "\"fixture_status\":\"%s\"," + "\"fixture_status_short\":\"%s\","
						+ "\"id_team_season_away\":%d,\"id_team_season_home\":%d,"
						+ "\"number_goal_team_away\":%d,\"number_goal_team_home\":%d," + "\"round\":\"%s\","
						+ "\"schedule_date\":\"%s\"," + "\"stadium\":\"%s\"," + "\"team_season_away_name\":\"%s\","
						+ "\"team_season_home_name\":\"%s\"," + "\"lineup_confirmed\":\"%s\",\"elapsed\":%d,"
						+ "\"game_started_at\":\"%s\"," + "\"first_half_ended_at\":\"%s\","
						+ "\"second_half_started_at\":\"%s\"}",
				1L, 10L, 100L, 201L, 301L, "2nd Half", "2HF", 4L, 40L, 1, 2, "89", "2018-03-19T18:15:00.000Z",
				"Amsterdam Arena", "Top Oss", "Helmond Sport", "Yes", 10, "2018-03-19T18:15:00.000Z",
				"2018-03-19T19:00:00.000Z", "2018-03-19T19:15.000Z");
	}

	private String createExpectedDocsCreatedJsonStringFromDefault() {
		return String.format("{\"docs\":[{\r\n\"_id\": %d,\r\n\"id_country\": %d,\r\n\"id_league\": 98,\r\n"
				+ "\"id_season\": %d,\r\n\"id_stage\": 570,\r\n" + "\"fixture_status\": \"%s\",\r\n"
				+ "\"fixture_status_short\": \"%s\",\r\n"
				+ "\"id_team_season_away\": %d,\r\n\"id_team_season_home\": %d,\r\n"
				+ "\"number_goal_team_away\": %d,\r\n\"number_goal_team_home\": %d,\r\n" + "\"round\": \"%s\",\r\n"
				+ "\"schedule_date\": \"%s\",\r\n" + "\"stadium\": \"%s\",\r\n"
				+ "\"team_season_away_name\": \"%s\",\r\n" + "\"team_season_home_name\": \"%s\",\r\n"
				+ "\"lineup_confirmed\": \"%s\",\r\n\"elapsed\": %d,\r\n" + "\"game_started_at\": \"%s\",\r\n"
				+ "\"first_half_ended_at\": \"%s\",\r\n" + "\"second_half_started_at\": \"%s\"\r\n}\r\n" + "    ],\r\n"
				+ "    \"pagination\": {\r\n" + "        \"total\": %d,\r\n" + "        \"limit\": %d,\r\n"
				+ "        \"page\": %d,\r\n" + "        \"pages\": %d\r\n" + "    }\r\n" + "}", 1L, 10L, 100L, 201L,
				301L, "2nd Half", "2HF", 40L, 4L, 1, 2, "89", "2018-03-19T18:15:00.000Z", "Amsterdam Arena", "Top Oss",
				"Helmond Sport", "Yes", 10, "2018-03-19T18:15:00.000Z", "2018-03-19T19:00:00.000Z",
				"2018-03-19T19:15.000Z", 1, 30, 1, 1);
	}

	private void assertExpectedDefaultInplay(Inplay inplay) {
		assertThat(inplay.getId(), is(equalTo(61946L)));
		assertThat(inplay.getCountryId(), is(equalTo(CountryId.of(86L))));
		assertThat(inplay.getLeagueId(), is(equalTo(LeagueId.of(98L))));
		assertThat(inplay.getSeasonId(), is(equalTo(SeasonId.of(198L))));
		assertThat(inplay.getStageId(), is(equalTo(StageId.of(570L))));
		assertThat(inplay.getFixtureStatus().getFixtureStatus(), is("2nd half"));
		assertThat(inplay.getFixtureStatus().getFixtureStatusShort(), is("2H"));
		assertThat(inplay.getTeamSeasonIds().getTeamSeasonIdHme(), is(equalTo(11486L)));
		assertThat(inplay.getTeamSeasonIds().getTeamSeasonIdAwy(), is(equalTo(11496L)));
		assertThat(inplay.getGoals(), is(equalTo(Goals.of(1, 0))));
		assertThat(inplay.getRound(), is(equalTo("31")));
		assertThat(inplay.getScheduled(), is("2018-03-19T19:30:00.000Z"));
		assertThat(inplay.getStadium(), is("Stadio Sandro Cabassi"));
		assertThat(inplay.getTeamSeasonNames(), is(equalTo(TeamSeasonNames.of("Carpi", "Pro Vercelli"))));
		assertThat(inplay.getLineupConfirmed(), is("yes"));
		assertThat(inplay.getElapsed(), is(54));
		assertThat(inplay.getGameStarted(), is("2018-03-19T19:30:56.000Z"));
		assertThat(inplay.getFirstHalfEnded(), is("2018-03-19T20:17:05.000Z"));
		assertThat(inplay.getSecondHalfStarted(), is("2018-03-19T20:33:24.000Z"));
	}

	private Inplay createDefaultValidInplay() {
		return new Inplay.Builder(1L).countryId(CountryId.of(10L)).elapsed(10)
				.firstHalfEnded("2018-03-19T19:00:00.000Z").fixtureStatus(FixtureStatus.of("2nd Half", "2HF"))
				.gameStarted("2018-03-19T18:15:00.000Z").goals(Goals.of(1, 2)).leagueId(LeagueId.of(100L))
				.lineupConfirmed("Yes").referee(Referee.of(RefereeId.of(23L), "Klaas Vaak")).round("89")
				.scheduled("2018-03-19T18:15:00.000Z").seasonId(SeasonId.of(201L))
				.secondHalfStarted("2018-03-19T19:15.000Z").stadium("Amsterdam Arena").stageId(StageId.of(301L))
				.teamSeasonIds(TeamSeasonIds.of(4L, 40L))
				.teamSeasonNames(TeamSeasonNames.of("Helmond Sport", "TOP Oss")).build();
	}

	private String createDefaultExampleResponse() {
		return "{\r\n" + "    \"docs\": [\r\n" + "        {\r\n" + "            \"_id\": 61946,\r\n"
				+ "            \"id_country\": 86,\r\n" + "            \"id_league\": 98,\r\n"
				+ "            \"id_season\": 198,\r\n" + "            \"id_stage\": 570,\r\n"
				+ "            \"fixture_status\": \"2nd half\",\r\n"
				+ "            \"fixture_status_short\": \"2H\",\r\n"
				+ "            \"id_team_season_away\": 11496,\r\n" + "            \"id_team_season_home\": 11486,\r\n"
				+ "            \"number_goal_team_away\": 0,\r\n" + "            \"number_goal_team_home\": 1,\r\n"
				+ "            \"round\": \"31\",\r\n"
				+ "            \"schedule_date\": \"2018-03-19T19:30:00.000Z\",\r\n"
				+ "            \"stadium\": \"Stadio Sandro Cabassi\",\r\n"
				+ "            \"team_season_away_name\": \"Pro Vercelli\",\r\n"
				+ "            \"team_season_home_name\": \"Carpi\",\r\n"
				+ "            \"lineup_confirmed\": \"yes\",\r\n" + "            \"elapsed\": 54,\r\n"
				+ "            \"game_started_at\": \"2018-03-19T19:30:56.000Z\",\r\n"
				+ "            \"first_half_ended_at\": \"2018-03-19T20:17:05.000Z\",\r\n"
				+ "            \"second_half_started_at\": \"2018-03-19T20:33:24.000Z\"\r\n" + "        }\r\n"
				+ "    ],\r\n" + "    \"pagination\": {\r\n" + "        \"total\": 1,\r\n"
				+ "        \"limit\": 30,\r\n" + "        \"page\": 1,\r\n" + "        \"pages\": 1\r\n" + "    }\r\n"
				+ "}";
	}
}
