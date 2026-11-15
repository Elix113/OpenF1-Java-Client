package io.github.elix113.openf1.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

import io.github.elix113.openf1.filter.BaseFilter;
import io.github.elix113.openf1.filter.filters.CarDataFilter;
import io.github.elix113.openf1.filter.filters.ChampionshipDriverFilter;
import io.github.elix113.openf1.filter.filters.ChampionshipTeamFilter;
import io.github.elix113.openf1.filter.filters.DriverFilter;
import io.github.elix113.openf1.filter.filters.IntervalFilter;
import io.github.elix113.openf1.filter.filters.LapFilter;
import io.github.elix113.openf1.filter.filters.LocationFilter;
import io.github.elix113.openf1.filter.filters.MeetingFilter;
import io.github.elix113.openf1.filter.filters.OvertakeFilter;
import io.github.elix113.openf1.filter.filters.PitFilter;
import io.github.elix113.openf1.filter.filters.PositionFilter;
import io.github.elix113.openf1.filter.filters.RaceControlFilter;
import io.github.elix113.openf1.filter.filters.SessionFilter;
import io.github.elix113.openf1.filter.filters.SessionResultFilter;
import io.github.elix113.openf1.filter.filters.StartingGridFilter;
import io.github.elix113.openf1.filter.filters.StintFilter;
import io.github.elix113.openf1.filter.filters.TeamRadioFilter;
import io.github.elix113.openf1.filter.filters.WeatherFilter;
import io.github.elix113.openf1.models.CarData;
import io.github.elix113.openf1.models.ChampionshipDriver;
import io.github.elix113.openf1.models.ChampionshipTeam;
import io.github.elix113.openf1.models.Driver;
import io.github.elix113.openf1.models.Interval;
import io.github.elix113.openf1.models.Lap;
import io.github.elix113.openf1.models.Location;
import io.github.elix113.openf1.models.Meeting;
import io.github.elix113.openf1.models.Overtake;
import io.github.elix113.openf1.models.Pit;
import io.github.elix113.openf1.models.Position;
import io.github.elix113.openf1.models.RaceControl;
import io.github.elix113.openf1.models.Session;
import io.github.elix113.openf1.models.SessionResult;
import io.github.elix113.openf1.models.StartingGrid;
import io.github.elix113.openf1.models.Stint;
import io.github.elix113.openf1.models.TeamRadio;
import io.github.elix113.openf1.models.Weather;
import tools.jackson.databind.json.JsonMapper;

/**
 * OpenF1Client
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public class OpenF1Client {

	public static final String BASE_URL = "https://api.openf1.org/v1/";
	private static final int MAX_TRIES = 3;
	private static final long TIMEOUT = 300;


	private final HttpClient httpClient;
	private final JsonMapper objectMapper;

	public OpenF1Client() {
		this.httpClient = HttpClient.newBuilder()
			.connectTimeout(Duration.ofSeconds(10))
			.followRedirects(HttpClient.Redirect.NORMAL)
			.build();
		this.objectMapper = new JsonMapper();
	}

	public <T> List<T> fetch(BaseFilter filter, Class<T> model) throws IOException, InterruptedException {
		String finalUrl = filter.getFinalUrl();


		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(finalUrl))
			.header("Accept", "application/json")
			.GET()
			.build();

		int attempt = 1;
		HttpResponse<String> response;
		do {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

			if (response.statusCode() == 429) {
				if (attempt == MAX_TRIES)
					throw new RuntimeException("Rate limit exceeded (HTTP 429) after " + MAX_TRIES + " attempts for URL: " + request.uri());

				System.out.println("Rate limited (429). Retrying in " + TIMEOUT + "ms... (Attempt " + attempt + "/" + MAX_TRIES + ")");
				Thread.sleep(TIMEOUT);
				attempt++;
			}
		} while (response.statusCode() == 429);

		if (response.statusCode() == 404)
			return List.of();

		if (response.statusCode() != 200)
			throw new RuntimeException("Failed to fetch data (" + finalUrl + "): HTTP " + response.statusCode());

		return objectMapper.readValue(
			response.body(),
			objectMapper.getTypeFactory().constructCollectionType(List.class, model)
		);
	}

	public List<CarData> getCarData(CarDataFilter filter) throws IOException, InterruptedException {
		return fetch(filter, CarData.class);
	}

	public List<ChampionshipDriver> getChampionshipDrivers(ChampionshipDriverFilter filter) throws IOException, InterruptedException {
		return fetch(filter, ChampionshipDriver.class);
	}

	public List<ChampionshipTeam> getChampionshipTeams(ChampionshipTeamFilter filter) throws IOException, InterruptedException {
		return fetch(filter, ChampionshipTeam.class);
	}

	public List<Driver> getDrivers(DriverFilter filter) throws IOException, InterruptedException {
		return fetch(filter, Driver.class);
	}

	public List<Interval> getIntervals(IntervalFilter filter) throws IOException, InterruptedException {
		return fetch(filter, Interval.class);
	}

	public List<Lap> getLaps(LapFilter filter) throws IOException, InterruptedException {
		return fetch(filter, Lap.class);
	}

	public List<Location> getLocations(LocationFilter filter) throws IOException, InterruptedException {
		return fetch(filter, Location.class);
	}

	public List<Meeting> getMeetings(MeetingFilter filter) throws IOException, InterruptedException {
		return fetch(filter, Meeting.class);
	}

	public List<Overtake> getOvertakes(OvertakeFilter filter) throws IOException, InterruptedException {
		return fetch(filter, Overtake.class);
	}

	public List<Pit> getPits(PitFilter filter) throws IOException, InterruptedException {
		return fetch(filter, Pit.class);
	}

	public List<Position> getPositions(PositionFilter filter) throws IOException, InterruptedException {
		return fetch(filter, Position.class);
	}

	public List<RaceControl> getRaceControl(RaceControlFilter filter) throws IOException, InterruptedException {
		return fetch(filter, RaceControl.class);
	}

	public List<Session> getSessions(SessionFilter filter) throws IOException, InterruptedException {
		return fetch(filter, Session.class);
	}

	public List<SessionResult> getSessionResults(SessionResultFilter filter) throws IOException, InterruptedException {
		return fetch(filter, SessionResult.class);
	}

	public List<StartingGrid> getStartingGrids(StartingGridFilter filter) throws IOException, InterruptedException {
		return fetch(filter, StartingGrid.class);
	}

	public List<Stint> getStints(StintFilter filter) throws IOException, InterruptedException {
		return fetch(filter, Stint.class);
	}

	public List<TeamRadio> getTeamRadios(TeamRadioFilter filter) throws IOException, InterruptedException {
		return fetch(filter, TeamRadio.class);
	}

	public List<Weather> getWeather(WeatherFilter filter) throws IOException, InterruptedException {
		return fetch(filter, Weather.class);
	}
}

