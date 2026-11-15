package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

/**
 * Session
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public record Session(
	@JsonProperty("circuit_key") Integer circuitKey,
	@JsonProperty("circuit_short_name") String circuitShortName,
	@JsonProperty("country_code") String countryCode,
	@JsonProperty("country_key") Integer countryKey,
	@JsonProperty("country_name") String countryName,
	@JsonProperty("date_end") Instant dateEnd,
	@JsonProperty("date_start") Instant dateStart,
	@JsonProperty("gmt_offset") String gmtOffset,
	@JsonProperty("is_cancelled") Boolean isCancelled,
	@JsonProperty("location") String location,
	@JsonProperty("meeting_key") Integer meetingKey,
	@JsonProperty("session_key") Integer sessionKey,
	@JsonProperty("session_name") SessionName sessionName,
	@JsonProperty("session_type") SessionType sessionType,
	@JsonProperty("year") Integer year
) {
	public static final String URL = "sessions?";
}
