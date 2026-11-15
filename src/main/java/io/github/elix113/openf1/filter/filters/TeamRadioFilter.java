package io.github.elix113.openf1.filter.filters;

import java.time.Instant;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.BaseFilter;
import io.github.elix113.openf1.filter.FilterCondition;
import io.github.elix113.openf1.filter.FilterConnector;
import io.github.elix113.openf1.models.TeamRadio;

/**
 * @see <a href="https://openf1.org/docs/#team-radio">openf1.org</a>
 */
public class TeamRadioFilter extends BaseFilter {

    public static TeamRadioFilter create() {
        return new TeamRadioFilter();
    }

    public FilterCondition<TeamRadioFilter, Instant> date() {
        return new FilterCondition<>(this, "date");
    }

    public FilterCondition<TeamRadioFilter, Integer> driverNumber() {
        return new FilterCondition<>(this, "driver_number");
    }

    public FilterCondition<TeamRadioFilter, Integer> meetingKey() {
        return new FilterCondition<>(this, "meeting_key");
    }

    public FilterCondition<TeamRadioFilter, String> recordingUrl() {
        return new FilterCondition<>(this, "recording_url");
    }

    public FilterCondition<TeamRadioFilter, Integer> sessionKey() {
        return new FilterCondition<>(this, "session_key");
    }

    public FilterConnector<TeamRadioFilter> latestSession() {
        addParam("session_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    public FilterConnector<TeamRadioFilter> latestMeeting() {
        addParam("meeting_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    @Override
    public String getFinalUrl() {
        return OpenF1Client.BASE_URL + TeamRadio.URL + super.toString();
    }
}
