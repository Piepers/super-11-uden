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
@JsonPropertyOrder({ "_id" })
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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (this.elapsed == null ? 0 : this.elapsed.hashCode());
		result = prime * result + (this.fixtureId == null ? 0 : this.fixtureId.hashCode());
		result = prime * result + (this.teamName == null ? 0 : this.teamName.hashCode());
		result = prime * result + (this.teamSeasonId == null ? 0 : this.teamSeasonId.hashCode());
		result = prime * result + (this.teamSeasonPlayerIdIn == null ? 0 : this.teamSeasonPlayerIdIn.hashCode());
		result = prime * result + (this.teamSeasonPlayerIdOut == null ? 0 : this.teamSeasonPlayerIdOut.hashCode());
		result = prime * result + (this.type == null ? 0 : this.type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Event other = (Event) obj;
		if (this.elapsed == null) {
			if (other.elapsed != null) {
				return false;
			}
		} else if (!this.elapsed.equals(other.elapsed)) {
			return false;
		}
		if (this.fixtureId == null) {
			if (other.fixtureId != null) {
				return false;
			}
		} else if (!this.fixtureId.equals(other.fixtureId)) {
			return false;
		}
		if (this.teamName == null) {
			if (other.teamName != null) {
				return false;
			}
		} else if (!this.teamName.equals(other.teamName)) {
			return false;
		}
		if (this.teamSeasonId == null) {
			if (other.teamSeasonId != null) {
				return false;
			}
		} else if (!this.teamSeasonId.equals(other.teamSeasonId)) {
			return false;
		}
		if (this.teamSeasonPlayerIdIn == null) {
			if (other.teamSeasonPlayerIdIn != null) {
				return false;
			}
		} else if (!this.teamSeasonPlayerIdIn.equals(other.teamSeasonPlayerIdIn)) {
			return false;
		}
		if (this.teamSeasonPlayerIdOut == null) {
			if (other.teamSeasonPlayerIdOut != null) {
				return false;
			}
		} else if (!this.teamSeasonPlayerIdOut.equals(other.teamSeasonPlayerIdOut)) {
			return false;
		}
		if (this.type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!this.type.equals(other.type)) {
			return false;
		}
		return true;
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
