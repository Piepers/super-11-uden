package me.piepers.super11.domain;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class Team implements Jsonable {

	@Override
	public JsonObject toJson() {
		return JsonObject.mapFrom(this);
	}

}
