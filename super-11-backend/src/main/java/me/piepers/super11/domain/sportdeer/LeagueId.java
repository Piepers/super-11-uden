package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;

/**
 * Represents the league id in cases where it is referred to from another
 * object.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class LeagueId {
	@JsonProperty("id_league")
	private final Long id;

	private LeagueId(Long id) {
		this.id = id;
	}

	@JsonCreator
	public static LeagueId of(@JsonProperty("id_league") Long id) {
		return new LeagueId(id);
	}

	public Long getId() {
		return this.id;
	}

}
