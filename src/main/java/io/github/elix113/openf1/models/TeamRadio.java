package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;

/**
 * TeamRadio
 *
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public record TeamRadio(
    @JsonProperty("date") Instant date,
    @JsonProperty("driver_number") Integer driverNumber,
    @JsonProperty("meeting_key") Integer meetingKey,
    @JsonProperty("recording_url") String recordingUrl,
    @JsonProperty("session_key") Integer sessionKey
) {
    public static final String URL = "team_radio?";
}
