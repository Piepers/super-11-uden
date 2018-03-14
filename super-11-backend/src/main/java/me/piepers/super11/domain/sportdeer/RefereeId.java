package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;

@DataObject
public class RefereeId {
	@JsonProperty("id_referee")
	private final Long id;

	private RefereeId(Long id) {
		this.id = id;
	}

	@JsonCreator
	public static RefereeId of(@JsonProperty("id_referee") Long id) {
		return new RefereeId(id);
	}

	public Long getId() {
		return this.id;
	}

}
