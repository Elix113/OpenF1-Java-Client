package io.github.elix113.openf1.filter.filters;

import java.time.Instant;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.BaseFilter;
import io.github.elix113.openf1.models.Weather;

public class WeatherFilter extends BaseFilter {

    public static WeatherFilter create() {
        return new WeatherFilter();
    }

    public FilterCondition<WeatherFilter, Double> airTemperature() {
        return new FilterCondition<>(this, "air_temperature");
    }

    public FilterCondition<WeatherFilter, Instant> date() {
        return new FilterCondition<>(this, "date");
    }

    public FilterCondition<WeatherFilter, Double> humidity() {
        return new FilterCondition<>(this, "humidity");
    }

    public FilterCondition<WeatherFilter, Integer> meetingKey() {
        return new FilterCondition<>(this, "meeting_key");
    }

    public FilterCondition<WeatherFilter, Double> pressure() {
        return new FilterCondition<>(this, "pressure");
    }

    public FilterCondition<WeatherFilter, Integer> rainfall() {
        return new FilterCondition<>(this, "rainfall");
    }

    public FilterCondition<WeatherFilter, Integer> sessionKey() {
        return new FilterCondition<>(this, "session_key");
    }

    public FilterCondition<WeatherFilter, Double> trackTemperature() {
        return new FilterCondition<>(this, "track_temperature");
    }

    public FilterCondition<WeatherFilter, Integer> windDirection() {
        return new FilterCondition<>(this, "wind_direction");
    }

    public FilterCondition<WeatherFilter, Double> windSpeed() {
        return new FilterCondition<>(this, "wind_speed");
    }

    public FilterConnector<WeatherFilter> latestSession() {
        addParam("session_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    public FilterConnector<WeatherFilter> latestMeeting() {
        addParam("meeting_key", "=", "latest");
        return new FilterConnector<>(this);
    }

    @Override
    public String getFinalUrl() {
        return OpenF1Client.BASE_URL + Weather.URL + super.toString();
    }
}
