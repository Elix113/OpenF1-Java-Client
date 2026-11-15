package io.github.elix113.openf1.filter.filters;

import java.time.Instant;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.BaseFilter;
import io.github.elix113.openf1.filter.FilterCondition;
import io.github.elix113.openf1.filter.FilterConnector;
import io.github.elix113.openf1.models.Location;

public class LocationFilter extends BaseFilter {

    public static LocationFilter create() {
        return new LocationFilter();
    }

    public FilterCondition<LocationFilter, Instant> date() {
        return new FilterCondition<>(this, "date");
    }

    public FilterCondition<LocationFilter, Integer> driverNumber() {
        return new FilterCondition<>(this, "driver_number");
    }

    public FilterCondition<LocationFilter, Integer> meetingKey() {
        return new FilterCondition<>(this, "meeting_key");
    }

    public FilterCondition<LocationFilter, Integer> sessionKey() {
        return new FilterCondition<>(this, "session_key");
    }

    public FilterCondition<LocationFilter, Integer> x() {
        return new FilterCondition<>(this, "x");
    }

    public FilterCondition<LocationFilter, Integer> y() {
        return new FilterCondition<>(this, "y");
    }

    public FilterCondition<LocationFilter, Integer> z() {
        return new FilterCondition<>(this, "z");
    }

    public FilterConnector<LocationFilter> latestSession() {
        addParam("session_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    public FilterConnector<LocationFilter> latestMeeting() {
        addParam("meeting_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    @Override
    public String getFinalUrl() {
        return OpenF1Client.BASE_URL + Location.URL + super.toString();
    }
}
