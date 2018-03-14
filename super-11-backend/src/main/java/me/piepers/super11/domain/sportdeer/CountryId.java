package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;

/**
 * Represents the country id in cases where it is referred to from another
 * domain object.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class CountryId {

	@JsonProperty("id_country")
	private final Long id;

	private CountryId(Long id) {
		this.id = id;
	}

	@JsonCreator
	public static CountryId of(@JsonProperty("id_country") Long id) {
		return new CountryId(id);
	}

	public Long getId() {
		return this.id;
	}

}
