package io.github.elix113.openf1.filter.filters;

import java.time.Instant;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.BaseFilter;
import io.github.elix113.openf1.filter.FilterCondition;
import io.github.elix113.openf1.filter.FilterConnector;
import io.github.elix113.openf1.models.Lap;

public class LapFilter extends BaseFilter {

    public static LapFilter create() {
        return new LapFilter();
    }

    public FilterCondition<LapFilter, Instant> dateStart() {
        return new FilterCondition<>(this, "date_start");
    }

    public FilterCondition<LapFilter, Integer> driverNumber() {
        return new FilterCondition<>(this, "driver_number");
    }

    public FilterCondition<LapFilter, Double> durationSector1() {
        return new FilterCondition<>(this, "duration_sector_1");
    }

    public FilterCondition<LapFilter, Double> durationSector2() {
        return new FilterCondition<>(this, "duration_sector_2");
    }

    public FilterCondition<LapFilter, Double> durationSector3() {
        return new FilterCondition<>(this, "duration_sector_3");
    }

    public FilterCondition<LapFilter, Integer> i1Speed() {
        return new FilterCondition<>(this, "i1_speed");
    }

    public FilterCondition<LapFilter, Integer> i2Speed() {
        return new FilterCondition<>(this, "i2_speed");
    }

    public FilterCondition<LapFilter, Boolean> isPitOutLap() {
        return new FilterCondition<>(this, "is_pit_out_lap");
    }

    public FilterCondition<LapFilter, Double> lapDuration() {
        return new FilterCondition<>(this, "lap_duration");
    }

    public FilterCondition<LapFilter, Integer> lapNumber() {
        return new FilterCondition<>(this, "lap_number");
    }

    public FilterCondition<LapFilter, Integer> meetingKey() {
        return new FilterCondition<>(this, "meeting_key");
    }

    public FilterCondition<LapFilter, Integer> sessionKey() {
        return new FilterCondition<>(this, "session_key");
    }

    public FilterCondition<LapFilter, Integer> stSpeed() {
        return new FilterCondition<>(this, "st_speed");
    }

    public FilterConnector<LapFilter> latestSession() {
        addParam("session_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    public FilterConnector<LapFilter> latestMeeting() {
        addParam("meeting_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    @Override
    public String getFinalUrl() {
        return OpenF1Client.BASE_URL + Lap.URL + super.toString();
    }
}
