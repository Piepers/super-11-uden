package me.piepers.super11.domain.sportdeer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * A Stage is a relatively complex object that contains the standings of a
 * particular league with all the details of that standing (like scored goals
 * information, amount of wins, losses, draws etc.). It contains another object
 * "Standing", which represents all the teams and their position in the league.
 *
 * @author Bas Piepers
 *
 */
@DataObject
public class Stage extends SportdeerDomainObject {

	@JsonProperty("name")
	private final String name;
	@JsonUnwrapped
	private final CountryId countryId;
	@JsonUnwrapped
	private final LeagueId leagueId;
	@JsonUnwrapped
	private final SeasonId seasonId;
	@JsonProperty("sort_strategy")
	private final List<Integer> sortStrategy;
	@JsonProperty("standing")
	private final List<StandingItem> standing;

	public Stage(JsonObject jsonObject) {
		super(jsonObject);
		this.name = jsonObject.getString("name");
		this.countryId = CountryId.of(jsonObject.getLong("id_country"));
		this.leagueId = LeagueId.of(jsonObject.getLong("id_league"));
		this.seasonId = SeasonId.of(jsonObject.getLong("id_season"));
		this.sortStrategy = new ArrayList<Integer>(jsonObject.getJsonArray("sort_strategy").getList());
		this.standing = jsonObject.getJsonArray("standing").stream().map(obj -> new StandingItem((JsonObject) obj))
				.collect(Collectors.toList());

	}

	public Stage(@JsonProperty("_id") Long id, @JsonProperty("name") String name,
			@JsonProperty("id_country") Long countryId, @JsonProperty("id_league") Long leagueId,
			@JsonProperty("id_season") Long seasonId, @JsonProperty("sort_strategy") List<Integer> sortStrategy,
			@JsonProperty("standing") List<StandingItem> standing) {
		super(id);
		this.name = name;
		this.countryId = CountryId.of(countryId);
		this.leagueId = LeagueId.of(leagueId);
		this.seasonId = SeasonId.of(seasonId);
		this.sortStrategy = sortStrategy;
		this.standing = standing;
	}

	public String getName() {
		return this.name;
	}

	public CountryId getCountryId() {
		return this.countryId;
	}

	public LeagueId getLeagueId() {
		return this.leagueId;
	}

	public SeasonId getSeasonId() {
		return this.seasonId;
	}

	public List<Integer> getSortStrategy() {
		return this.sortStrategy;
	}

	public List<StandingItem> getStanding() {
		return this.standing;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (this.countryId == null ? 0 : this.countryId.hashCode());
		result = prime * result + (this.leagueId == null ? 0 : this.leagueId.hashCode());
		result = prime * result + (this.name == null ? 0 : this.name.hashCode());
		result = prime * result + (this.seasonId == null ? 0 : this.seasonId.hashCode());
		result = prime * result + (this.sortStrategy == null ? 0 : this.sortStrategy.hashCode());
		result = prime * result + (this.standing == null ? 0 : this.standing.hashCode());
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
		Stage other = (Stage) obj;
		if (this.countryId == null) {
			if (other.countryId != null) {
				return false;
			}
		} else if (!this.countryId.equals(other.countryId)) {
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
		if (this.seasonId == null) {
			if (other.seasonId != null) {
				return false;
			}
		} else if (!this.seasonId.equals(other.seasonId)) {
			return false;
		}
		if (this.sortStrategy == null) {
			if (other.sortStrategy != null) {
				return false;
			}
		} else if (!this.sortStrategy.equals(other.sortStrategy)) {
			return false;
		}
		if (this.standing == null) {
			if (other.standing != null) {
				return false;
			}
		} else if (!this.standing.equals(other.standing)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Stage [id=" + this.getId() + ", name=" + this.name + ", countryId=" + this.countryId + ", leagueId="
				+ this.leagueId + ", seasonId=" + this.seasonId + ", sortStrategy=" + this.sortStrategy + ", standing="
				+ this.standing + "]";
	}

}
