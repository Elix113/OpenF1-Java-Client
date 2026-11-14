package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ChampionshipDriver
 *
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public record ChampionshipDriver(
    @JsonProperty("driver_number") Integer driverNumber,
    @JsonProperty("meeting_key") Integer meetingKey,
    @JsonProperty("points_current") Double pointsCurrent,
    @JsonProperty("points_start") Double pointsStart,
    @JsonProperty("position_current") Integer positionCurrent,
    @JsonProperty("position_start") Integer positionStart,
    @JsonProperty("session_key") Integer sessionKey
) {
    public static final String URL = "championship_drivers?";
}
