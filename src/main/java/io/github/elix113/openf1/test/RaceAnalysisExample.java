package io.github.elix113.openf1.test;

import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.github.elix113.openf1.client.OpenF1Client;
import io.github.elix113.openf1.filter.Filter;
import io.github.elix113.openf1.models.CarData;
import io.github.elix113.openf1.models.RaceControlCategory;
import io.github.elix113.openf1.models.Driver;
import io.github.elix113.openf1.models.RaceControl;
import io.github.elix113.openf1.models.Session;
import io.github.elix113.openf1.models.SessionResult;
import io.github.elix113.openf1.models.Stint;
import io.github.elix113.openf1.models.SessionType;

public class RaceAnalysisExample {

	public static void main(String[] args) {
		OpenF1Client client = new OpenF1Client();

		// 1. SESSION FINDEN: Das Rennen ("Race") in Singapur 2023 suchen
		List<Session> sessions = client.getSessions(
			Filter.session()
				.year().eq(2023)
				.and().countryName().eq("Singapore")
				.and().sessionType().eq(SessionType.RACE)
				.build()
		);

		if (sessions.isEmpty()) {
			System.out.println("Session nicht gefunden.");
			return;
		}

		Session singaporeRace = sessions.getFirst();
		int sessionKey = singaporeRace.sessionKey();
		System.out.printf(
			"=== Analyse: %s - %s (%d) | Session-Key: %d ===%n%n",
			singaporeRace.countryName(), singaporeRace.sessionName(), singaporeRace.year(), sessionKey
		);

		// 2. FAHRER & PODIUM: Alle Fahrer von Ferrari ODER Red Bull Racing laden
		List<Driver> topTeamDrivers = client.getDrivers(
			Filter.driver()
				.sessionKey().eq(sessionKey)
				.and().teamName().in("Ferrari", "Red Bull Racing")
				.build()
		);

		// Map für schnellen Zugriff: driverNumber -> SessionName
		Map<Integer, String> driverNames = topTeamDrivers.stream()
			.collect(Collectors.toMap(Driver::driverNumber, Driver::fullName));

		// 3. RENNERGEBNIS: Die Top 3 des Rennens abfragen
		List<SessionResult> podium = client.getSessionResults(
			Filter.sessionResult()
				.sessionKey().eq(sessionKey)
				.and().position().le(3) // Platz 1, 2 oder 3
				.build()
		);

		System.out.println("--- Podium ---");
		podium.stream()
			.sorted(Comparator.comparingInt(SessionResult::position))
			.forEach(res -> System.out.printf(
				"P%d: Fahrer #%d (Runden: %d, Abstand: %s)%n",
				res.position(), res.driverNumber(), res.numberOfLaps(), res.gapToLeader()
			));

		// 4. REIFENSTRATEGIE (STINTS): Stints für Carlos Sainz (#55) & Charles Leclerc (#16)
		List<Stint> ferrariStints = client.getStints(
			Filter.stint()
				.sessionKey().eq(sessionKey)
				.and().driverNumber().in(55, 16)
				.build()
		);

		System.out.println("\n--- Ferrari Reifenstrategie ---");
		for (Stint stint : ferrariStints) {
			System.out.printf(
				"%s (#%d) | Stint %d: %-6s (Runde %d bis %d, Reifenalter Start: %d)%n",
				driverNames.getOrDefault(stint.driverNumber(), "Unbekannt"),
				stint.driverNumber(),
				stint.stintNumber(),
				stint.compound(),
				stint.lapStart(),
				stint.lapEnd(),
				stint.tyreAgeAtStart()
			);
		}

		// 5. HIGH-SPEED TELEMETRIE: Wann fuhr Carlos Sainz (#55) > 310 km/h mit offenem DRS?
		// (DRS-Werte 10, 12 oder 14 bedeuten bei OpenF1 "DRS aktiv")
		List<CarData> highSpeedTelemetry = client.getCarData(
			Filter.carData()
				.sessionKey().eq(sessionKey)
				.and().driverNumber().eq(55)
				.and().speed().gt(310)
				.and().drs().in(10, 12, 14)
				.and().date().ge(Instant.parse("2023-09-17T13:30:00Z"))
				.build()
		);

		System.out.println("\n--- Telemetrie-Check (#55 Carlos Sainz) ---");
		System.out.printf(
			"Gefundene Datenpunkte > 310 km/h mit DRS nach 13:30 UTC: %d%n",
			highSpeedTelemetry.size()
		);

		highSpeedTelemetry.stream()
			.max(Comparator.comparingInt(CarData::speed))
			.ifPresent(topSpeed -> System.out.printf(
				"Top-Speed in diesem Fenster: %d km/h bei %d RPM (Gang %d) um %s%n",
				topSpeed.speed(), topSpeed.rpm(), topSpeed.nGear(), topSpeed.date()
			));

		// 6. RENNLEITUNG (RACE CONTROL): Alle Safety-Car-Meldungen der Session
		List<RaceControl> safetyCarEvents = client.getRaceControl(
			Filter.raceControl()
				.sessionKey().eq(sessionKey)
				.and().category().eq(RaceControlCategory.SAFETY_CAR)
				.build()
		);

		System.out.println("\n--- Safety Car Meldungen ---");
		for (RaceControl rc : safetyCarEvents) {
			System.out.printf(
				"[Runde %d | %s] %s%n",
				rc.lapNumber(), rc.date(), rc.message()
			);
		}
	}
}
