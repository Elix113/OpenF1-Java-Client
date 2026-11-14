package io.github.elix113.openf1.filter;

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

/**
 * Filter
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public class Filter {

	public static CarDataFilter carData() {
		return CarDataFilter.create();
	}

	public static ChampionshipDriverFilter championshipDriver() {
		return ChampionshipDriverFilter.create();
	}

	public static ChampionshipTeamFilter championshipTeam() {
		return ChampionshipTeamFilter.create();
	}

	public static DriverFilter driver() {
		return DriverFilter.create();
	}

	public static IntervalFilter interval() {
		return IntervalFilter.create();
	}

	public static LapFilter lap() {
		return LapFilter.create();
	}

	public static LocationFilter location() {
		return LocationFilter.create();
	}

	public static MeetingFilter meeting() {
		return MeetingFilter.create();
	}

	public static OvertakeFilter overtake() {
		return OvertakeFilter.create();
	}

	public static PitFilter pit() {
		return PitFilter.create();
	}

	public static PositionFilter position() {
		return PositionFilter.create();
	}

	public static RaceControlFilter raceControl() {
		return RaceControlFilter.create();
	}

	public static SessionFilter session() {
		return SessionFilter.create();
	}

	public static SessionResultFilter sessionResult() {
		return SessionResultFilter.create();
	}

	public static StartingGridFilter startingGrid() {
		return StartingGridFilter.create();
	}

	public static StintFilter stint() {
		return StintFilter.create();
	}

	public static TeamRadioFilter teamRadio() {
		return TeamRadioFilter.create();
	}

	public static WeatherFilter weather() {
		return WeatherFilter.create();
	}
}
