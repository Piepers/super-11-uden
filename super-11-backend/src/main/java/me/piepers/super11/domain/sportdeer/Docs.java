package me.piepers.super11.domain.sportdeer;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The wrapper that always comes with a response from the SportDeer API. It
 * contains a list of data that is of a particular type and optionally
 * Pagination information.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@JsonInclude(Include.NON_NULL)
public class Docs<T> {

	@JsonProperty("docs")
	private final List<T> data;
	@JsonProperty("pagination")
	private final Pagination pagination;

	@JsonCreator
	public Docs(@JsonProperty("docs") List<T> data, @JsonProperty("pagination") Pagination pagination) {
		this.data = data;
		this.pagination = pagination;
	}

	public List<T> getData() {
		return this.data;
	}

	public Pagination getPagination() {
		return this.pagination;
	}
}
