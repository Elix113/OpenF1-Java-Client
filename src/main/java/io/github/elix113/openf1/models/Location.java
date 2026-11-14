package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;

/**
 * Location
 *
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public record Location(
    @JsonProperty("date") Instant date,
    @JsonProperty("driver_number") Integer driverNumber,
    @JsonProperty("meeting_key") Integer meetingKey,
    @JsonProperty("session_key") Integer sessionKey,
    @JsonProperty("x") Integer x,
    @JsonProperty("y") Integer y,
    @JsonProperty("z") Integer z
) {
    public static final String URL = "location?";
}
