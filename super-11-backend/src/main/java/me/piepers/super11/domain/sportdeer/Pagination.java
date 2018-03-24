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

	@Override
	public String toString() {
		return "Pagination [total=" + this.total + ", limit=" + this.limit + ", page=" + this.page + ", pages="
				+ this.pages + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.limit == null ? 0 : this.limit.hashCode());
		result = prime * result + (this.page == null ? 0 : this.page.hashCode());
		result = prime * result + (this.pages == null ? 0 : this.pages.hashCode());
		result = prime * result + (this.total == null ? 0 : this.total.hashCode());
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
		Pagination other = (Pagination) obj;
		if (this.limit == null) {
			if (other.limit != null) {
				return false;
			}
		} else if (!this.limit.equals(other.limit)) {
			return false;
		}
		if (this.page == null) {
			if (other.page != null) {
				return false;
			}
		} else if (!this.page.equals(other.page)) {
			return false;
		}
		if (this.pages == null) {
			if (other.pages != null) {
				return false;
			}
		} else if (!this.pages.equals(other.pages)) {
			return false;
		}
		if (this.total == null) {
			if (other.total != null) {
				return false;
			}
		} else if (!this.total.equals(other.total)) {
			return false;
		}
		return true;
	}
}
