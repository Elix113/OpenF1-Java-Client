package io.github.elix113.openf1.filter.filters;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.BaseFilter;
import io.github.elix113.openf1.models.SessionResult;

public class SessionResultFilter extends BaseFilter {

    public static SessionResultFilter create() {
        return new SessionResultFilter();
    }

    public FilterCondition<SessionResultFilter, Boolean> dnf() {
        return new FilterCondition<>(this, "dnf");
    }

    public FilterCondition<SessionResultFilter, Boolean> dns() {
        return new FilterCondition<>(this, "dns");
    }

    public FilterCondition<SessionResultFilter, Boolean> dsq() {
        return new FilterCondition<>(this, "dsq");
    }

    public FilterCondition<SessionResultFilter, Integer> driverNumber() {
        return new FilterCondition<>(this, "driver_number");
    }

    public FilterCondition<SessionResultFilter, Double> duration() {
        return new FilterCondition<>(this, "duration");
    }

    public FilterCondition<SessionResultFilter, Double> gapToLeader() {
        return new FilterCondition<>(this, "gap_to_leader");
    }

    public FilterCondition<SessionResultFilter, Integer> meetingKey() {
        return new FilterCondition<>(this, "meeting_key");
    }

    public FilterCondition<SessionResultFilter, Integer> numberOfLaps() {
        return new FilterCondition<>(this, "number_of_laps");
    }

    public FilterCondition<SessionResultFilter, Double> points() {
        return new FilterCondition<>(this, "points");
    }

    public FilterCondition<SessionResultFilter, Integer> position() {
        return new FilterCondition<>(this, "position");
    }

    public FilterCondition<SessionResultFilter, Integer> sessionKey() {
        return new FilterCondition<>(this, "session_key");
    }

    public FilterConnector<SessionResultFilter> latestSession() {
        addParam("session_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    public FilterConnector<SessionResultFilter> latestMeeting() {
        addParam("meeting_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    @Override
    public String getFinalUrl() {
        return OpenF1Client.BASE_URL + SessionResult.URL + super.toString();
    }
}
