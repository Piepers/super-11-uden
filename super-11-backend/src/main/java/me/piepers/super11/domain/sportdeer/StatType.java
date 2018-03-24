package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import me.piepers.super11.domain.JsonDomainObject;

/**
 * The type of statistic, holds the type, subtype (optional) and the team season
 * id.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class StatType implements JsonDomainObject {
	@JsonProperty("type")
	private final String type;
	@JsonProperty("subtype")
	private final String subType;
	@JsonProperty("id_team_season")
	private final Long teamSeasonId;

	public StatType(JsonObject jsonObject) {
		this.type = jsonObject.getString("type");
		this.subType = jsonObject.getString("subtype");
		this.teamSeasonId = jsonObject.getLong("id_team_season");
	}

	public StatType(@JsonProperty("type") String type, @JsonProperty("subtype") String subType,
			@JsonProperty("id_team_season") Long teamSeasonId) {
		super();
		this.type = type;
		this.subType = subType;
		this.teamSeasonId = teamSeasonId;
	}

	public String getType() {
		return this.type;
	}

	public String getSubType() {
		return this.subType;
	}

	public Long getTeamSeasonId() {
		return this.teamSeasonId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.subType == null ? 0 : this.subType.hashCode());
		result = prime * result + (this.teamSeasonId == null ? 0 : this.teamSeasonId.hashCode());
		result = prime * result + (this.type == null ? 0 : this.type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		StatType other = (StatType) obj;
		if (this.subType == null) {
			if (other.subType != null) {
				return false;
			}
		} else if (!this.subType.equals(other.subType)) {
			return false;
		}
		if (this.teamSeasonId == null) {
			if (other.teamSeasonId != null) {
				return false;
			}
		} else if (!this.teamSeasonId.equals(other.teamSeasonId)) {
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
		return "StatType [type=" + this.type + ", subType=" + this.subType + ", teamSeasonId=" + this.teamSeasonId
				+ "]";
	}

}
