package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Stint
 *
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public record Stint(
    @JsonProperty("compound") TireCompound compound,
    @JsonProperty("driver_number") Integer driverNumber,
    @JsonProperty("lap_end") Integer lapEnd,
    @JsonProperty("lap_start") Integer lapStart,
    @JsonProperty("meeting_key") Integer meetingKey,
    @JsonProperty("session_key") Integer sessionKey,
    @JsonProperty("stint_number") Integer stintNumber,
    @JsonProperty("tyre_age_at_start") Integer tyreAgeAtStart
) {
    public static final String URL = "stints?";
}
