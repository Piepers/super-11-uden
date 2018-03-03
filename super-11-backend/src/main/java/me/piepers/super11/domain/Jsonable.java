package me.piepers.super11.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.vertx.core.json.JsonObject;

/**
 * Deserialize to a {@link JsonObject}
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public interface Jsonable {

	JsonObject toJson();
}
