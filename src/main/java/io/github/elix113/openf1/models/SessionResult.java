package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * SessionResult
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public record SessionResult (
	@JsonProperty("dnf") Boolean dnf,
	@JsonProperty("dns") Boolean dns,
	@JsonProperty("dsq") Boolean dsq,
	@JsonProperty("driver_number") Integer driverNumber,
	@JsonProperty("duration") Object duration,
	@JsonProperty("gap_to_leader") Object gapToLeader,
	@JsonProperty("number_of_laps") Integer numberOfLaps,
	@JsonProperty("meeting_key") Integer meetingKey,
	@JsonProperty("position") Integer position,
	@JsonProperty("session_key") Integer sessionKey
) {
	public static final String URL = "session_result?";
}
