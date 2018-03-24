package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * The Sportdeer API line-up domain object which contains lineups for specific
 * fixtures.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class LineUp extends SportdeerDomainObject {

	@JsonProperty("shirtNumber")
	private Integer shirtNumber;
	@JsonProperty("is_startingXI")
	private boolean startingXI;
	@JsonUnwrapped
	private FixtureId fixtureId;
	@JsonProperty("id_team_season")
	private Long teamSeasonId;
	@JsonProperty("team_name")
	private String teamName;
	@JsonProperty("id_team_season_player")
	private Long teamSeasonPlayerId;
	@JsonProperty("player_name")
	private String playerName;

	public LineUp(@JsonProperty("_id") Long id, @JsonProperty("shirtNumber") Integer shirtNumber,
			@JsonProperty("is_startingXI") boolean startingXI, @JsonProperty("id_fixture") Long fixtureId,
			@JsonProperty("id_team_season") Long teamSeasonId, @JsonProperty("team_name") String teamName,
			@JsonProperty("id_team_season_player") Long teamSeasonPlayerId,
			@JsonProperty("player_name") String playerName) {
		super(id);
		this.shirtNumber = shirtNumber;
		this.startingXI = startingXI;
		this.fixtureId = FixtureId.of(fixtureId);
		this.teamSeasonId = teamSeasonId;
		this.teamName = teamName;
		this.teamSeasonPlayerId = teamSeasonPlayerId;
		this.playerName = playerName;
	}

	public LineUp(JsonObject jsonObject) {
		super(jsonObject);

	}

	public Integer getShirtNumber() {
		return this.shirtNumber;
	}

	public boolean isStartingXI() {
		return this.startingXI;
	}

	public FixtureId getFixtureId() {
		return this.fixtureId;
	}

	public Long getTeamSeasonId() {
		return this.teamSeasonId;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public Long getTeamSeasonPlayerId() {
		return this.teamSeasonPlayerId;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	@Override
	public String toString() {
		return "LineUp [id=" + this.getId() + ", shirtNumber=" + this.shirtNumber + ", startingXI=" + this.startingXI
				+ ", fixtureId=" + this.fixtureId + ", teamSeasonId=" + this.teamSeasonId + ", teamName="
				+ this.teamName + ", teamSeasonPlayerId=" + this.teamSeasonPlayerId + ", playerName=" + this.playerName
				+ "]";
	}

}
