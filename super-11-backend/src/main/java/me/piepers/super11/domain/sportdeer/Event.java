package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonDeserialize(builder = Event.Builder.class)
@DataObject
public class Event extends SportdeerDomainObject {

	// TODO: make enum
	@JsonProperty("type")
	private final String type; // subst, goal, etc.
	@JsonProperty("id_fixture")
	private final Long fixtureId;
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
		this.type = this.docs.getString("type");
		this.fixtureId = this.docs.getLong("id_fixture");
		this.elapsed = this.docs.getInteger("elapsed");
		this.teamSeasonId = this.docs.getLong("id_team_season");
		this.teamName = this.docs.getString("team_name");
		this.teamSeasonPlayerIdIn = this.docs.getLong("id_team_season_player_in");
		this.teamSeasonPlayerIdOut = this.docs.getLong("id_team_season_player_out");
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

	@JsonPOJOBuilder
	static class Builder {
		private final Long id;
		private String type;
		private Long fixtureId;
		private Integer elapsed;
		private Long teamSeasonId;
		private String teamName;
		private Long teamSeasonPlayerIdIn;
		private Long teamSeasonPlayerIdOut;

		public Builder(Long id) {
			this.id = id;
		}

		public Builder type(String type) {
			this.type = type;
			return this;
		}

		public Builder fixtureId(Long fixtureId) {
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
