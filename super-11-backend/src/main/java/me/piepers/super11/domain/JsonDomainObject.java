package me.piepers.super11.domain;

import io.vertx.core.json.JsonObject;

public interface JsonDomainObject {

	default JsonObject toJson() {
		return JsonObject.mapFrom(this);
	}

}
