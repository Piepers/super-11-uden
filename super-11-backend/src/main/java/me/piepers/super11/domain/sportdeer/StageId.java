package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * The stage id in cases where it is referred to from other domain object.
 *
 * @author Bas Piepers
 *
 */
@DataObject
public class StageId {
	@JsonProperty("id_stage")
	private final Long id;

	public StageId(JsonObject jsonObject) {
		this.id = jsonObject.getLong("id_stage");
	}

	private StageId(Long id) {
		this.id = id;
	}

	@JsonCreator
	public static StageId of(@JsonProperty("id_stage") Long id) {
		return new StageId(id);
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
		StageId other = (StageId) obj;
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
