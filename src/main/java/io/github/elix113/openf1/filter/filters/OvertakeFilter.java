package io.github.elix113.openf1.filter.filters;

import java.time.Instant;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.BaseFilter;
import io.github.elix113.openf1.filter.FilterCondition;
import io.github.elix113.openf1.filter.FilterConnector;
import io.github.elix113.openf1.models.Overtake;

public class OvertakeFilter extends BaseFilter {

    public static OvertakeFilter create() {
        return new OvertakeFilter();
    }

    public FilterCondition<OvertakeFilter, Instant> date() {
        return new FilterCondition<>(this, "date");
    }

    public FilterCondition<OvertakeFilter, Integer> meetingKey() {
        return new FilterCondition<>(this, "meeting_key");
    }

    public FilterCondition<OvertakeFilter, Integer> overtakenDriverNumber() {
        return new FilterCondition<>(this, "overtaken_driver_number");
    }

    public FilterCondition<OvertakeFilter, Integer> overtakingDriverNumber() {
        return new FilterCondition<>(this, "overtaking_driver_number");
    }

    public FilterCondition<OvertakeFilter, Integer> position() {
        return new FilterCondition<>(this, "position");
    }

    public FilterCondition<OvertakeFilter, Integer> sessionKey() {
        return new FilterCondition<>(this, "session_key");
    }

    public FilterConnector<OvertakeFilter> latestSession() {
        addParam("session_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    public FilterConnector<OvertakeFilter> latestMeeting() {
        addParam("meeting_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    @Override
    public String getFinalUrl() {
        return OpenF1Client.BASE_URL + Overtake.URL + super.toString();
    }
}
