package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import me.piepers.super11.domain.JsonDomainObject;

@DataObject
public abstract class SportdeerDomainObject implements JsonDomainObject {

	@JsonProperty("_id")
	private Long id;

	@JsonIgnore
	protected JsonObject docs;

	@JsonCreator
	public SportdeerDomainObject(@JsonProperty("_id") Long id) {
		this.id = id;
	}

	public SportdeerDomainObject(JsonObject jsonObject) {
		this.docs = jsonObject.getJsonObject("docs");
		this.id = this.docs.getLong("_id");
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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
		SportdeerDomainObject other = (SportdeerDomainObject) obj;
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
