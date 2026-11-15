package io.github.elix113.openf1.filter.filters;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.BaseFilter;
import io.github.elix113.openf1.filter.FilterCondition;
import io.github.elix113.openf1.filter.FilterConnector;
import io.github.elix113.openf1.models.ChampionshipTeam;

/**
 * @see <a href="https://openf1.org/docs/#teams-championship-beta">openf1.org</a>
 */
public class ChampionshipTeamFilter extends BaseFilter {

    public static ChampionshipTeamFilter create() {
        return new ChampionshipTeamFilter();
    }

    public FilterCondition<ChampionshipTeamFilter, Integer> meetingKey() {
        return new FilterCondition<>(this, "meeting_key");
    }

    public FilterCondition<ChampionshipTeamFilter, Double> pointsCurrent() {
        return new FilterCondition<>(this, "points_current");
    }

    public FilterCondition<ChampionshipTeamFilter, Double> pointsStart() {
        return new FilterCondition<>(this, "points_start");
    }

    public FilterCondition<ChampionshipTeamFilter, Integer> positionCurrent() {
        return new FilterCondition<>(this, "position_current");
    }

    public FilterCondition<ChampionshipTeamFilter, Integer> positionStart() {
        return new FilterCondition<>(this, "position_start");
    }

    public FilterCondition<ChampionshipTeamFilter, Integer> sessionKey() {
        return new FilterCondition<>(this, "session_key");
    }

    public FilterCondition<ChampionshipTeamFilter, String> teamName() {
        return new FilterCondition<>(this, "team_name");
    }

    public FilterConnector<ChampionshipTeamFilter> latestSession() {
        addParam("session_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    public FilterConnector<ChampionshipTeamFilter> latestMeeting() {
        addParam("meeting_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    @Override
    public String getFinalUrl() {
        return OpenF1Client.BASE_URL + ChampionshipTeam.URL + super.toString();
    }
}
