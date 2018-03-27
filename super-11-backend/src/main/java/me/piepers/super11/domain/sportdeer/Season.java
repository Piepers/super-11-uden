package me.piepers.super11.domain.sportdeer;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * The Seaon object from the Sportdeer API contains the name, years, country and
 * league of the season.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class Season extends SportdeerDomainObject {
	@JsonProperty("name")
	private final String name;
	// Years have the format yyyy/yyyy (e.g. 2017/2018)
	@JsonProperty("years")
	private final String years;
	@JsonProperty("id_country")
	private final Long countryId;
	@JsonProperty("id_league")
	private final Long leagueId;
	@JsonProperty("is_last_season")
	private final boolean lastSeason;

	@JsonCreator
	public Season(@JsonProperty("_id") Long id, @JsonProperty("years") String years, @JsonProperty("name") String name,
			@JsonProperty("id_country") Long countryId, @JsonProperty("id_league") Long leagueId,
			@JsonProperty("is_last_season") boolean lastSeason) {
		super(id);
		this.years = years;
		this.name = name;
		this.countryId = countryId;
		this.leagueId = leagueId;
		this.lastSeason = lastSeason;
	}

	public Season(JsonObject jsonObject) {
		super(jsonObject);
		this.years = jsonObject.getString("years");
		this.name = jsonObject.getString("name");
		this.countryId = jsonObject.getLong("id_country");
		this.leagueId = jsonObject.getLong("id_league");
		this.lastSeason = Objects.nonNull(jsonObject.getBoolean("is_last_season"))
				? jsonObject.getBoolean("is_last_season")
				: false;
	}

	public String getYears() {
		return this.years;
	}

	public Long getCountryId() {
		return this.countryId;
	}

	public Long getLeagueId() {
		return this.leagueId;
	}

	public String getName() {
		return this.name;
	}

	public boolean isLastSeason() {
		return this.lastSeason;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (this.countryId == null ? 0 : this.countryId.hashCode());
		result = prime * result + (this.lastSeason ? 1231 : 1237);
		result = prime * result + (this.leagueId == null ? 0 : this.leagueId.hashCode());
		result = prime * result + (this.name == null ? 0 : this.name.hashCode());
		result = prime * result + (this.years == null ? 0 : this.years.hashCode());
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
		Season other = (Season) obj;
		if (this.countryId == null) {
			if (other.countryId != null) {
				return false;
			}
		} else if (!this.countryId.equals(other.countryId)) {
			return false;
		}
		if (this.lastSeason != other.lastSeason) {
			return false;
		}
		if (this.leagueId == null) {
			if (other.leagueId != null) {
				return false;
			}
		} else if (!this.leagueId.equals(other.leagueId)) {
			return false;
		}
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.years == null) {
			if (other.years != null) {
				return false;
			}
		} else if (!this.years.equals(other.years)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Season [id=" + this.getId() + ", name=" + this.name + ", years=" + this.years + ", countryId="
				+ this.countryId + ", leagueId=" + this.leagueId + ", lastSeason=" + this.lastSeason + "]";
	}

}
