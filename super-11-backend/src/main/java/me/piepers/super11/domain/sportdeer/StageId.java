package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;

/**
 * The stage id in cases where it is referred to from other domain object.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class StageId {
	@JsonProperty("id_stage")
	private final Long id;

	private StageId(Long id) {
		this.id = id;
	}

	@JsonCreator
	public static StageId of(@JsonProperty("id_stage") Long id) {
		return new StageId(id);
	}

	public Long getId() {
		return this.id;
	}

}
