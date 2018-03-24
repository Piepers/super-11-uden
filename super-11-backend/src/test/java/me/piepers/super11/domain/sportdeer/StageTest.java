package me.piepers.super11.domain.sportdeer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import io.vertx.core.json.JsonObject;

@RunWith(JUnit4.class)
public class StageTest {

	@Test
	public void test_that_mapping_from_json_to_object_generates_expected_value() throws Exception {
		Docs<Stage> stages = SportdeerMapper.from(this.generateExampleResponse(), Stage.class);
		assertNotNull(stages);
		assertNotNull(stages.getData());
		List<Stage> items = stages.getData();
		assertThat(items.size(), is(1));
		Stage stage = items.get(0);
		this.assertDefaultExampleStage(stage);
	}

	@Test
	public void test_that_mapping_from_json_object_generates_expected_result() {
		String exampleResponse = this.generateDefaultExampleStage();
		JsonObject jsonObject = new JsonObject(exampleResponse);
		Stage stage = new Stage(jsonObject);
		this.assertDefaultExampleStage(stage);
	}

	private void assertDefaultExampleStage(Stage stage) {
		assertNotNull(stage.getStanding());
		List<StandingItem> standings = stage.getStanding();
		assertNotNull(standings);
		assertThat(standings.size(), is(18));
		// Just pick a few to test their contents.
		StandingItem si1 = standings.stream().filter(s -> s.getId().equals("5aa6e7825b86c53ffd2cbc11")).findFirst()
				.get();
		assertThat(si1.getTeamSeasonId(), is(equalTo(800L)));
		assertThat(si1.getTeamSeasonName(), is(equalTo("1860 Muenchen")));
		assertThat(si1.getPlayed(), is(34));
		assertThat(si1.getWinsHome(), is(5));
		assertThat(si1.getDrawsHome(), is(4));
		assertThat(si1.getLossesHome(), is(8));
		assertThat(si1.getWinsAway(), is(3));
		assertThat(si1.getDrawsAway(), is(4));
		assertThat(si1.getLossesAway(), is(10));
		assertThat(si1.getGoalsScoredHome(), is(16));
		assertThat(si1.getGoalsAwayHome(), is(25));
		assertThat(si1.getGoalsScoredAway(), is(16));
		assertThat(si1.getGoalsAwayAway(), is(30));
		assertThat(si1.getPoints(), is(32));
		assertThat(si1.getWinsTotal(), is(8));
		assertThat(si1.getDrawsTotal(), is(8));
		assertThat(si1.getLossesTotal(), is(18));
		assertThat(si1.getGoalsTotal(), is(32));
		assertThat(si1.getGoalsAwayTotal(), is(55));
		assertThat(si1.getGoalDifferenceHome(), is(-9));
		assertThat(si1.getGoalDifferenceAway(), is(-14));
		assertThat(si1.getGoalDifferenceTotal(), is(-23));
		assertThat(si1.getPosition(), is(17));

		StandingItem si2 = standings.stream().filter(s -> s.getId().equals("5aa6e7825b86c53ffd2cbc0c")).findFirst()
				.get();
		assertThat(si2.getTeamSeasonId(), is(equalTo(798L)));
		assertThat(si2.getTeamSeasonName(), is(equalTo("Schalke 04")));
		assertThat(si2.getPlayed(), is(34));
		assertThat(si2.getWinsHome(), is(7));
		assertThat(si2.getDrawsHome(), is(7));
		assertThat(si2.getLossesHome(), is(3));
		assertThat(si2.getWinsAway(), is(6));
		assertThat(si2.getDrawsAway(), is(4));
		assertThat(si2.getLossesAway(), is(7));
		assertThat(si2.getGoalsScoredHome(), is(28));
		assertThat(si2.getGoalsAwayHome(), is(16));
		assertThat(si2.getGoalsScoredAway(), is(21));
		assertThat(si2.getGoalsAwayAway(), is(26));
		assertThat(si2.getPoints(), is(50));
		assertThat(si2.getWinsTotal(), is(13));
		assertThat(si2.getDrawsTotal(), is(11));
		assertThat(si2.getLossesTotal(), is(10));
		assertThat(si2.getGoalsTotal(), is(49));
		assertThat(si2.getGoalsAwayTotal(), is(42));
		assertThat(si2.getGoalDifferenceHome(), is(12));
		assertThat(si2.getGoalDifferenceAway(), is(-5));
		assertThat(si2.getGoalDifferenceTotal(), is(7));
		assertThat(si2.getPosition(), is(7));
	}

	// An example response as it comes from the Sportdeer API (so with the "docs"
	// tags)
	private String generateExampleResponse() {
		return "{\r\n" + "    \"docs\": [\r\n" + this.generateDefaultExampleStage() + "        \r\n" + "    ]\r\n"
				+ "}";
	}

	private String generateDefaultExampleStage() {
		return "{\r\n" + "            \"_id\": 39,\r\n" + "            \"name\": \"1. Bundesliga\",\r\n"
				+ "            \"id_country\": 59,\r\n" + "            \"id_league\": 108,\r\n"
				+ "            \"id_season\": 42,\r\n" + "            \"sort_strategy\": [\r\n"
				+ "                0,\r\n" + "                1,\r\n" + "                2,\r\n"
				+ "                3,\r\n" + "                4,\r\n" + "                99\r\n" + "            ],\r\n"
				+ "            \"standing\": [\r\n" + "                {\r\n"
				+ "                    \"_id\": \"5aa6e7825b86c53ffd2cbc18\",\r\n"
				+ "                    \"id_team_season\": 806,\r\n"
				+ "                    \"team_season_name\": \"Werder Bremen\",\r\n"
				+ "                    \"p\": 34,\r\n" + "                    \"w_home\": 11,\r\n"
				+ "                    \"d_home\": 4,\r\n" + "                    \"l_home\": 2,\r\n"
				+ "                    \"w_away\": 11,\r\n" + "                    \"d_away\": 4,\r\n"
				+ "                    \"l_away\": 2,\r\n" + "                    \"gf_home\": 42,\r\n"
				+ "                    \"ga_home\": 21,\r\n" + "                    \"gf_away\": 37,\r\n"
				+ "                    \"ga_away\": 17,\r\n" + "                    \"pts\": 74,\r\n"
				+ "                    \"w_tot\": 22,\r\n" + "                    \"d_tot\": 8,\r\n"
				+ "                    \"l_tot\": 4,\r\n" + "                    \"gf_tot\": 79,\r\n"
				+ "                    \"ga_tot\": 38,\r\n" + "                    \"gd_home\": 21,\r\n"
				+ "                    \"gd_away\": 20,\r\n" + "                    \"gd_tot\": 41,\r\n"
				+ "                    \"position\": 1\r\n" + "                },\r\n" + "                {\r\n"
				+ "                    \"_id\": \"5aa6e7825b86c53ffd2cbc19\",\r\n"
				+ "                    \"id_team_season\": 795,\r\n"
				+ "                    \"team_season_name\": \"Bayern Munich\",\r\n"
				+ "                    \"p\": 34,\r\n" + "                    \"w_home\": 13,\r\n"
				+ "                    \"d_home\": 3,\r\n" + "                    \"l_home\": 1,\r\n"
				+ "                    \"w_away\": 7,\r\n" + "                    \"d_away\": 5,\r\n"
				+ "                    \"l_away\": 5,\r\n" + "                    \"gf_home\": 43,\r\n"
				+ "                    \"ga_home\": 19,\r\n" + "                    \"gf_away\": 27,\r\n"
				+ "                    \"ga_away\": 20,\r\n" + "                    \"pts\": 68,\r\n"
				+ "                    \"w_tot\": 20,\r\n" + "                    \"d_tot\": 8,\r\n"
				+ "                    \"l_tot\": 6,\r\n" + "                    \"gf_tot\": 70,\r\n"
				+ "                    \"ga_tot\": 39,\r\n" + "                    \"gd_home\": 24,\r\n"
				+ "                    \"gd_away\": 7,\r\n" + "                    \"gd_tot\": 31,\r\n"
				+ "                    \"position\": 2\r\n" + "                },\r\n" + "                {\r\n"
				+ "                    \"_id\": \"5aa6e7825b86c53ffd2cbc0e\",\r\n"
				+ "                    \"id_team_season\": 793,\r\n"
				+ "                    \"team_season_name\": \"Bayer Leverkusen\",\r\n"
				+ "                    \"p\": 34,\r\n" + "                    \"w_home\": 12,\r\n"
				+ "                    \"d_home\": 1,\r\n" + "                    \"l_home\": 4,\r\n"
				+ "                    \"w_away\": 7,\r\n" + "                    \"d_away\": 7,\r\n"
				+ "                    \"l_away\": 3,\r\n" + "                    \"gf_home\": 43,\r\n"
				+ "                    \"ga_home\": 18,\r\n" + "                    \"gf_away\": 30,\r\n"
				+ "                    \"ga_away\": 21,\r\n" + "                    \"pts\": 65,\r\n"
				+ "                    \"w_tot\": 19,\r\n" + "                    \"d_tot\": 8,\r\n"
				+ "                    \"l_tot\": 7,\r\n" + "                    \"gf_tot\": 73,\r\n"
				+ "                    \"ga_tot\": 39,\r\n" + "                    \"gd_home\": 25,\r\n"
				+ "                    \"gd_away\": 9,\r\n" + "                    \"gd_tot\": 34,\r\n"
				+ "                    \"position\": 3\r\n" + "                },\r\n" + "                {\r\n"
				+ "                    \"_id\": \"5aa6e7825b86c53ffd2cbc15\",\r\n"
				+ "                    \"id_team_season\": 794,\r\n"
				+ "                    \"team_season_name\": \"VfB Stuttgart\",\r\n"
				+ "                    \"p\": 34,\r\n" + "                    \"w_home\": 9,\r\n"
				+ "                    \"d_home\": 7,\r\n" + "                    \"l_home\": 1,\r\n"
				+ "                    \"w_away\": 9,\r\n" + "                    \"d_away\": 3,\r\n"
				+ "                    \"l_away\": 5,\r\n" + "                    \"gf_home\": 29,\r\n"
				+ "                    \"ga_home\": 13,\r\n" + "                    \"gf_away\": 23,\r\n"
				+ "                    \"ga_away\": 11,\r\n" + "                    \"pts\": 64,\r\n"
				+ "                    \"w_tot\": 18,\r\n" + "                    \"d_tot\": 10,\r\n"
				+ "                    \"l_tot\": 6,\r\n" + "                    \"gf_tot\": 52,\r\n"
				+ "                    \"ga_tot\": 24,\r\n" + "                    \"gd_home\": 16,\r\n"
				+ "                    \"gd_away\": 12,\r\n" + "                    \"gd_tot\": 28,\r\n"
				+ "                    \"position\": 4\r\n" + "                },\r\n" + "                {\r\n"
				+ "                    \"_id\": \"5aa6e7825b86c53ffd2cbc14\",\r\n"
				+ "                    \"id_team_season\": 791,\r\n"
				+ "                    \"team_season_name\": \"Bochum\",\r\n" + "                    \"p\": 34,\r\n"
				+ "                    \"w_home\": 11,\r\n" + "                    \"d_home\": 5,\r\n"
				+ "                    \"l_home\": 1,\r\n" + "                    \"w_away\": 4,\r\n"
				+ "                    \"d_away\": 6,\r\n" + "                    \"l_away\": 7,\r\n"
				+ "                    \"gf_home\": 30,\r\n" + "                    \"ga_home\": 6,\r\n"
				+ "                    \"gf_away\": 27,\r\n" + "                    \"ga_away\": 33,\r\n"
				+ "                    \"pts\": 56,\r\n" + "                    \"w_tot\": 15,\r\n"
				+ "                    \"d_tot\": 11,\r\n" + "                    \"l_tot\": 8,\r\n"
				+ "                    \"gf_tot\": 57,\r\n" + "                    \"ga_tot\": 39,\r\n"
				+ "                    \"gd_home\": 24,\r\n" + "                    \"gd_away\": -6,\r\n"
				+ "                    \"gd_tot\": 18,\r\n" + "                    \"position\": 5\r\n"
				+ "                },\r\n" + "                {\r\n"
				+ "                    \"_id\": \"5aa6e7825b86c53ffd2cbc0f\",\r\n"
				+ "                    \"id_team_season\": 808,\r\n"
				+ "                    \"team_season_name\": \"Borussia Dortmund\",\r\n"
				+ "                    \"p\": 34,\r\n" + "                    \"w_home\": 12,\r\n"
				+ "                    \"d_home\": 3,\r\n" + "                    \"l_home\": 2,\r\n"
				+ "                    \"w_away\": 4,\r\n" + "                    \"d_away\": 4,\r\n"
				+ "                    \"l_away\": 9,\r\n" + "                    \"gf_home\": 39,\r\n"
				+ "                    \"ga_home\": 16,\r\n" + "                    \"gf_away\": 20,\r\n"
				+ "                    \"ga_away\": 32,\r\n" + "                    \"pts\": 55,\r\n"
				+ "                    \"w_tot\": 16,\r\n" + "                    \"d_tot\": 7,\r\n"
				+ "                    \"l_tot\": 11,\r\n" + "                    \"gf_tot\": 59,\r\n"
				+ "                    \"ga_tot\": 48,\r\n" + "                    \"gd_home\": 23,\r\n"
				+ "                    \"gd_away\": -12,\r\n" + "                    \"gd_tot\": 11,\r\n"
				+ "                    \"position\": 6\r\n" + "                },\r\n" + "                {\r\n"
				+ "                    \"_id\": \"5aa6e7825b86c53ffd2cbc0c\",\r\n"
				+ "                    \"id_team_season\": 798,\r\n"
				+ "                    \"team_season_name\": \"Schalke 04\",\r\n" + "                    \"p\": 34,\r\n"
				+ "                    \"w_home\": 7,\r\n" + "                    \"d_home\": 7,\r\n"
				+ "                    \"l_home\": 3,\r\n" + "                    \"w_away\": 6,\r\n"
				+ "                    \"d_away\": 4,\r\n" + "                    \"l_away\": 7,\r\n"
				+ "                    \"gf_home\": 28,\r\n" + "                    \"ga_home\": 16,\r\n"
				+ "                    \"gf_away\": 21,\r\n" + "                    \"ga_away\": 26,\r\n"
				+ "                    \"pts\": 50,\r\n" + "                    \"w_tot\": 13,\r\n"
				+ "                    \"d_tot\": 11,\r\n" + "                    \"l_tot\": 10,\r\n"
				+ "                    \"gf_tot\": 49,\r\n" + "                    \"ga_tot\": 42,\r\n"
				+ "                    \"gd_home\": 12,\r\n" + "                    \"gd_away\": -5,\r\n"
				+ "                    \"gd_tot\": 7,\r\n" + "                    \"position\": 7\r\n"
				+ "                },\r\n" + "                {\r\n"
				+ "                    \"_id\": \"5aa6e7825b86c53ffd2cbc12\",\r\n"
				+ "                    \"id_team_season\": 801,\r\n"
				+ "                    \"team_season_name\": \"Hamburger SV\",\r\n"
				+ "                    \"p\": 34,\r\n" + "                    \"w_home\": 11,\r\n"
				+ "                    \"d_home\": 3,\r\n" + "                    \"l_home\": 3,\r\n"
				+ "                    \"w_away\": 3,\r\n" + "                    \"d_away\": 4,\r\n"
				+ "                    \"l_away\": 10,\r\n" + "                    \"gf_home\": 33,\r\n"
				+ "                    \"ga_home\": 22,\r\n" + "                    \"gf_away\": 14,\r\n"
				+ "                    \"ga_away\": 38,\r\n" + "                    \"pts\": 49,\r\n"
				+ "                    \"w_tot\": 14,\r\n" + "                    \"d_tot\": 7,\r\n"
				+ "                    \"l_tot\": 13,\r\n" + "                    \"gf_tot\": 47,\r\n"
				+ "                    \"ga_tot\": 60,\r\n" + "                    \"gd_home\": 11,\r\n"
				+ "                    \"gd_away\": -24,\r\n" + "                    \"gd_tot\": -13,\r\n"
				+ "                    \"position\": 8\r\n" + "                },\r\n" + "                {\r\n"
				+ "                    \"_id\": \"5aa6e7825b86c53ffd2cbc16\",\r\n"
				+ "                    \"id_team_season\": 805,\r\n"
				+ "                    \"team_season_name\": \"Hansa Rostock\",\r\n"
				+ "                    \"p\": 34,\r\n" + "                    \"w_home\": 10,\r\n"
				+ "                    \"d_home\": 1,\r\n" + "                    \"l_home\": 6,\r\n"
				+ "                    \"w_away\": 2,\r\n" + "                    \"d_away\": 7,\r\n"
				+ "                    \"l_away\": 8,\r\n" + "                    \"gf_home\": 34,\r\n"
				+ "                    \"ga_home\": 18,\r\n" + "                    \"gf_away\": 21,\r\n"
				+ "                    \"ga_away\": 36,\r\n" + "                    \"pts\": 44,\r\n"
				+ "                    \"w_tot\": 12,\r\n" + "                    \"d_tot\": 8,\r\n"
				+ "                    \"l_tot\": 14,\r\n" + "                    \"gf_tot\": 55,\r\n"
				+ "                    \"ga_tot\": 54,\r\n" + "                    \"gd_home\": 16,\r\n"
				+ "                    \"gd_away\": -15,\r\n" + "                    \"gd_tot\": 1,\r\n"
				+ "                    \"position\": 9\r\n" + "                },\r\n" + "                {\r\n"
				+ "                    \"_id\": \"5aa6e7825b86c53ffd2cbc0b\",\r\n"
				+ "                    \"id_team_season\": 797,\r\n"
				+ "                    \"team_season_name\": \"Wolfsburg\",\r\n" + "                    \"p\": 34,\r\n"
				+ "                    \"w_home\": 11,\r\n" + "                    \"d_home\": 1,\r\n"
				+ "                    \"l_home\": 5,\r\n" + "                    \"w_away\": 2,\r\n"
				+ "                    \"d_away\": 2,\r\n" + "                    \"l_away\": 13,\r\n"
				+ "                    \"gf_home\": 38,\r\n" + "                    \"ga_home\": 25,\r\n"
				+ "                    \"gf_away\": 18,\r\n" + "                    \"ga_away\": 36,\r\n"
				+ "                    \"pts\": 42,\r\n" + "                    \"w_tot\": 13,\r\n"
				+ "                    \"d_tot\": 3,\r\n" + "                    \"l_tot\": 18,\r\n"
				+ "                    \"gf_tot\": 56,\r\n" + "                    \"ga_tot\": 61,\r\n"
				+ "                    \"gd_home\": 13,\r\n" + "                    \"gd_away\": -18,\r\n"
				+ "                    \"gd_tot\": -5,\r\n" + "                    \"position\": 10\r\n"
				+ "                },\r\n" + "                {\r\n"
				+ "                    \"_id\": \"5aa6e7825b86c53ffd2cbc0d\",\r\n"
				+ "                    \"id_team_season\": 799,\r\n"
				+ "                    \"team_season_name\": \"Borussia Moenchengladbach\",\r\n"
				+ "                    \"p\": 34,\r\n" + "                    \"w_home\": 7,\r\n"
				+ "                    \"d_home\": 6,\r\n" + "                    \"l_home\": 4,\r\n"
				+ "                    \"w_away\": 3,\r\n" + "                    \"d_away\": 3,\r\n"
				+ "                    \"l_away\": 11,\r\n" + "                    \"gf_home\": 21,\r\n"
				+ "                    \"ga_home\": 16,\r\n" + "                    \"gf_away\": 19,\r\n"
				+ "                    \"ga_away\": 33,\r\n" + "                    \"pts\": 39,\r\n"
				+ "                    \"w_tot\": 10,\r\n" + "                    \"d_tot\": 9,\r\n"
				+ "                    \"l_tot\": 15,\r\n" + "                    \"gf_tot\": 40,\r\n"
				+ "                    \"ga_tot\": 49,\r\n" + "                    \"gd_home\": 5,\r\n"
				+ "                    \"gd_away\": -14,\r\n" + "                    \"gd_tot\": -9,\r\n"
				+ "                    \"position\": 11\r\n" + "                },\r\n" + "                {\r\n"
				+ "                    \"_id\": \"5aa6e7825b86c53ffd2cbc10\",\r\n"
				+ "                    \"id_team_season\": 803,\r\n"
				+ "                    \"team_season_name\": \"Hertha Berlin\",\r\n"
				+ "                    \"p\": 34,\r\n" + "                    \"w_home\": 6,\r\n"
				+ "                    \"d_home\": 6,\r\n" + "                    \"l_home\": 5,\r\n"
				+ "                    \"w_away\": 3,\r\n" + "                    \"d_away\": 6,\r\n"
				+ "                    \"l_away\": 8,\r\n" + "                    \"gf_home\": 26,\r\n"
				+ "                    \"ga_home\": 24,\r\n" + "                    \"gf_away\": 16,\r\n"
				+ "                    \"ga_away\": 35,\r\n" + "                    \"pts\": 39,\r\n"
				+ "                    \"w_tot\": 9,\r\n" + "                    \"d_tot\": 12,\r\n"
				+ "                    \"l_tot\": 13,\r\n" + "                    \"gf_tot\": 42,\r\n"
				+ "                    \"ga_tot\": 59,\r\n" + "                    \"gd_home\": 2,\r\n"
				+ "                    \"gd_away\": -19,\r\n" + "                    \"gd_tot\": -17,\r\n"
				+ "                    \"position\": 12\r\n" + "                },\r\n" + "                {\r\n"
				+ "                    \"_id\": \"5aa6e7825b86c53ffd2cbc0a\",\r\n"
				+ "                    \"id_team_season\": 807,\r\n"
				+ "                    \"team_season_name\": \"Kaiserslautern\",\r\n"
				+ "                    \"p\": 34,\r\n" + "                    \"w_home\": 8,\r\n"
				+ "                    \"d_home\": 5,\r\n" + "                    \"l_home\": 4,\r\n"
				+ "                    \"w_away\": 3,\r\n" + "                    \"d_away\": 1,\r\n"
				+ "                    \"l_away\": 13,\r\n" + "                    \"gf_home\": 25,\r\n"
				+ "                    \"ga_home\": 19,\r\n" + "                    \"gf_away\": 14,\r\n"
				+ "                    \"ga_away\": 43,\r\n" + "                    \"pts\": 39,\r\n"
				+ "                    \"w_tot\": 11,\r\n" + "                    \"d_tot\": 6,\r\n"
				+ "                    \"l_tot\": 17,\r\n" + "                    \"gf_tot\": 39,\r\n"
				+ "                    \"ga_tot\": 62,\r\n" + "                    \"gd_home\": 6,\r\n"
				+ "                    \"gd_away\": -29,\r\n" + "                    \"gd_tot\": -23,\r\n"
				+ "                    \"position\": 13\r\n" + "                },\r\n" + "                {\r\n"
				+ "                    \"_id\": \"5aa6e7825b86c53ffd2cbc13\",\r\n"
				+ "                    \"id_team_season\": 796,\r\n"
				+ "                    \"team_season_name\": \"Freiburg\",\r\n" + "                    \"p\": 34,\r\n"
				+ "                    \"w_home\": 10,\r\n" + "                    \"d_home\": 3,\r\n"
				+ "                    \"l_home\": 4,\r\n" + "                    \"w_away\": 0,\r\n"
				+ "                    \"d_away\": 5,\r\n" + "                    \"l_away\": 12,\r\n"
				+ "                    \"gf_home\": 32,\r\n" + "                    \"ga_home\": 25,\r\n"
				+ "                    \"gf_away\": 10,\r\n" + "                    \"ga_away\": 42,\r\n"
				+ "                    \"pts\": 38,\r\n" + "                    \"w_tot\": 10,\r\n"
				+ "                    \"d_tot\": 8,\r\n" + "                    \"l_tot\": 16,\r\n"
				+ "                    \"gf_tot\": 42,\r\n" + "                    \"ga_tot\": 67,\r\n"
				+ "                    \"gd_home\": 7,\r\n" + "                    \"gd_away\": -32,\r\n"
				+ "                    \"gd_tot\": -25,\r\n" + "                    \"position\": 14\r\n"
				+ "                },\r\n" + "                {\r\n"
				+ "                    \"_id\": \"5aa6e7825b86c53ffd2cbc08\",\r\n"
				+ "                    \"id_team_season\": 792,\r\n"
				+ "                    \"team_season_name\": \"Hannover 96\",\r\n"
				+ "                    \"p\": 34,\r\n" + "                    \"w_home\": 5,\r\n"
				+ "                    \"d_home\": 7,\r\n" + "                    \"l_home\": 5,\r\n"
				+ "                    \"w_away\": 4,\r\n" + "                    \"d_away\": 3,\r\n"
				+ "                    \"l_away\": 10,\r\n" + "                    \"gf_home\": 27,\r\n"
				+ "                    \"ga_home\": 26,\r\n" + "                    \"gf_away\": 22,\r\n"
				+ "                    \"ga_away\": 37,\r\n" + "                    \"pts\": 37,\r\n"
				+ "                    \"w_tot\": 9,\r\n" + "                    \"d_tot\": 10,\r\n"
				+ "                    \"l_tot\": 15,\r\n" + "                    \"gf_tot\": 49,\r\n"
				+ "                    \"ga_tot\": 63,\r\n" + "                    \"gd_home\": 1,\r\n"
				+ "                    \"gd_away\": -15,\r\n" + "                    \"gd_tot\": -14,\r\n"
				+ "                    \"position\": 15\r\n" + "                },\r\n" + "                {\r\n"
				+ "                    \"_id\": \"5aa6e7825b86c53ffd2cbc09\",\r\n"
				+ "                    \"id_team_season\": 802,\r\n"
				+ "                    \"team_season_name\": \"Eintracht Frankfurt\",\r\n"
				+ "                    \"p\": 34,\r\n" + "                    \"w_home\": 6,\r\n"
				+ "                    \"d_home\": 4,\r\n" + "                    \"l_home\": 7,\r\n"
				+ "                    \"w_away\": 3,\r\n" + "                    \"d_away\": 1,\r\n"
				+ "                    \"l_away\": 13,\r\n" + "                    \"gf_home\": 25,\r\n"
				+ "                    \"ga_home\": 24,\r\n" + "                    \"gf_away\": 11,\r\n"
				+ "                    \"ga_away\": 29,\r\n" + "                    \"pts\": 32,\r\n"
				+ "                    \"w_tot\": 9,\r\n" + "                    \"d_tot\": 5,\r\n"
				+ "                    \"l_tot\": 20,\r\n" + "                    \"gf_tot\": 36,\r\n"
				+ "                    \"ga_tot\": 53,\r\n" + "                    \"gd_home\": 1,\r\n"
				+ "                    \"gd_away\": -18,\r\n" + "                    \"gd_tot\": -17,\r\n"
				+ "                    \"position\": 16\r\n" + "                },\r\n" + "                {\r\n"
				+ "                    \"_id\": \"5aa6e7825b86c53ffd2cbc11\",\r\n"
				+ "                    \"id_team_season\": 800,\r\n"
				+ "                    \"team_season_name\": \"1860 Muenchen\",\r\n"
				+ "                    \"p\": 34,\r\n" + "                    \"w_home\": 5,\r\n"
				+ "                    \"d_home\": 4,\r\n" + "                    \"l_home\": 8,\r\n"
				+ "                    \"w_away\": 3,\r\n" + "                    \"d_away\": 4,\r\n"
				+ "                    \"l_away\": 10,\r\n" + "                    \"gf_home\": 16,\r\n"
				+ "                    \"ga_home\": 25,\r\n" + "                    \"gf_away\": 16,\r\n"
				+ "                    \"ga_away\": 30,\r\n" + "                    \"pts\": 32,\r\n"
				+ "                    \"w_tot\": 8,\r\n" + "                    \"d_tot\": 8,\r\n"
				+ "                    \"l_tot\": 18,\r\n" + "                    \"gf_tot\": 32,\r\n"
				+ "                    \"ga_tot\": 55,\r\n" + "                    \"gd_home\": -9,\r\n"
				+ "                    \"gd_away\": -14,\r\n" + "                    \"gd_tot\": -23,\r\n"
				+ "                    \"position\": 17\r\n" + "                },\r\n" + "                {\r\n"
				+ "                    \"_id\": \"5aa6e7825b86c53ffd2cbc17\",\r\n"
				+ "                    \"id_team_season\": 804,\r\n"
				+ "                    \"team_season_name\": \"FC Cologne\",\r\n" + "                    \"p\": 34,\r\n"
				+ "                    \"w_home\": 6,\r\n" + "                    \"d_home\": 2,\r\n"
				+ "                    \"l_home\": 9,\r\n" + "                    \"w_away\": 0,\r\n"
				+ "                    \"d_away\": 3,\r\n" + "                    \"l_away\": 14,\r\n"
				+ "                    \"gf_home\": 22,\r\n" + "                    \"ga_home\": 23,\r\n"
				+ "                    \"gf_away\": 10,\r\n" + "                    \"ga_away\": 34,\r\n"
				+ "                    \"pts\": 23,\r\n" + "                    \"w_tot\": 6,\r\n"
				+ "                    \"d_tot\": 5,\r\n" + "                    \"l_tot\": 23,\r\n"
				+ "                    \"gf_tot\": 32,\r\n" + "                    \"ga_tot\": 57,\r\n"
				+ "                    \"gd_home\": -1,\r\n" + "                    \"gd_away\": -24,\r\n"
				+ "                    \"gd_tot\": -25,\r\n" + "                    \"position\": 18\r\n"
				+ "                }\r\n" + "            ]\r\n" + "}";
	}
}
