package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * Representation of the fixture status object that contains a name and a short
 * version of the name.
 *
 * @author Bas Piepers
 *
 */
@DataObject
public class FixtureStatus {
	@JsonProperty("fixture_status")
	private final String fixtureStatus;
	@JsonProperty("fixture_status_short")
	private final String fixtureStatusShort;

	public FixtureStatus(JsonObject jsonObject) {
		this.fixtureStatus = jsonObject.getString("fixture_status");
		this.fixtureStatusShort = jsonObject.getString("fixture_status_short");

	}

	private FixtureStatus(String fixtureStatus, String fixtureStatusShort) {
		this.fixtureStatus = fixtureStatus;
		this.fixtureStatusShort = fixtureStatusShort;
	}

	@JsonCreator
	public static FixtureStatus of(@JsonProperty("fixture_status") String fixtureStatus,
			@JsonProperty("fixture_status_short") String fixtureStatusShort) {
		return new FixtureStatus(fixtureStatus, fixtureStatusShort);
	}

	public String getFixtureStatus() {
		return this.fixtureStatus;
	}

	public String getFixtureStatusShort() {
		return this.fixtureStatusShort;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.fixtureStatus == null ? 0 : this.fixtureStatus.hashCode());
		result = prime * result + (this.fixtureStatusShort == null ? 0 : this.fixtureStatusShort.hashCode());
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
		FixtureStatus other = (FixtureStatus) obj;
		if (this.fixtureStatus == null) {
			if (other.fixtureStatus != null) {
				return false;
			}
		} else if (!this.fixtureStatus.equals(other.fixtureStatus)) {
			return false;
		}
		if (this.fixtureStatusShort == null) {
			if (other.fixtureStatusShort != null) {
				return false;
			}
		} else if (!this.fixtureStatusShort.equals(other.fixtureStatusShort)) {
			return false;
		}
		return true;
	}

}
