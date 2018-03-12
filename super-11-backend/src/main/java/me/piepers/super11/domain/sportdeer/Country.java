package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import me.piepers.super11.domain.JsonDomainObject;

@DataObject
public class Country extends SportdeerDomainObject {
	
	@JsonProperty("name")
	private String name;
	@JsonProperty("square_flag")
	private String sFlagLink;
	@JsonProperty("rectangle_flag")
	private String rFlagLink;
	
	@JsonCreator
	public Country(@JsonProperty("_id") Long id, @JsonProperty("name") String name, @JsonProperty("square_flag") String sFlagLink, @JsonProperty("rectangle_flag") String rFlagLink) {
		super(id);
		this.name = name;
		this.sFlagLink = sFlagLink;
		this.rFlagLink = rFlagLink;
	}

	public Country(JsonObject jsonObject) {
		super(jsonObject);
		this.name = docs.getString("name");
		this.sFlagLink = docs.getString("square_flag");
		this.rFlagLink = docs.getString("rectangle_flag");		
	}

	
	@Override
	public String toString() {
		return "Country [id=" + getId() + ", name=" + name + ", sFlagLink=" + sFlagLink + ", rFlagLink=" + rFlagLink + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rFlagLink == null) ? 0 : rFlagLink.hashCode());
		result = prime * result + ((sFlagLink == null) ? 0 : sFlagLink.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rFlagLink == null) {
			if (other.rFlagLink != null)
				return false;
		} else if (!rFlagLink.equals(other.rFlagLink))
			return false;
		if (sFlagLink == null) {
			if (other.sFlagLink != null)
				return false;
		} else if (!sFlagLink.equals(other.sFlagLink))
			return false;
		return true;
	}	
}
