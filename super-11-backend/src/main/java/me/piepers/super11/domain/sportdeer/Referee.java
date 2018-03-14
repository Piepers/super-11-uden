package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import io.vertx.codegen.annotations.DataObject;

/**
 * The referee object containing the unwrapped id and the name.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class Referee {
	@JsonProperty("referee_id")
	@JsonUnwrapped
	private final RefereeId id;
	@JsonProperty("referee_name")
	private final String name;

	private Referee(RefereeId id, String name) {
		this.id = id;
		this.name = name;
	}

	@JsonCreator
	public static Referee of(@JsonProperty("referee_id") RefereeId id, @JsonProperty("referee_name") String name) {
		return new Referee(id, name);
	}
}
