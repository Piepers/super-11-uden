package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;

/**
 * Season id for when it is referred to by other domain objects.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class SeasonId {
	@JsonProperty("id_season")
	private final Long id;

	private SeasonId(Long id) {
		this.id = id;
	}

	@JsonCreator
	public static SeasonId of(@JsonProperty("id_season") Long id) {
		return new SeasonId(id);
	}

	public Long getId() {
		return this.id;
	}

}
