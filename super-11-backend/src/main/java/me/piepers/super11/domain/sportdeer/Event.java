package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import me.piepers.super11.domain.JsonDomainObject;

/**
 * The Sportdeer API Event object. Note that this doesn't extend {@link SportdeerDomainObject} since the id field is
 * slightly different.
 *
 * @author Bas Piepers
 *
 */
@DataObject
@JsonDeserialize(builder = Event.Builder.class)
@JsonPropertyOrder({ "_id" })
public class Event implements JsonDomainObject {

	@JsonProperty("_id")
	private final String id;
	// TODO: make enum
	@JsonProperty("type")
	private final String type; // subst, goal, card, etc.
	@JsonUnwrapped
	private final FixtureId fixtureId;
	@JsonProperty("elapsed")
	private final Integer elapsed;
	@JsonProperty("elapsed_plus")
	private Integer elapsedPlus;
	@JsonProperty("id_team_season")
	private final Long teamSeasonId;
	@JsonProperty("team_name")
	private final String teamName;
	@JsonProperty("id_team_season_player_in")
	private final Long teamSeasonPlayerIdIn;
	@JsonProperty("id_team_season_player_out")
	private final Long teamSeasonPlayerIdOut;
	@JsonUnwrapped
	private Goal goal;
	@JsonUnwrapped
	private TeamSeasonPlayerId teamSeasonPlayerId;

	public Event(JsonObject jsonObject) {
		this.id = jsonObject.getString("_id");
		this.type = jsonObject.getString("type");
		this.fixtureId = FixtureId.of(jsonObject.getLong("id_fixture"));
		this.elapsed = jsonObject.getInteger("elapsed");
		this.teamSeasonId = jsonObject.getLong("id_team_season");
		this.teamName = jsonObject.getString("team_name");
		this.teamSeasonPlayerIdIn = jsonObject.getLong("id_team_season_player_in");
		this.teamSeasonPlayerIdOut = jsonObject.getLong("id_team_season_player_out");
		if (type.equals("goal")) {
			this.goal = new Goal(jsonObject.getString("goal_subtype"), jsonObject.getString("goal_type_code"), jsonObject.getString("goal_type_desc"));
		}
	}

	private Event(Builder builder) {
		this.id = builder.id;
		this.type = builder.type;
		this.fixtureId = builder.fixtureId;
		this.elapsed = builder.elapsed;
		this.elapsedPlus = builder.elapsedPlus;
		this.teamSeasonId = builder.teamSeasonId;
		this.teamName = builder.teamName;
		this.teamSeasonPlayerIdIn = builder.teamSeasonPlayerIdIn;
		this.teamSeasonPlayerIdOut = builder.teamSeasonPlayerIdOut;
		this.goal = builder.goal;
		this.teamSeasonPlayerId = builder.teamSeasonPlayerId;
	}

	public String getType() {
		return this.type;
	}

	public FixtureId getFixtureId() {
		return this.fixtureId;
	}

	public Integer getElapsed() {
		return this.elapsed;
	}

	public Long getTeamSeasonId() {
		return this.teamSeasonId;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public Long getTeamSeasonPlayerIdIn() {
		return this.teamSeasonPlayerIdIn;
	}

	public Long getTeamSeasonPlayerIdOut() {
		return this.teamSeasonPlayerIdOut;
	}

	public Integer getElapsedPlus() {
		return elapsedPlus;
	}

	public Goal getGoal() {
		return goal;
	}

	public TeamSeasonPlayerId getTeamSeasonPlayerId() {
		return teamSeasonPlayerId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Event event = (Event) o;

		if (!id.equals(event.id)) return false;
		if (!type.equals(event.type)) return false;
		if (fixtureId != null ? !fixtureId.equals(event.fixtureId) : event.fixtureId != null) return false;
		if (!elapsed.equals(event.elapsed)) return false;
		if (elapsedPlus != null ? !elapsedPlus.equals(event.elapsedPlus) : event.elapsedPlus != null) return false;
		if (teamSeasonId != null ? !teamSeasonId.equals(event.teamSeasonId) : event.teamSeasonId != null) return false;
		if (!teamName.equals(event.teamName)) return false;
		if (teamSeasonPlayerIdIn != null ? !teamSeasonPlayerIdIn.equals(event.teamSeasonPlayerIdIn) : event.teamSeasonPlayerIdIn != null)
			return false;
		if (teamSeasonPlayerIdOut != null ? !teamSeasonPlayerIdOut.equals(event.teamSeasonPlayerIdOut) : event.teamSeasonPlayerIdOut != null)
			return false;
		if (goal != null ? !goal.equals(event.goal) : event.goal != null) return false;
		return teamSeasonPlayerId != null ? teamSeasonPlayerId.equals(event.teamSeasonPlayerId) : event.teamSeasonPlayerId == null;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + type.hashCode();
		result = 31 * result + (fixtureId != null ? fixtureId.hashCode() : 0);
		result = 31 * result + elapsed.hashCode();
		result = 31 * result + (elapsedPlus != null ? elapsedPlus.hashCode() : 0);
		result = 31 * result + (teamSeasonId != null ? teamSeasonId.hashCode() : 0);
		result = 31 * result + teamName.hashCode();
		result = 31 * result + (teamSeasonPlayerIdIn != null ? teamSeasonPlayerIdIn.hashCode() : 0);
		result = 31 * result + (teamSeasonPlayerIdOut != null ? teamSeasonPlayerIdOut.hashCode() : 0);
		result = 31 * result + (goal != null ? goal.hashCode() : 0);
		result = 31 * result + (teamSeasonPlayerId != null ? teamSeasonPlayerId.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Event{" +
				"id='" + id + '\'' +
				", type='" + type + '\'' +
				", fixtureId=" + fixtureId +
				", elapsed=" + elapsed +
				", elapsedPlus=" + elapsedPlus +
				", teamSeasonId=" + teamSeasonId +
				", teamName='" + teamName + '\'' +
				", teamSeasonPlayerIdIn=" + teamSeasonPlayerIdIn +
				", teamSeasonPlayerIdOut=" + teamSeasonPlayerIdOut +
				", goal=" + goal +
				", teamSeasonPlayerId=" + teamSeasonPlayerId +
				'}';
	}

	@JsonPOJOBuilder(withPrefix = "")
	static class Builder {
		@JsonProperty("_id")
		private final String id;
		@JsonProperty("type")
		private String type;
		@JsonUnwrapped
		private FixtureId fixtureId;
		@JsonProperty("elapsed")
		private Integer elapsed;
		@JsonProperty("elapsed_plus")
		private Integer elapsedPlus;
		@JsonProperty("id_team_season")
		private Long teamSeasonId;
		@JsonProperty("team_name")
		private String teamName;
		@JsonProperty("id_team_season_player_in")
		private Long teamSeasonPlayerIdIn;
		@JsonProperty("id_team_season_player_out")
		private Long teamSeasonPlayerIdOut;
		@JsonUnwrapped
		private Goal goal;
		@JsonUnwrapped
		private TeamSeasonPlayerId teamSeasonPlayerId;

		public Builder(@JsonProperty("_id") String id) {
			this.id = id;
		}

		public Builder type(String type) {
			this.type = type;
			return this;
		}

		public Builder fixtureId(FixtureId fixtureId) {
			this.fixtureId = fixtureId;
			return this;
		}

		public Builder elapsed(Integer elapsed) {
			this.elapsed = elapsed;
			return this;
		}

		public Builder teamSeasonId(Long teamSeasonId) {
			this.teamSeasonId = teamSeasonId;
			return this;
		}

		public Builder teamName(String teamName) {
			this.teamName = teamName;
			return this;
		}

		public Builder teamSeasonPlayerIdIn(Long teamSeasonPlayerIdIn) {
			this.teamSeasonPlayerIdIn = teamSeasonPlayerIdIn;
			return this;
		}

		public Builder teamSeasonPlayerIdOut(Long teamSeasonPlayerIdOut) {
			this.teamSeasonPlayerIdOut = teamSeasonPlayerIdOut;
			return this;
		}

		public Builder goal(Goal goal) {
			this.goal = goal;
			return this;
		}

		public Builder elapsedPlus(Integer elapsedPlus) {
			this.elapsedPlus = elapsedPlus;
			return this;
		}

		public Builder teamSeasonPlayerId(TeamSeasonPlayerId teamSeasonPlayerId) {
			this.teamSeasonPlayerId = teamSeasonPlayerId;
			return this;
		}

		public Event build() {
			return new Event(this);
		}
	}
}
