package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * The referee object containing the unwrapped id and the name.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class Referee {
	@JsonUnwrapped
	private final RefereeId id;
	@JsonProperty("referee_name")
	private final String name;

	public Referee(JsonObject jsonObject) {
		this.id = RefereeId.of(jsonObject.getLong("referee_id"));
		this.name = jsonObject.getString("referee_name");
	}

	private Referee(RefereeId id, String name) {
		this.id = id;
		this.name = name;
	}

	@JsonCreator
	public static Referee of(@JsonProperty("referee_id") RefereeId id, @JsonProperty("referee_name") String name) {
		return new Referee(id, name);
	}

	public RefereeId getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.id == null ? 0 : this.id.hashCode());
		result = prime * result + (this.name == null ? 0 : this.name.hashCode());
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
		Referee other = (Referee) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
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

}
