package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;

/**
 * Interval
 *
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public record Interval(
    @JsonProperty("date") Instant date,
    @JsonProperty("driver_number") Integer driverNumber,
    @JsonProperty("gap_to_leader") Object gapToLeader,
    @JsonProperty("interval") Object interval,
    @JsonProperty("meeting_key") Integer meetingKey,
    @JsonProperty("session_key") Integer sessionKey
) {
    public static final String URL = "intervals?";
}
