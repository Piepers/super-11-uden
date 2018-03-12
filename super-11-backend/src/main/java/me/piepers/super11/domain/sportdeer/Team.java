package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import me.piepers.super11.domain.JsonDomainObject;

/**
 * The domain object of the SportDeer Team object. 
 * 
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class Team extends SportdeerDomainObject {

	@JsonProperty("name")
	private String name;
	
	@JsonCreator
	public Team(@JsonProperty("_id") Long id, @JsonProperty("name") String name) {
		super(id);		
		this.name = name;
	}
	
	public Team(JsonObject jsonObject) {
		super(jsonObject);
		this.name = docs.getString("name");
	}	
	
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Team [id=" + getId() + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Team other = (Team) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
