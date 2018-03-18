package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * Represents the league id in cases where it is referred to from another
 * object.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class LeagueId {
	@JsonProperty("id_league")
	private final Long id;

	private LeagueId(Long id) {
		this.id = id;
	}

	public LeagueId(JsonObject jsonObject) {
		this.id = jsonObject.getLong("id_league");
	}

	@JsonCreator
	public static LeagueId of(@JsonProperty("id_league") Long id) {
		return new LeagueId(id);
	}

	public Long getId() {
		return this.id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.id == null ? 0 : this.id.hashCode());
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
		LeagueId other = (LeagueId) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
