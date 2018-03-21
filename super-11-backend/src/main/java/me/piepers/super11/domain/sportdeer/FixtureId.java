package me.piepers.super11.domain.sportdeer;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the id to the {@link Fixture} domain object used in several other domain objects to refer to it.
 *
 * Created by Bas Piepers (bas@piepers.me)
 */
@DataObject
public class FixtureId {
    @JsonProperty("id_fixture")
    private final Long id;

    private FixtureId(Long id) {
        this.id = id;
    }
    public FixtureId(JsonObject jsonObject) {
        this.id = jsonObject.getLong("id_fixture");
    }

    @JsonCreator
    public static FixtureId of(@JsonProperty("id_fixture") Long id) {
        return new FixtureId(id);
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FixtureId fixtureId = (FixtureId) o;

        return id.equals(fixtureId.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
