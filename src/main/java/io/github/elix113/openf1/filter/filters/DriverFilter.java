package io.github.elix113.openf1.filter.filters;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.BaseFilter;
import io.github.elix113.openf1.models.Driver;

public class DriverFilter extends BaseFilter {

    public static DriverFilter create() {
        return new DriverFilter();
    }

    public FilterCondition<DriverFilter, String> broadcastName() {
        return new FilterCondition<>(this, "broadcast_name");
    }

    public FilterCondition<DriverFilter, Integer> driverNumber() {
        return new FilterCondition<>(this, "driver_number");
    }

    public FilterCondition<DriverFilter, String> firstName() {
        return new FilterCondition<>(this, "first_name");
    }

    public FilterCondition<DriverFilter, String> fullName() {
        return new FilterCondition<>(this, "full_name");
    }

    public FilterCondition<DriverFilter, String> lastName() {
        return new FilterCondition<>(this, "last_name");
    }

    public FilterCondition<DriverFilter, Integer> meetingKey() {
        return new FilterCondition<>(this, "meeting_key");
    }

    public FilterCondition<DriverFilter, String> nameAcronym() {
        return new FilterCondition<>(this, "name_acronym");
    }

    public FilterCondition<DriverFilter, Integer> sessionKey() {
        return new FilterCondition<>(this, "session_key");
    }

    public FilterCondition<DriverFilter, String> teamColour() {
        return new FilterCondition<>(this, "team_colour");
    }

    public FilterCondition<DriverFilter, String> teamName() {
        return new FilterCondition<>(this, "team_name");
    }

    public FilterConnector<DriverFilter> latestSession() {
        addParam("session_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    public FilterConnector<DriverFilter> latestMeeting() {
        addParam("meeting_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    @Override
    public String getFinalUrl() {
        return OpenF1Client.BASE_URL + Driver.URL + super.toString();
    }
}
