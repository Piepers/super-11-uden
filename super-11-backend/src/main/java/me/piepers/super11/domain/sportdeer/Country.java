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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Country country = (Country) o;

        if (!name.equals(country.name)) return false;
        if (!sFlagLink.equals(country.sFlagLink)) return false;
        return rFlagLink.equals(country.rFlagLink);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + sFlagLink.hashCode();
        result = 31 * result + rFlagLink.hashCode();
        return result;
    }
}
