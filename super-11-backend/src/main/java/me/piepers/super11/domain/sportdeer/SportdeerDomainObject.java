package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import me.piepers.super11.domain.JsonDomainObject;

@DataObject
public abstract class SportdeerDomainObject implements JsonDomainObject {

	@JsonProperty("_id")
	private Long id;
	
	@JsonIgnore
	protected JsonObject docs;
	
	@JsonCreator
	public SportdeerDomainObject(@JsonProperty("_id") Long id) {
		this.id = id;
	}
	
	public SportdeerDomainObject(JsonObject jsonObject) {
		this.docs = jsonObject.getJsonObject("docs");
		this.id = docs.getLong("_id");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
