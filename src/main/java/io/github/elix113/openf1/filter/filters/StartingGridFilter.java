package io.github.elix113.openf1.filter.filters;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.BaseFilter;
import io.github.elix113.openf1.filter.FilterCondition;
import io.github.elix113.openf1.filter.FilterConnector;
import io.github.elix113.openf1.models.StartingGrid;

/**
 * @see <a href="https://openf1.org/docs/#starting-grid">openf1.org</a>
 */
public class StartingGridFilter extends BaseFilter {

    public static StartingGridFilter create() {
        return new StartingGridFilter();
    }

    public FilterCondition<StartingGridFilter, Integer> driverNumber() {
        return new FilterCondition<>(this, "driver_number");
    }

    public FilterCondition<StartingGridFilter, Double> lapDuration() {
        return new FilterCondition<>(this, "lap_duration");
    }

    public FilterCondition<StartingGridFilter, Integer> meetingKey() {
        return new FilterCondition<>(this, "meeting_key");
    }

    public FilterCondition<StartingGridFilter, Integer> position() {
        return new FilterCondition<>(this, "position");
    }

    public FilterCondition<StartingGridFilter, Integer> sessionKey() {
        return new FilterCondition<>(this, "session_key");
    }

    public FilterConnector<StartingGridFilter> latestSession() {
        addParam("session_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    public FilterConnector<StartingGridFilter> latestMeeting() {
        addParam("meeting_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    @Override
    public String getFinalUrl() {
        return OpenF1Client.BASE_URL + StartingGrid.URL + super.toString();
    }
}
