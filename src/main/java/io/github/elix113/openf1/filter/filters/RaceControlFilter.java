package io.github.elix113.openf1.filter.filters;

import java.time.Instant;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.BaseFilter;
import io.github.elix113.openf1.filter.FilterCondition;
import io.github.elix113.openf1.filter.FilterConnector;
import io.github.elix113.openf1.models.RaceControlCategory;
import io.github.elix113.openf1.models.Flag;
import io.github.elix113.openf1.models.RaceControl;
import io.github.elix113.openf1.models.RaceControlScope;

/**
 * @see <a href="https://openf1.org/docs/#race-control">openf1.org</a>
 */
public class RaceControlFilter extends BaseFilter {

    public static RaceControlFilter create() {
        return new RaceControlFilter();
    }

    public FilterCondition<RaceControlFilter, RaceControlCategory> category() {
        return new FilterCondition<>(this, "category");
    }

    public FilterCondition<RaceControlFilter, Instant> date() {
        return new FilterCondition<>(this, "date");
    }

    public FilterCondition<RaceControlFilter, Integer> driverNumber() {
        return new FilterCondition<>(this, "driver_number");
    }

    public FilterCondition<RaceControlFilter, Flag> flag() {
        return new FilterCondition<>(this, "flag");
    }

    public FilterCondition<RaceControlFilter, Integer> lapNumber() {
        return new FilterCondition<>(this, "lap_number");
    }

    public FilterCondition<RaceControlFilter, Integer> meetingKey() {
        return new FilterCondition<>(this, "meeting_key");
    }

    public FilterCondition<RaceControlFilter, String> message() {
        return new FilterCondition<>(this, "message");
    }

    public FilterCondition<RaceControlFilter, Integer> qualifyingPhase() {
        return new FilterCondition<>(this, "qualifying_phase");
    }

    public FilterCondition<RaceControlFilter, RaceControlScope> scope() {
        return new FilterCondition<>(this, "scope");
    }

    public FilterCondition<RaceControlFilter, Integer> sector() {
        return new FilterCondition<>(this, "sector");
    }

    public FilterCondition<RaceControlFilter, Integer> sessionKey() {
        return new FilterCondition<>(this, "session_key");
    }

    public FilterConnector<RaceControlFilter> latestSession() {
        addParam("session_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    public FilterConnector<RaceControlFilter> latestMeeting() {
        addParam("meeting_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    @Override
    public String getFinalUrl() {
        return OpenF1Client.BASE_URL + RaceControl.URL + super.toString();
    }
}
