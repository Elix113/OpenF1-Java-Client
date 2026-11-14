package io.github.elix113.openf1.filter.filters;

import java.time.Instant;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.BaseFilter;
import io.github.elix113.openf1.models.Position;

public class PositionFilter extends BaseFilter {

    public static PositionFilter create() {
        return new PositionFilter();
    }

    public FilterCondition<PositionFilter, Instant> date() {
        return new FilterCondition<>(this, "date");
    }

    public FilterCondition<PositionFilter, Integer> driverNumber() {
        return new FilterCondition<>(this, "driver_number");
    }

    public FilterCondition<PositionFilter, Integer> meetingKey() {
        return new FilterCondition<>(this, "meeting_key");
    }

    public FilterCondition<PositionFilter, Integer> position() {
        return new FilterCondition<>(this, "position");
    }

    public FilterCondition<PositionFilter, Integer> sessionKey() {
        return new FilterCondition<>(this, "session_key");
    }

    public FilterConnector<PositionFilter> latestSession() {
        addParam("session_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    public FilterConnector<PositionFilter> latestMeeting() {
        addParam("meeting_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    @Override
    public String getFinalUrl() {
        return OpenF1Client.BASE_URL + Position.URL + super.toString();
    }
}
