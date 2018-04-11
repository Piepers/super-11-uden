package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * The id of a player for a particular season in cases where it is referred to from other objects.
 *
 * @author Bas Piepers
 */
@DataObject
public class TeamSeasonPlayerId {
    @JsonProperty("id_team_season_player")
    private final Long teamSeasonPlayerId;

    public TeamSeasonPlayerId(JsonObject jsonObject) {
        this.teamSeasonPlayerId = jsonObject.getLong("id_team_season_player");
    }

    private TeamSeasonPlayerId(final Long teamSeasonPlayerId) {
        this.teamSeasonPlayerId = teamSeasonPlayerId;
    }

    @JsonCreator
    public static TeamSeasonPlayerId of(@JsonProperty("id_team_season_player") final Long teamSeasonPlayerId) {
        return new TeamSeasonPlayerId(teamSeasonPlayerId);
    }

    public Long getTeamSeasonPlayerId() {
        return teamSeasonPlayerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamSeasonPlayerId that = (TeamSeasonPlayerId) o;

        return teamSeasonPlayerId.equals(that.teamSeasonPlayerId);
    }

    @Override
    public int hashCode() {
        return teamSeasonPlayerId.hashCode();
    }

    @Override
    public String toString() {
        return "TeamSeasonPlayerId{" +
                "teamSeasonPlayerId=" + teamSeasonPlayerId +
                '}';
    }
}
