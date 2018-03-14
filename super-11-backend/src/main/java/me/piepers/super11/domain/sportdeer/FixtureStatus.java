package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;

/**
 * Representation of the fixture status object that contains a name and a short
 * version of the name.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class FixtureStatus {
	@JsonProperty("fixture_status")
	private final String fixtureStatus;
	@JsonProperty("fixture_status_short")
	private final String fixtureStatusShort;

	private FixtureStatus(String fixtureStatus, String fixtureStatusShort) {
		this.fixtureStatus = fixtureStatus;
		this.fixtureStatusShort = fixtureStatusShort;
	}

	@JsonCreator
	public static FixtureStatus of(@JsonProperty("fixture_status") String fixtureStatus,
			@JsonProperty("fixture_status_short") String fixtureStatusShort) {
		return new FixtureStatus(fixtureStatus, fixtureStatusShort);
	}

}
