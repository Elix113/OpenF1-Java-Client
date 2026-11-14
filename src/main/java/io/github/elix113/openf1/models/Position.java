package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;

/**
 * Position
 *
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public record Position(
    @JsonProperty("date") Instant date,
    @JsonProperty("driver_number") Integer driverNumber,
    @JsonProperty("meeting_key") Integer meetingKey,
    @JsonProperty("position") Integer position,
    @JsonProperty("session_key") Integer sessionKey
) {
    public static final String URL = "position?";
}
