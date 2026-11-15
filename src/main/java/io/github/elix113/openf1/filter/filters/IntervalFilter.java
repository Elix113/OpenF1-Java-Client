package io.github.elix113.openf1.filter.filters;

import java.time.Instant;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.BaseFilter;
import io.github.elix113.openf1.filter.FilterCondition;
import io.github.elix113.openf1.filter.FilterConnector;
import io.github.elix113.openf1.models.Interval;

public class IntervalFilter extends BaseFilter {

    public static IntervalFilter create() {
        return new IntervalFilter();
    }

    public FilterCondition<IntervalFilter, Instant> date() {
        return new FilterCondition<>(this, "date");
    }

    public FilterCondition<IntervalFilter, Integer> driverNumber() {
        return new FilterCondition<>(this, "driver_number");
    }

    public FilterCondition<IntervalFilter, Double> gapToLeader() {
        return new FilterCondition<>(this, "gap_to_leader");
    }

    public FilterCondition<IntervalFilter, Double> interval() {
        return new FilterCondition<>(this, "interval");
    }

    public FilterCondition<IntervalFilter, Integer> meetingKey() {
        return new FilterCondition<>(this, "meeting_key");
    }

    public FilterCondition<IntervalFilter, Integer> sessionKey() {
        return new FilterCondition<>(this, "session_key");
    }

    public FilterConnector<IntervalFilter> latestSession() {
        addParam("session_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    public FilterConnector<IntervalFilter> latestMeeting() {
        addParam("meeting_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    @Override
    public String getFinalUrl() {
        return OpenF1Client.BASE_URL + Interval.URL + super.toString();
    }
}
