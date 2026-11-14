package io.github.elix113.openf1.filter.filters;

import java.time.Instant;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.BaseFilter;
import io.github.elix113.openf1.models.CarData;

public class CarDataFilter extends BaseFilter {

    public static CarDataFilter create() {
        return new CarDataFilter();
    }

    public FilterCondition<CarDataFilter, Integer> brake() {
        return new FilterCondition<>(this, "brake");
    }

    public FilterCondition<CarDataFilter, Instant> date() {
        return new FilterCondition<>(this, "date");
    }

    public FilterCondition<CarDataFilter, Integer> driverNumber() {
        return new FilterCondition<>(this, "driver_number");
    }

    public FilterCondition<CarDataFilter, Integer> drs() {
        return new FilterCondition<>(this, "drs");
    }

    public FilterCondition<CarDataFilter, Integer> meetingKey() {
        return new FilterCondition<>(this, "meeting_key");
    }

    public FilterCondition<CarDataFilter, Integer> nGear() {
        return new FilterCondition<>(this, "n_gear");
    }

    public FilterCondition<CarDataFilter, Integer> rpm() {
        return new FilterCondition<>(this, "rpm");
    }

    public FilterCondition<CarDataFilter, Integer> sessionKey() {
        return new FilterCondition<>(this, "session_key");
    }

    public FilterCondition<CarDataFilter, Integer> speed() {
        return new FilterCondition<>(this, "speed");
    }

    public FilterCondition<CarDataFilter, Integer> throttle() {
        return new FilterCondition<>(this, "throttle");
    }

    public FilterConnector<CarDataFilter> latestSession() {
        addParam("session_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    public FilterConnector<CarDataFilter> latestMeeting() {
        addParam("meeting_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    @Override
    public String getFinalUrl() {
        return OpenF1Client.BASE_URL + CarData.URL + super.toString();
    }
}
