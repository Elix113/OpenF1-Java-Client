package io.github.elix113.openf1.test;

import java.util.List;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.Filter;
import io.github.elix113.openf1.models.Driver;
import io.github.elix113.openf1.models.SessionResult;

/**
 * Main
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public class Main {

	public static void main(String[] args) {

		OpenF1Client client = new OpenF1Client();

		List<SessionResult> podium = client.getSessionResults(
			Filter.sessionResult()
				.latestSession()
				.and().position().le(3)
				.build()
		);

		List<Driver> drivers = client.getDrivers(
			Filter.driver()
				.latestSession()
				.and().driverNumber().in(podium.stream().map(SessionResult::driverNumber).toList())
				.build()
		).stream().distinct().toList();

		drivers.forEach(d -> System.out.println(d.driverNumber() + " " + d.fullName() + " (" + d.teamName() + ")"));
	}
}
