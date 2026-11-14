package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;

/**
 * Pit
 *
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public record Pit(
    @JsonProperty("date") Instant date,
    @JsonProperty("driver_number") Integer driverNumber,
    @JsonProperty("lane_duration") Double laneDuration,
    @JsonProperty("lap_number") Integer lapNumber,
    @JsonProperty("meeting_key") Integer meetingKey,
    @JsonProperty("session_key") Integer sessionKey,
    @JsonProperty("stop_duration") Double stopDuration
) {
    public static final String URL = "pit?";
}
