package io.github.elix113.openf1.test;

import java.io.IOException;
import java.util.List;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.Filter;
import io.github.elix113.openf1.filter.filters.LapFilter;
import io.github.elix113.openf1.models.Lap;

/**
 * Main
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		OpenF1Client ofc = new OpenF1Client();

		LapFilter filter = Filter.lap()
			.sessionKey().eq(9222)
			.and().driverNumber().eq(55)
			.and().isPitOutLap().eq(true)
			.and().lapDuration().ge(120.0)
			.build();

		System.out.println(filter.getFinalUrl());

		List<Lap> laps = ofc.getLaps(filter);
		System.out.println();
		laps.forEach(System.out::println);


	}
}
