package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ChampionshipTeam
 *
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public record ChampionshipTeam (
    @JsonProperty("meeting_key") Integer meetingKey,
    @JsonProperty("points_current") Double pointsCurrent,
    @JsonProperty("points_start") Double pointsStart,
    @JsonProperty("position_current") Integer positionCurrent,
    @JsonProperty("position_start") Integer positionStart,
    @JsonProperty("session_key") Integer sessionKey,
    @JsonProperty("team_name") String teamName
) {
    public static final String URL = "championship_teams?";
}
