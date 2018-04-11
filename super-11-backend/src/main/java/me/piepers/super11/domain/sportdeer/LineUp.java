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
 */
@DataObject
public class LineUp extends SportdeerDomainObject {

    @JsonProperty("shirtNumber")
    private Integer shirtNumber;
    @JsonProperty("row")
    private Integer row;
    @JsonProperty("col")
    private Integer col;
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

    public LineUp(@JsonProperty("_id") Long id, @JsonProperty("shirtNumber") Integer shirtNumber, @JsonProperty("row")
            Integer row, @JsonProperty("col") Integer col, @JsonProperty("is_startingXI") boolean startingXI,
                  @JsonProperty("id_fixture") Long fixtureId, @JsonProperty("id_team_season") Long teamSeasonId,
                  @JsonProperty("team_name") String teamName,
                  @JsonProperty("id_team_season_player") Long teamSeasonPlayerId,
                  @JsonProperty("player_name") String playerName) {
        super(id);
        this.shirtNumber = shirtNumber;
        this.row = row;
        this.col = col;
        this.startingXI = startingXI;
        this.fixtureId = FixtureId.of(fixtureId);
        this.teamSeasonId = teamSeasonId;
        this.teamName = teamName;
        this.teamSeasonPlayerId = teamSeasonPlayerId;
        this.playerName = playerName;
    }

    public LineUp(JsonObject jsonObject) {
        super(jsonObject);
        this.shirtNumber = jsonObject.getInteger("shirtNumber");
        this.row = jsonObject.getInteger("row");
        this.col = jsonObject.getInteger("col");
        this.startingXI = jsonObject.getBoolean("is_startingXI");
        this.fixtureId = FixtureId.of(jsonObject.getLong("id_fixture"));
        this.teamSeasonId = jsonObject.getLong("id_team_season");
        this.teamName = jsonObject.getString("team_name");
        this.teamSeasonPlayerId = jsonObject.getLong("id_team_season_player");
        this.playerName = jsonObject.getString("player_name");

    }

    public Integer getShirtNumber() {
        return this.shirtNumber;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getCol() {
        return col;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        LineUp lineUp = (LineUp) o;

        if (startingXI != lineUp.startingXI) return false;
        if (!shirtNumber.equals(lineUp.shirtNumber)) return false;
        if (!row.equals(lineUp.row)) return false;
        if (!col.equals(lineUp.col)) return false;
        if (!fixtureId.equals(lineUp.fixtureId)) return false;
        if (!teamSeasonId.equals(lineUp.teamSeasonId)) return false;
        if (!teamName.equals(lineUp.teamName)) return false;
        if (!teamSeasonPlayerId.equals(lineUp.teamSeasonPlayerId)) return false;
        return playerName.equals(lineUp.playerName);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + shirtNumber.hashCode();
        result = 31 * result + row.hashCode();
        result = 31 * result + col.hashCode();
        result = 31 * result + (startingXI ? 1 : 0);
        result = 31 * result + fixtureId.hashCode();
        result = 31 * result + teamSeasonId.hashCode();
        result = 31 * result + teamName.hashCode();
        result = 31 * result + teamSeasonPlayerId.hashCode();
        result = 31 * result + playerName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LineUp{" +
                "shirtNumber=" + shirtNumber +
                ", row=" + row +
                ", col=" + col +
                ", startingXI=" + startingXI +
                ", fixtureId=" + fixtureId +
                ", teamSeasonId=" + teamSeasonId +
                ", teamName='" + teamName + '\'' +
                ", teamSeasonPlayerId=" + teamSeasonPlayerId +
                ", playerName='" + playerName + '\'' +
                '}';
    }
}
