package io.github.elix113.openf1.filter.filters;

import java.time.Instant;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.BaseFilter;
import io.github.elix113.openf1.filter.FilterCondition;
import io.github.elix113.openf1.filter.FilterConnector;
import io.github.elix113.openf1.models.Meeting;

public class MeetingFilter extends BaseFilter {

    public static MeetingFilter create() {
        return new MeetingFilter();
    }

    public FilterCondition<MeetingFilter, Integer> circuitKey() {
        return new FilterCondition<>(this, "circuit_key");
    }

    public FilterCondition<MeetingFilter, String> circuitShortName() {
        return new FilterCondition<>(this, "circuit_short_name");
    }

    public FilterCondition<MeetingFilter, String> countryCode() {
        return new FilterCondition<>(this, "country_code");
    }

    public FilterCondition<MeetingFilter, Integer> countryKey() {
        return new FilterCondition<>(this, "country_key");
    }

    public FilterCondition<MeetingFilter, String> countryName() {
        return new FilterCondition<>(this, "country_name");
    }

    public FilterCondition<MeetingFilter, Instant> dateEnd() {
        return new FilterCondition<>(this, "date_end");
    }

    public FilterCondition<MeetingFilter, Instant> dateStart() {
        return new FilterCondition<>(this, "date_start");
    }

    public FilterCondition<MeetingFilter, String> gmtOffset() {
        return new FilterCondition<>(this, "gmt_offset");
    }

    public FilterCondition<MeetingFilter, Boolean> isCancelled() {
        return new FilterCondition<>(this, "is_cancelled");
    }

    public FilterCondition<MeetingFilter, String> location() {
        return new FilterCondition<>(this, "location");
    }

    public FilterCondition<MeetingFilter, Integer> meetingKey() {
        return new FilterCondition<>(this, "meeting_key");
    }

    public FilterCondition<MeetingFilter, String> meetingName() {
        return new FilterCondition<>(this, "meeting_name");
    }

    public FilterCondition<MeetingFilter, String> meetingOfficialName() {
        return new FilterCondition<>(this, "meeting_official_name");
    }

    public FilterCondition<MeetingFilter, Integer> year() {
        return new FilterCondition<>(this, "year");
    }

    public FilterConnector<MeetingFilter> latestMeeting() {
        addParam("meeting_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    @Override
    public String getFinalUrl() {
        return OpenF1Client.BASE_URL + Meeting.URL + super.toString();
    }
}
