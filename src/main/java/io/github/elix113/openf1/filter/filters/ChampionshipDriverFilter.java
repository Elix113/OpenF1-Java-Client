package io.github.elix113.openf1.filter.filters;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.BaseFilter;
import io.github.elix113.openf1.filter.FilterCondition;
import io.github.elix113.openf1.filter.FilterConnector;
import io.github.elix113.openf1.models.ChampionshipDriver;

public class ChampionshipDriverFilter extends BaseFilter {

    public static ChampionshipDriverFilter create() {
        return new ChampionshipDriverFilter();
    }

    public FilterCondition<ChampionshipDriverFilter, Integer> driverNumber() {
        return new FilterCondition<>(this, "driver_number");
    }

    public FilterCondition<ChampionshipDriverFilter, Integer> meetingKey() {
        return new FilterCondition<>(this, "meeting_key");
    }

    public FilterCondition<ChampionshipDriverFilter, Double> pointsCurrent() {
        return new FilterCondition<>(this, "points_current");
    }

    public FilterCondition<ChampionshipDriverFilter, Double> pointsStart() {
        return new FilterCondition<>(this, "points_start");
    }

    public FilterCondition<ChampionshipDriverFilter, Integer> positionCurrent() {
        return new FilterCondition<>(this, "position_current");
    }

    public FilterCondition<ChampionshipDriverFilter, Integer> positionStart() {
        return new FilterCondition<>(this, "position_start");
    }

    public FilterCondition<ChampionshipDriverFilter, Integer> sessionKey() {
        return new FilterCondition<>(this, "session_key");
    }

    public FilterConnector<ChampionshipDriverFilter> latestSession() {
        addParam("session_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    public FilterConnector<ChampionshipDriverFilter> latestMeeting() {
        addParam("meeting_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    @Override
    public String getFinalUrl() {
        return OpenF1Client.BASE_URL + ChampionshipDriver.URL + super.toString();
    }
}
