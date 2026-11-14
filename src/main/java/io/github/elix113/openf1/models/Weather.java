package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;

/**
 * Weather
 *
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public record Weather(
    @JsonProperty("air_temperature") Double airTemperature,
    @JsonProperty("date") Instant date,
    @JsonProperty("humidity") Double humidity,
    @JsonProperty("meeting_key") Integer meetingKey,
    @JsonProperty("pressure") Double pressure,
    @JsonProperty("rainfall") Integer rainfall,
    @JsonProperty("session_key") Integer sessionKey,
    @JsonProperty("track_temperature") Double trackTemperature,
    @JsonProperty("wind_direction") Integer windDirection,
    @JsonProperty("wind_speed") Double windSpeed
) {
    public static final String URL = "weather?";
}
