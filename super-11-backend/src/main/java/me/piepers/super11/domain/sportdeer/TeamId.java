package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * The id as a reference to the {@link Team} object.
 *
 * @author Bas Piepers
 *
 */
@DataObject
public class TeamId {
	@JsonProperty("id_team")
	private final Long id;

	public TeamId(JsonObject jsonObject) {
		this.id = jsonObject.getLong("id_team");
	}

	@JsonCreator
	public static TeamId of(@JsonProperty("id_team") Long id) {
		return new TeamId(id);
	}

	private TeamId(Long id) {
		this.id = id;
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
		TeamId other = (TeamId) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "TeamId [id=" + this.id + "]";
	}

}
