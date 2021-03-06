package me.piepers.super11.domain.sportdeer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import io.vertx.core.json.JsonObject;

@RunWith(JUnit4.class)
public class StatTest {
	@Test
	public void test_that_example_response_is_mapped_as_expected() throws Exception {
		Docs<Stat> docs = SportdeerMapper.from(this.generateDefaultExampleResponse(), Stat.class);
		assertNotNull(docs);
		assertNotNull(docs.getData());
		List<Stat> stats = docs.getData();
		assertThat(stats.size(), is(62));
	}

	@Test
	public void test_that_example_json_object_is_mapped_as_expected() {
		JsonObject jsonObject = new JsonObject(this.generateStatJson());
		Stat stat = new Stat(jsonObject);
		assertNotNull(stat);
		assertNotNull(stat.getStatType());
		StatType statType = stat.getStatType();
		assertThat(statType.getSubType(), is(equalTo("pull")));
		assertThat(statType.getType(), is(equalTo("foulcommit")));
		assertThat(statType.getTeamSeasonId(), is(833L));
		assertThat(stat.getCounter(), is(1));
	}

	private String generateStatJson() {
		return "{\r\n" + "            \"_id\": {\r\n" + "                \"type\": \"foulcommit\",\r\n"
				+ "                \"subtype\": \"pull\",\r\n" + "                \"id_team_season\": 833\r\n"
				+ "            },\r\n" + "            \"counter\": 1\r\n" + "        },\r\n" + "        {";
	}

	private String generateDefaultExampleResponse() {
		return "{\r\n" + "    \"docs\": [\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"foulcommit\",\r\n" + "                \"subtype\": \"pull\",\r\n"
				+ "                \"id_team_season\": 833\r\n" + "            },\r\n"
				+ "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"cross\",\r\n" + "                \"subtype\": \"long ball\",\r\n"
				+ "                \"id_team_season\": 840\r\n" + "            },\r\n"
				+ "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"foulsuffered\",\r\n" + "                \"subtype\": \"pull\",\r\n"
				+ "                \"id_team_season\": 833\r\n" + "            },\r\n"
				+ "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"shoton\",\r\n"
				+ "                \"subtype\": \"big chance header\",\r\n"
				+ "                \"id_team_season\": 840\r\n" + "            },\r\n"
				+ "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"ball_possession\",\r\n" + "                \"id_team_season\": 840\r\n"
				+ "            },\r\n" + "            \"counter\": 67\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"foulcommit\",\r\n"
				+ "                \"subtype\": \"pushing\",\r\n" + "                \"id_team_season\": 833\r\n"
				+ "            },\r\n" + "            \"counter\": 3\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"shotoff\",\r\n"
				+ "                \"subtype\": \"direct_freekick\",\r\n"
				+ "                \"id_team_season\": 840\r\n" + "            },\r\n"
				+ "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"throwin\",\r\n" + "                \"subtype\": \"cross\",\r\n"
				+ "                \"id_team_season\": 840\r\n" + "            },\r\n"
				+ "            \"counter\": 2\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"shoton\",\r\n"
				+ "                \"subtype\": \"big chance blocked\",\r\n"
				+ "                \"id_team_season\": 840\r\n" + "            },\r\n"
				+ "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"foulcommit\",\r\n"
				+ "                \"subtype\": \"dangerous_play\",\r\n" + "                \"id_team_season\": 833\r\n"
				+ "            },\r\n" + "            \"counter\": 2\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"cross\",\r\n"
				+ "                \"subtype\": \"freekick_cross\",\r\n" + "                \"id_team_season\": 833\r\n"
				+ "            },\r\n" + "            \"counter\": 2\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"throwin\",\r\n"
				+ "                \"subtype\": \"cross\",\r\n" + "                \"id_team_season\": 833\r\n"
				+ "            },\r\n" + "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"foulsuffered\",\r\n"
				+ "                \"subtype\": \"trip\",\r\n" + "                \"id_team_season\": 833\r\n"
				+ "            },\r\n" + "            \"counter\": 6\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"shotoff\",\r\n"
				+ "                \"subtype\": \"shot\",\r\n" + "                \"id_team_season\": 840\r\n"
				+ "            },\r\n" + "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"foulsuffered\",\r\n"
				+ "                \"subtype\": \"dangerous_play\",\r\n" + "                \"id_team_season\": 840\r\n"
				+ "            },\r\n" + "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"shoton\",\r\n"
				+ "                \"subtype\": \"blocked_shot\",\r\n" + "                \"id_team_season\": 840\r\n"
				+ "            },\r\n" + "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"shoton\",\r\n"
				+ "                \"subtype\": \"shot\",\r\n" + "                \"id_team_season\": 833\r\n"
				+ "            },\r\n" + "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"foulsuffered\",\r\n"
				+ "                \"subtype\": \"pushing\",\r\n" + "                \"id_team_season\": 833\r\n"
				+ "            },\r\n" + "            \"counter\": 3\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"shotoff\",\r\n"
				+ "                \"subtype\": \"big chance header\",\r\n"
				+ "                \"id_team_season\": 840\r\n" + "            },\r\n"
				+ "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"cross\",\r\n" + "                \"subtype\": \"clear\",\r\n"
				+ "                \"id_team_season\": 840\r\n" + "            },\r\n"
				+ "            \"counter\": 8\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"shotoff\",\r\n" + "                \"subtype\": \"distance\",\r\n"
				+ "                \"id_team_season\": 833\r\n" + "            },\r\n"
				+ "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"goalkick\",\r\n" + "                \"id_team_season\": 833\r\n"
				+ "            },\r\n" + "            \"counter\": 9\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"foulcommit\",\r\n"
				+ "                \"subtype\": \"dangerous_play\",\r\n" + "                \"id_team_season\": 840\r\n"
				+ "            },\r\n" + "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"cross\",\r\n"
				+ "                \"subtype\": \"dribble\",\r\n" + "                \"id_team_season\": 840\r\n"
				+ "            },\r\n" + "            \"counter\": 4\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"cross\",\r\n"
				+ "                \"subtype\": \"defensive error\",\r\n"
				+ "                \"id_team_season\": 840\r\n" + "            },\r\n"
				+ "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"cross\",\r\n" + "                \"subtype\": \"keeper catch\",\r\n"
				+ "                \"id_team_season\": 840\r\n" + "            },\r\n"
				+ "            \"counter\": 2\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"foulcommit\",\r\n" + "                \"subtype\": \"from_behind\",\r\n"
				+ "                \"id_team_season\": 833\r\n" + "            },\r\n"
				+ "            \"counter\": 2\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"foulcommit\",\r\n" + "                \"subtype\": \"trip\",\r\n"
				+ "                \"id_team_season\": 833\r\n" + "            },\r\n"
				+ "            \"counter\": 6\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"cross\",\r\n" + "                \"subtype\": \"clear\",\r\n"
				+ "                \"id_team_season\": 833\r\n" + "            },\r\n"
				+ "            \"counter\": 35\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"shotoff\",\r\n" + "                \"subtype\": \"volley\",\r\n"
				+ "                \"id_team_season\": 840\r\n" + "            },\r\n"
				+ "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"foulsuffered\",\r\n" + "                \"subtype\": \"pushing\",\r\n"
				+ "                \"id_team_season\": 840\r\n" + "            },\r\n"
				+ "            \"counter\": 5\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"cross\",\r\n" + "                \"subtype\": \"cross\",\r\n"
				+ "                \"id_team_season\": 840\r\n" + "            },\r\n"
				+ "            \"counter\": 30\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"throwin\",\r\n" + "                \"subtype\": \"opponent_half\",\r\n"
				+ "                \"id_team_season\": 840\r\n" + "            },\r\n"
				+ "            \"counter\": 11\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"foulcommit\",\r\n" + "                \"subtype\": \"pushing\",\r\n"
				+ "                \"id_team_season\": 840\r\n" + "            },\r\n"
				+ "            \"counter\": 5\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"goalkick\",\r\n" + "                \"id_team_season\": 840\r\n"
				+ "            },\r\n" + "            \"counter\": 3\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"foulcommit\",\r\n"
				+ "                \"subtype\": \"trip\",\r\n" + "                \"id_team_season\": 840\r\n"
				+ "            },\r\n" + "            \"counter\": 3\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"foulsuffered\",\r\n"
				+ "                \"subtype\": \"trip\",\r\n" + "                \"id_team_season\": 840\r\n"
				+ "            },\r\n" + "            \"counter\": 3\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"foulsuffered\",\r\n"
				+ "                \"subtype\": \"penalty\",\r\n" + "                \"id_team_season\": 833\r\n"
				+ "            },\r\n" + "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"foulsuffered\",\r\n"
				+ "                \"subtype\": \"dangerous_play\",\r\n" + "                \"id_team_season\": 833\r\n"
				+ "            },\r\n" + "            \"counter\": 2\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"cross\",\r\n"
				+ "                \"subtype\": \"freekick_cross\",\r\n" + "                \"id_team_season\": 840\r\n"
				+ "            },\r\n" + "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"cross\",\r\n"
				+ "                \"subtype\": \"dribble\",\r\n" + "                \"id_team_season\": 833\r\n"
				+ "            },\r\n" + "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"ball_possession\",\r\n"
				+ "                \"id_team_season\": 833\r\n" + "            },\r\n"
				+ "            \"counter\": 33\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"corner\",\r\n" + "                \"subtype\": \"cross_left\",\r\n"
				+ "                \"id_team_season\": 840\r\n" + "            },\r\n"
				+ "            \"counter\": 8\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"shoton\",\r\n" + "                \"subtype\": \"blocked_header\",\r\n"
				+ "                \"id_team_season\": 840\r\n" + "            },\r\n"
				+ "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"cross\",\r\n" + "                \"subtype\": \"keeper drop\",\r\n"
				+ "                \"id_team_season\": 833\r\n" + "            },\r\n"
				+ "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"shotoff\",\r\n" + "                \"subtype\": \"header\",\r\n"
				+ "                \"id_team_season\": 840\r\n" + "            },\r\n"
				+ "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"throwin\",\r\n" + "                \"subtype\": \"opponent_half\",\r\n"
				+ "                \"id_team_season\": 833\r\n" + "            },\r\n"
				+ "            \"counter\": 9\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"foulsuffered\",\r\n"
				+ "                \"subtype\": \"from_behind\",\r\n" + "                \"id_team_season\": 833\r\n"
				+ "            },\r\n" + "            \"counter\": 2\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"shotoff\",\r\n"
				+ "                \"subtype\": \"wide\",\r\n" + "                \"id_team_season\": 840\r\n"
				+ "            },\r\n" + "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"corner\",\r\n"
				+ "                \"subtype\": \"cross_right\",\r\n" + "                \"id_team_season\": 840\r\n"
				+ "            },\r\n" + "            \"counter\": 5\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"cross\",\r\n"
				+ "                \"subtype\": \"keeper catch\",\r\n" + "                \"id_team_season\": 833\r\n"
				+ "            },\r\n" + "            \"counter\": 5\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"cross\",\r\n"
				+ "                \"subtype\": \"defensive error\",\r\n"
				+ "                \"id_team_season\": 833\r\n" + "            },\r\n"
				+ "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"cross\",\r\n" + "                \"subtype\": \"cross\",\r\n"
				+ "                \"id_team_season\": 833\r\n" + "            },\r\n"
				+ "            \"counter\": 7\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"cross\",\r\n" + "                \"subtype\": \"run\",\r\n"
				+ "                \"id_team_season\": 833\r\n" + "            },\r\n"
				+ "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"foulcommit\",\r\n" + "                \"subtype\": \"penalty\",\r\n"
				+ "                \"id_team_season\": 833\r\n" + "            },\r\n"
				+ "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"foulcommit\",\r\n" + "                \"subtype\": \"serious_foul\",\r\n"
				+ "                \"id_team_season\": 840\r\n" + "            },\r\n"
				+ "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n" + "            \"_id\": {\r\n"
				+ "                \"type\": \"offside\",\r\n" + "                \"id_team_season\": 833\r\n"
				+ "            },\r\n" + "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"foulsuffered\",\r\n"
				+ "                \"subtype\": \"serious_foul\",\r\n" + "                \"id_team_season\": 840\r\n"
				+ "            },\r\n" + "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"goal\",\r\n"
				+ "                \"subtype\": \"Penalty\",\r\n" + "                \"id_team_season\": 840\r\n"
				+ "            },\r\n" + "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"goal\",\r\n"
				+ "                \"subtype\": \"Normal goal\",\r\n" + "                \"id_team_season\": 840\r\n"
				+ "            },\r\n" + "            \"counter\": 1\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"card\",\r\n"
				+ "                \"subtype\": \"y\",\r\n" + "                \"id_team_season\": 833\r\n"
				+ "            },\r\n" + "            \"counter\": 2\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"_id\": {\r\n" + "                \"type\": \"card\",\r\n"
				+ "                \"subtype\": \"y\",\r\n" + "                \"id_team_season\": 840\r\n"
				+ "            },\r\n" + "            \"counter\": 1\r\n" + "        }\r\n" + "    ]\r\n" + "}";
	}
}
