package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * A league represents a competition in one of the countries that are supported by the Sportdeer API or a league of a
 * cup like the Champions League.
 */
@DataObject
public class League extends SportdeerDomainObject {
    @JsonProperty("name")
    private String name;
    @JsonUnwrapped
    private CountryId countryId;
    @JsonProperty("logo_svg")
    private String logoLink;

    public League(@JsonProperty("_id") Long id, @JsonProperty("name") String name, @JsonProperty("id_country") CountryId countryId, @JsonProperty("logo_svg") String logoLink) {
        super(id);
        this.name = name;
        this.countryId = countryId;
        this.logoLink = logoLink;
    }

    public League(JsonObject jsonObject) {
        super(jsonObject);
        this.countryId = CountryId.of(jsonObject.getLong("id_country"));
        this.name = jsonObject.getString("name");
        this.logoLink = jsonObject.getString("logo_svg");
    }

    public String getName() {
        return name;
    }

    public CountryId getCountryId() {
        return countryId;
    }

    public String getLogoLink() {
        return logoLink;
    }

    @Override
    public String toString() {
        return "League{id=" + getId() +
                ", name='" + name + '\'' +
                ", countryId=" + countryId +
                ", logoLink='" + logoLink + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        League league = (League) o;

        if (!name.equals(league.name)) return false;
        if (!countryId.equals(league.countryId)) return false;
        return logoLink.equals(league.logoLink);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + countryId.hashCode();
        result = 31 * result + logoLink.hashCode();
        return result;
    }
}
