package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

/**
 * RaceControl
 *
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public record RaceControl(
    @JsonProperty("category") RaceControlCategory category,
    @JsonProperty("date") Instant date,
    @JsonProperty("driver_number") Integer driverNumber,
    @JsonProperty("flag") Flag flag,
    @JsonProperty("lap_number") Integer lapNumber,
    @JsonProperty("meeting_key") Integer meetingKey,
    @JsonProperty("message") String message,
    @JsonProperty("qualifying_phase") Integer qualifyingPhase,
    @JsonProperty("scope") RaceControlScope scope,
    @JsonProperty("sector") Integer sector,
    @JsonProperty("session_key") Integer sessionKey
) {
    public static final String URL = "race_control?";
}
