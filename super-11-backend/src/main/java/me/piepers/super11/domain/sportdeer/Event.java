package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * The Sportdeer API Event object.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
@JsonDeserialize(builder = Event.Builder.class)
@JsonPropertyOrder({ "_id"})
public class Event extends SportdeerDomainObject {

	// TODO: make enum
	@JsonProperty("type")
	private final String type; // subst, goal, etc.
	@JsonUnwrapped
	private final FixtureId fixtureId;
	@JsonProperty("elapsed")
	private final Integer elapsed;
	@JsonProperty("id_team_season")
	private final Long teamSeasonId;
	@JsonProperty("team_name")
	private final String teamName;
	@JsonProperty("id_team_season_player_in")
	private final Long teamSeasonPlayerIdIn;
	@JsonProperty("id_team_season_player_out")
	private final Long teamSeasonPlayerIdOut;

	public Event(JsonObject jsonObject) {
		super(jsonObject);
		this.type = jsonObject.getString("type");
		this.fixtureId = FixtureId.of(jsonObject.getLong("id_fixture"));
		this.elapsed = jsonObject.getInteger("elapsed");
		this.teamSeasonId = jsonObject.getLong("id_team_season");
		this.teamName = jsonObject.getString("team_name");
		this.teamSeasonPlayerIdIn = jsonObject.getLong("id_team_season_player_in");
		this.teamSeasonPlayerIdOut = jsonObject.getLong("id_team_season_player_out");
	}

	private Event(Builder builder) {
		super(builder.id);
		this.type = builder.type;
		this.fixtureId = builder.fixtureId;
		this.elapsed = builder.elapsed;
		this.teamSeasonId = builder.teamSeasonId;
		this.teamName = builder.teamName;
		this.teamSeasonPlayerIdIn = builder.teamSeasonPlayerIdIn;
		this.teamSeasonPlayerIdOut = builder.teamSeasonPlayerIdOut;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Event event = (Event) o;

		if (!type.equals(event.type)) return false;
		if (!fixtureId.equals(event.fixtureId)) return false;
		if (!elapsed.equals(event.elapsed)) return false;
		if (!teamSeasonId.equals(event.teamSeasonId)) return false;
		if (!teamName.equals(event.teamName)) return false;
		if (teamSeasonPlayerIdIn != null ? !teamSeasonPlayerIdIn.equals(event.teamSeasonPlayerIdIn) : event.teamSeasonPlayerIdIn != null)
			return false;
		return teamSeasonPlayerIdOut != null ? teamSeasonPlayerIdOut.equals(event.teamSeasonPlayerIdOut) : event.teamSeasonPlayerIdOut == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + type.hashCode();
		result = 31 * result + fixtureId.hashCode();
		result = 31 * result + elapsed.hashCode();
		result = 31 * result + teamSeasonId.hashCode();
		result = 31 * result + teamName.hashCode();
		result = 31 * result + (teamSeasonPlayerIdIn != null ? teamSeasonPlayerIdIn.hashCode() : 0);
		result = 31 * result + (teamSeasonPlayerIdOut != null ? teamSeasonPlayerIdOut.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Event [id=" + this.getId() + ", type=" + this.type + ", fixtureId=" + this.fixtureId + ", elapsed="
				+ this.elapsed + ", teamSeasonId=" + this.teamSeasonId + ", teamName=" + this.teamName
				+ ", teamSeasonPlayerIdIn=" + this.teamSeasonPlayerIdIn + ", teamSeasonPlayerIdOut="
				+ this.teamSeasonPlayerIdOut + "]";
	}

	@JsonPOJOBuilder(withPrefix = "")
	static class Builder {
		private final Long id;
		@JsonProperty("type")
		private String type;
		@JsonUnwrapped
		private FixtureId fixtureId;
		@JsonProperty("elapsed")
		private Integer elapsed;
		@JsonProperty("id_team_season")
		private Long teamSeasonId;
		@JsonProperty("team_name")
		private String teamName;
		@JsonProperty("id_team_season_player_in")
		private Long teamSeasonPlayerIdIn;
		@JsonProperty("id_team_season_player_out")
		private Long teamSeasonPlayerIdOut;

		public Builder(@JsonProperty("_id") Long id) {
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

		public Event build() {
			return new Event(this);
		}
	}
}
