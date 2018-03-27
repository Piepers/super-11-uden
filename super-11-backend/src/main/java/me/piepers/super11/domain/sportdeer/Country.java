package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class Country extends SportdeerDomainObject {

	@JsonProperty("name")
	private final String name;
	@JsonProperty("square_flag")
	private final String sFlagLink;
	@JsonProperty("rectangle_flag")
	private final String rFlagLink;

	@JsonCreator
	public Country(@JsonProperty("_id") Long id, @JsonProperty("name") String name,
			@JsonProperty("square_flag") String sFlagLink, @JsonProperty("rectangle_flag") String rFlagLink) {
		super(id);
		this.name = name;
		this.sFlagLink = sFlagLink;
		this.rFlagLink = rFlagLink;
	}

	public Country(JsonObject jsonObject) {
		super(jsonObject);
		this.name = jsonObject.getString("name");
		this.sFlagLink = jsonObject.getString("square_flag");
		this.rFlagLink = jsonObject.getString("rectangle_flag");
	}

	@Override
	public String toString() {
		return "Country [id=" + this.getId() + ", name=" + this.name + ", sFlagLink=" + this.sFlagLink + ", rFlagLink="
				+ this.rFlagLink + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (this.name == null ? 0 : this.name.hashCode());
		result = prime * result + (this.rFlagLink == null ? 0 : this.rFlagLink.hashCode());
		result = prime * result + (this.sFlagLink == null ? 0 : this.sFlagLink.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Country other = (Country) obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.rFlagLink == null) {
			if (other.rFlagLink != null) {
				return false;
			}
		} else if (!this.rFlagLink.equals(other.rFlagLink)) {
			return false;
		}
		if (this.sFlagLink == null) {
			if (other.sFlagLink != null) {
				return false;
			}
		} else if (!this.sFlagLink.equals(other.sFlagLink)) {
			return false;
		}
		return true;
	}
}
