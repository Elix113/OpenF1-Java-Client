package io.github.elix113.openf1.filter.filters;

import java.time.Instant;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.BaseFilter;
import io.github.elix113.openf1.filter.FilterCondition;
import io.github.elix113.openf1.filter.FilterConnector;
import io.github.elix113.openf1.models.Pit;

/**
 * @see <a href="https://openf1.org/docs/#pit">openf1.org</a>
 */
public class PitFilter extends BaseFilter {

    public static PitFilter create() {
        return new PitFilter();
    }

    public FilterCondition<PitFilter, Instant> date() {
        return new FilterCondition<>(this, "date");
    }

    public FilterCondition<PitFilter, Integer> driverNumber() {
        return new FilterCondition<>(this, "driver_number");
    }

    public FilterCondition<PitFilter, Double> laneDuration() {
        return new FilterCondition<>(this, "lane_duration");
    }

    public FilterCondition<PitFilter, Integer> lapNumber() {
        return new FilterCondition<>(this, "lap_number");
    }

    public FilterCondition<PitFilter, Integer> meetingKey() {
        return new FilterCondition<>(this, "meeting_key");
    }

    public FilterCondition<PitFilter, Integer> sessionKey() {
        return new FilterCondition<>(this, "session_key");
    }

    public FilterCondition<PitFilter, Double> stopDuration() {
        return new FilterCondition<>(this, "stop_duration");
    }

    public FilterConnector<PitFilter> latestSession() {
        addParam("session_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    public FilterConnector<PitFilter> latestMeeting() {
        addParam("meeting_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    @Override
    public String getFinalUrl() {
        return OpenF1Client.BASE_URL + Pit.URL + super.toString();
    }
}
