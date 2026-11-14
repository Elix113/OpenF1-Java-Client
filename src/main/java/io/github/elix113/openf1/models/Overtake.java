package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;

/**
 * Overtake
 *
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public record Overtake(
    @JsonProperty("date") Instant date,
    @JsonProperty("meeting_key") Integer meetingKey,
    @JsonProperty("overtaken_driver_number") Integer overtakenDriverNumber,
    @JsonProperty("overtaking_driver_number") Integer overtakingDriverNumber,
    @JsonProperty("position") Integer position,
    @JsonProperty("session_key") Integer sessionKey
) {
    public static final String URL = "overtakes?";
}
