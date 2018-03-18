package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * Season id for when it is referred to by other domain objects.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class SeasonId {
	@JsonProperty("id_season")
	private final Long id;

	public SeasonId(JsonObject jsonObject) {
		this.id = jsonObject.getLong("id_season");
	}

	private SeasonId(Long id) {
		this.id = id;
	}

	@JsonCreator
	public static SeasonId of(@JsonProperty("id_season") Long id) {
		return new SeasonId(id);
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
		SeasonId other = (SeasonId) obj;
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
