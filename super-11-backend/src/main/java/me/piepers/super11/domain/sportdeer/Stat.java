package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import me.piepers.super11.domain.JsonDomainObject;

/**
 * Statistics representation of the Sportdeer API containing detailed
 * information which type of events have occurred during games.
 *
 * It has a different formatting than the typical domain objects hence doesn't
 * extend {@link SportdeerDomainObject}
 *
 * @author Bas Pieeprs (bas@piepers.me)
 *
 */
@DataObject
public class Stat implements JsonDomainObject {

	@JsonProperty("_id")
	private final StatType statType;
	@JsonProperty("counter")
	private final Integer counter;

	public Stat(JsonObject jsonObject) {
		this.statType = new StatType(jsonObject.getJsonObject("_id"));
		this.counter = jsonObject.getInteger("counter");
	}

	@JsonCreator
	public static Stat of(@JsonProperty("_id") StatType statType, @JsonProperty("counter") Integer counter) {
		return new Stat(statType, counter);
	}

	private Stat(StatType statType, Integer counter) {
		this.statType = statType;
		this.counter = counter;
	}

	public StatType getStatType() {
		return this.statType;
	}

	public Integer getCounter() {
		return this.counter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.counter == null ? 0 : this.counter.hashCode());
		result = prime * result + (this.statType == null ? 0 : this.statType.hashCode());
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
		Stat other = (Stat) obj;
		if (this.counter == null) {
			if (other.counter != null) {
				return false;
			}
		} else if (!this.counter.equals(other.counter)) {
			return false;
		}
		if (this.statType == null) {
			if (other.statType != null) {
				return false;
			}
		} else if (!this.statType.equals(other.statType)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Stat [statType=" + this.statType + ", counter=" + this.counter + "]";
	}

}
