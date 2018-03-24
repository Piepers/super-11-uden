package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * The Sportdeer representation of a Player containing which team season it
 * currently is playing for.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class Player extends SportdeerDomainObject {

	@JsonProperty("name")
	private final String name;
	@JsonProperty("country")
	private final String country;

	public Player(@JsonProperty("_id") Long id, @JsonProperty("name") String name,
			@JsonProperty("country") String country) {
		super(id);
		this.name = name;
		this.country = country;
	}

	public Player(JsonObject jsonObject) {
		super(jsonObject);
		this.name = jsonObject.getString("name");
		this.country = jsonObject.getString("country");
	}

	public String getName() {
		return this.name;
	}

	public String getCountry() {
		return this.country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (this.country == null ? 0 : this.country.hashCode());
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
		Player other = (Player) obj;
		if (this.country == null) {
			if (other.country != null) {
				return false;
			}
		} else if (!this.country.equals(other.country)) {
			return false;
		}
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Player [id=" + this.getId() + ", name=" + this.name + ", country=" + this.country + "]";
	}

}
