package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * The domain object of the SportDeer Team object.
 *
 * @author Bas Piepers
 *
 */
@DataObject
public class Team extends SportdeerDomainObject {

	@JsonProperty("name")
	private final String name;

	@JsonCreator
	public Team(@JsonProperty("_id") Long id, @JsonProperty("name") String name) {
		super(id);
		this.name = name;
	}

	public Team(JsonObject jsonObject) {
		super(jsonObject);
		this.name = jsonObject.getString("name");
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Team [id=" + this.getId() + ", name=" + this.name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (this.name == null ? 0 : this.name.hashCode());
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
		Team other = (Team) obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
