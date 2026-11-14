package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.List;

/**
 * Lap
 *
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public record Lap(
    @JsonProperty("date_start") Instant dateStart,
    @JsonProperty("driver_number") Integer driverNumber,
    @JsonProperty("duration_sector_1") Double durationSector1,
    @JsonProperty("duration_sector_2") Double durationSector2,
    @JsonProperty("duration_sector_3") Double durationSector3,
    @JsonProperty("i1_speed") Integer i1Speed,
    @JsonProperty("i2_speed") Integer i2Speed,
    @JsonProperty("is_pit_out_lap") Boolean isPitOutLap,
    @JsonProperty("lap_duration") Double lapDuration,
    @JsonProperty("lap_number") Integer lapNumber,
    @JsonProperty("meeting_key") Integer meetingKey,
    @JsonProperty("segments_sector_1") List<Integer> segmentsSector1,
    @JsonProperty("segments_sector_2") List<Integer> segmentsSector2,
    @JsonProperty("segments_sector_3") List<Integer> segmentsSector3,
    @JsonProperty("session_key") Integer sessionKey,
    @JsonProperty("st_speed") Integer stSpeed
) {
    public static final String URL = "laps?";
}
