package me.piepers.super11.domain.sportdeer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

/**
 * Convenient class that contains start- and end-times for the first and second
 * half. Used in various other domain objects.
 *
 * @author Bas Piepers (bas@piepers.me)
 *
 */
@DataObject
public class GameTimings {
	// Formatted as yyyy-MM-ddTHH:mm:ss.SSSZ
	@JsonProperty("game_started_at")
	private final String gameStart;
	@JsonProperty("game_ended_at")
	private final String gameEnd;
	@JsonProperty("first_half_ended_at")
	private final String firstHalfEnd;
	@JsonProperty("second_half_ended_at")
	private final String secondHalfEnd;
	@JsonProperty("second_half_started_at")
	private final String secondHalfStart;

	public GameTimings(JsonObject jsonObject) {
		this.gameStart = jsonObject.getString("game_start_at");
		this.gameEnd = jsonObject.getString("game_end_at");
		this.firstHalfEnd = jsonObject.getString("first_half_ended_at");
		this.secondHalfEnd = jsonObject.getString("second_half_ended_at");
		this.secondHalfStart = jsonObject.getString("second_half_started_at");
	}

	private GameTimings(String gameStart, String gameEnd, String firstHalfEnd, String secondHalfStart,
			String secondHalfEnd) {
		this.gameStart = gameStart;
		this.gameEnd = gameEnd;
		this.firstHalfEnd = firstHalfEnd;
		this.secondHalfEnd = secondHalfEnd;
		this.secondHalfStart = secondHalfStart;
	}

	@JsonCreator
	public static GameTimings of(@JsonProperty("game_started_at") String gameStart,
			@JsonProperty("game_ended_at") String gameEnd, @JsonProperty("first_half_ended_at") String firstHalfEnd,
			@JsonProperty("second_half_started_at") String secondHalfStart,
			@JsonProperty("second_half_ended_at") String secondHalfEnd) {
		return new GameTimings(gameStart, gameEnd, firstHalfEnd, secondHalfStart, secondHalfEnd);
	}

	public String getGameStart() {
		return this.gameStart;
	}

	public String getGameEnd() {
		return this.gameEnd;
	}

	public String getFirstHalfEnd() {
		return this.firstHalfEnd;
	}

	public String getSecondHalfEnd() {
		return this.secondHalfEnd;
	}

	public String getSecondHalfStart() {
		return this.secondHalfStart;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.firstHalfEnd == null ? 0 : this.firstHalfEnd.hashCode());
		result = prime * result + (this.gameEnd == null ? 0 : this.gameEnd.hashCode());
		result = prime * result + (this.gameStart == null ? 0 : this.gameStart.hashCode());
		result = prime * result + (this.secondHalfEnd == null ? 0 : this.secondHalfEnd.hashCode());
		result = prime * result + (this.secondHalfStart == null ? 0 : this.secondHalfStart.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		GameTimings other = (GameTimings) obj;
		if (this.firstHalfEnd == null) {
			if (other.firstHalfEnd != null) {
				return false;
			}
		} else if (!this.firstHalfEnd.equals(other.firstHalfEnd)) {
			return false;
		}
		if (this.gameEnd == null) {
			if (other.gameEnd != null) {
				return false;
			}
		} else if (!this.gameEnd.equals(other.gameEnd)) {
			return false;
		}
		if (this.gameStart == null) {
			if (other.gameStart != null) {
				return false;
			}
		} else if (!this.gameStart.equals(other.gameStart)) {
			return false;
		}
		if (this.secondHalfEnd == null) {
			if (other.secondHalfEnd != null) {
				return false;
			}
		} else if (!this.secondHalfEnd.equals(other.secondHalfEnd)) {
			return false;
		}
		if (this.secondHalfStart == null) {
			if (other.secondHalfStart != null) {
				return false;
			}
		} else if (!this.secondHalfStart.equals(other.secondHalfStart)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "GameTimings [gameStart=" + this.gameStart + ", gameEnd=" + this.gameEnd + ", firstHalfEnd="
				+ this.firstHalfEnd + ", secondHalfEnd=" + this.secondHalfEnd + ", secondHalfStart="
				+ this.secondHalfStart + "]";
	}

}
