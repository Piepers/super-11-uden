package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * Represents the country id in cases where it is referred to from another
 * domain object.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class CountryId {
	@JsonProperty("id_country")
	private final Long id;

	private CountryId(Long id) {
		this.id = id;
	}

	public CountryId(JsonObject jsonObject) {
		this.id = jsonObject.getLong("id_country");
	}

	@JsonCreator
	public static CountryId of(@JsonProperty("id_country") Long id) {
		return new CountryId(id);
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
		CountryId other = (CountryId) obj;
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
