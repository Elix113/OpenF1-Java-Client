# OpenF1-Java-Client

[![Java Version](https://img.shields.io/badge/Java-21%2B-blue.svg)](https://openjdk.org/projects/jdk/21/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Maven Central](https://img.shields.io/badge/Maven%20Central-v1.0.1-orange.svg)](https://central.sonatype.com/artifact/io.github.elix113/openf1-java-client)
[![License: PolyForm Noncommercial 1.0.0](https://img.shields.io/badge/License-PolyForm%20Noncommercial%201.0.0-green.svg)](https://polyformproject.org/licenses/noncommercial/1.0.0)

A robust, production-ready, and lightweight Java 21 client wrapper for the **OpenF1 API**. Designed with modern 
Java features, built-in network resilience, proactive rate limiting, and an intuitive fluent filter DSL.

## Features

- **Smart Rate Limiting**: Implements a rate limiter to strictly respect OpenF1 limits (**3 requests/second** & **30 requests/minute**).
- **Automatic Retries**: Reactive Exponential Backoff mechanism for handling `HTTP 429 (Too Many Requests)` gracefully.
- **Fluent Filter DSL**: Type-safe query construction for sessions, drivers, laps, telemetry, and more.

## API Documentation & Naming Conventions

This library closely mirrors the official **[OpenF1 API Documentation](https://openf1.org/)**. You can refer directly
to the OpenF1 docs for a complete overview of all available endpoints, query parameters, and data structures.

**Naming Convention Note:**
- All endpoints, filter parameters, and model fields share the exact same names as in the official OpenF1 API.
- The only difference is that this library follows standard Java naming conventions by converting `snake_case`
- into **`camelCase`** (e.g., `driver_number` becomes `driverNumber`, `session_key` becomes `sessionKey`).

## Installation

### Maven
Add the dependency to your `pom.xml` (once published to Maven Central):

```xml
<dependency>
    <groupId>io.github.elix113</groupId>
    <artifactId>openf1-client</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Code Example

```java
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
```

## Disclaimer & Credits

- **OpenF1 Project**: This library interacts with **[OpenF1](https://openf1.org)**, a free and open-source API for real-time and historical Formula 1 data created by [br-g/openf1](https://github.com/br-g/openf1). Please support their amazing open-source initiative!
- **Official Association**: OpenF1 is an unofficial, community-operated project and is not associated, affiliated, endorsed, or sponsored by Formula One companies.


## 📄 License

Distributed under the **PolyForm Noncommercial License 1.0.0**. Commercial use is strictly prohibited without explicit 
permission. See `LICENSE` for more information.
