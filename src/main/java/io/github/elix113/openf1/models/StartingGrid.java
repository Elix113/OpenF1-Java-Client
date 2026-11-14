package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * StartingGrid
 *
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public record StartingGrid(
    @JsonProperty("driver_number") Integer driverNumber,
    @JsonProperty("lap_duration") Double lapDuration,
    @JsonProperty("meeting_key") Integer meetingKey,
    @JsonProperty("position") Integer position,
    @JsonProperty("session_key") Integer sessionKey
) {
    public static final String URL = "starting_grid?";
}
