package io.github.elix113.openf1.filter.filters;

import java.time.Instant;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.BaseFilter;
import io.github.elix113.openf1.filter.FilterCondition;
import io.github.elix113.openf1.filter.FilterConnector;
import io.github.elix113.openf1.models.Session;

public class SessionFilter extends BaseFilter {

    public static SessionFilter create() {
        return new SessionFilter();
    }

    public FilterCondition<SessionFilter, Integer> circuitKey() {
        return new FilterCondition<>(this, "circuit_key");
    }

    public FilterCondition<SessionFilter, String> circuitShortName() {
        return new FilterCondition<>(this, "circuit_short_name");
    }

    public FilterCondition<SessionFilter, String> countryCode() {
        return new FilterCondition<>(this, "country_code");
    }

    public FilterCondition<SessionFilter, Integer> countryKey() {
        return new FilterCondition<>(this, "country_key");
    }

    public FilterCondition<SessionFilter, String> countryName() {
        return new FilterCondition<>(this, "country_name");
    }

    public FilterCondition<SessionFilter, Instant> dateEnd() {
        return new FilterCondition<>(this, "date_end");
    }

    public FilterCondition<SessionFilter, Instant> dateStart() {
        return new FilterCondition<>(this, "date_start");
    }

    public FilterCondition<SessionFilter, String> gmtOffset() {
        return new FilterCondition<>(this, "gmt_offset");
    }

    public FilterCondition<SessionFilter, Boolean> isCancelled() {
        return new FilterCondition<>(this, "is_cancelled");
    }

    public FilterCondition<SessionFilter, String> location() {
        return new FilterCondition<>(this, "location");
    }

    public FilterCondition<SessionFilter, Integer> meetingKey() {
        return new FilterCondition<>(this, "meeting_key");
    }

    public FilterCondition<SessionFilter, Integer> sessionKey() {
        return new FilterCondition<>(this, "session_key");
    }

    public FilterCondition<SessionFilter, String> sessionName() {
        return new FilterCondition<>(this, "session_name");
    }

    public FilterCondition<SessionFilter, String> sessionType() {
        return new FilterCondition<>(this, "session_type");
    }

    public FilterCondition<SessionFilter, Integer> year() {
        return new FilterCondition<>(this, "year");
    }

    public FilterConnector<SessionFilter> latestSession() {
        addParam("session_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    public FilterConnector<SessionFilter> latestMeeting() {
        addParam("meeting_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    @Override
    public String getFinalUrl() {
        return OpenF1Client.BASE_URL + Session.URL + super.toString();
    }
}
