package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

/**
 * CarData
 *
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */

public record CarData (
    @JsonProperty("brake") Integer brake,
    @JsonProperty("date") Instant date,
    @JsonProperty("driver_number") Integer driverNumber,
    @JsonProperty("drs") Integer drs,
    @JsonProperty("meeting_key") Integer meetingKey,
    @JsonProperty("n_gear") Integer nGear,
    @JsonProperty("rpm") Integer rpm,
    @JsonProperty("session_key") Integer sessionKey,
    @JsonProperty("speed") Integer speed,
    @JsonProperty("throttle") Integer throttle
) {
    public static final String URL = "car_data?";
}
