package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * Represents the part of the json document that has information about
 * pagination. May not be present.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class Pagination {
	@JsonProperty("total")
	private final Integer total;
	@JsonProperty("limit")
	private final Integer limit;
	@JsonProperty("page")
	private final Integer page;
	@JsonProperty("pages")
	private final Integer pages;

	public Pagination(JsonObject jsonObject) {
		this.total = jsonObject.getInteger("total");
		this.limit = jsonObject.getInteger("limit");
		this.page = jsonObject.getInteger("page");
		this.pages = jsonObject.getInteger("pages");
	}

	@JsonCreator
	public Pagination(@JsonProperty("total") Integer total, @JsonProperty("limit") Integer limit,
			@JsonProperty("page") Integer page, @JsonProperty("pages") Integer pages) {
		this.total = total;
		this.limit = limit;
		this.page = page;
		this.pages = pages;
	}

	public Integer getTotal() {
		return this.total;
	}

	public Integer getLimit() {
		return this.limit;
	}

	public Integer getPage() {
		return this.page;
	}

	public Integer getPages() {
		return this.pages;
	}
}
