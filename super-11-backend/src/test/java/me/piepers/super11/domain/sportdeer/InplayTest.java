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

	private void assertExpectedDefaultInplay(Inplay inplay) {
		assertThat(inplay.getId(), is(equalTo(61946L)));
		// assertThat(inplay.)

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
