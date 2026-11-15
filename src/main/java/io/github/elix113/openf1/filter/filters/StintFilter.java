package io.github.elix113.openf1.filter.filters;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.BaseFilter;
import io.github.elix113.openf1.filter.FilterCondition;
import io.github.elix113.openf1.filter.FilterConnector;
import io.github.elix113.openf1.models.Stint;

public class StintFilter extends BaseFilter {

    public static StintFilter create() {
        return new StintFilter();
    }

    public FilterCondition<StintFilter, String> compound() {
        return new FilterCondition<>(this, "compound");
    }

    public FilterCondition<StintFilter, Integer> driverNumber() {
        return new FilterCondition<>(this, "driver_number");
    }

    public FilterCondition<StintFilter, Integer> lapEnd() {
        return new FilterCondition<>(this, "lap_end");
    }

    public FilterCondition<StintFilter, Integer> lapStart() {
        return new FilterCondition<>(this, "lap_start");
    }

    public FilterCondition<StintFilter, Integer> meetingKey() {
        return new FilterCondition<>(this, "meeting_key");
    }

    public FilterCondition<StintFilter, Integer> sessionKey() {
        return new FilterCondition<>(this, "session_key");
    }

    public FilterCondition<StintFilter, Integer> stintNumber() {
        return new FilterCondition<>(this, "stint_number");
    }

    public FilterCondition<StintFilter, Integer> tyreAgeAtStart() {
        return new FilterCondition<>(this, "tyre_age_at_start");
    }

    public FilterConnector<StintFilter> latestSession() {
        addParam("session_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    public FilterConnector<StintFilter> latestMeeting() {
        addParam("meeting_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    @Override
    public String getFinalUrl() {
        return OpenF1Client.BASE_URL + Stint.URL + super.toString();
    }
}
