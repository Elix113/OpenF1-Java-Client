package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;

/**
 * Meeting
 *
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public record Meeting(
    @JsonProperty("circuit_key") Integer circuitKey,
    @JsonProperty("circuit_image") String circuitImage,
    @JsonProperty("circuit_info_url") String circuitInfoUrl,
    @JsonProperty("circuit_short_name") String circuitShortName,
    @JsonProperty("circuit_type") String circuitType,
    @JsonProperty("country_code") String countryCode,
    @JsonProperty("country_flag") String countryFlag,
    @JsonProperty("country_key") Integer countryKey,
    @JsonProperty("country_name") String countryName,
    @JsonProperty("date_end") Instant dateEnd,
    @JsonProperty("date_start") Instant dateStart,
    @JsonProperty("gmt_offset") String gmtOffset,
    @JsonProperty("is_cancelled") Boolean isCancelled,
    @JsonProperty("location") String location,
    @JsonProperty("meeting_key") Integer meetingKey,
    @JsonProperty("meeting_name") String meetingName,
    @JsonProperty("meeting_official_name") String meetingOfficialName,
    @JsonProperty("year") Integer year
) {
    public static final String URL = "meetings?";
}
