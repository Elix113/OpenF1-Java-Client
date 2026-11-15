# OpenF1 Java

[![Java Version](https://img.shields.io/badge/Java-21%2B-blue.svg)](https://openjdk.org/projects/jdk/21/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Maven Central](https://img.shields.io/badge/Maven%20Central-coming%20soon-orange.svg)](https://search.maven.org/)

A robust, production-ready, and lightweight Java 21 client wrapper for the **OpenF1 API**. Designed with modern Java features, built-in network resilience, proactive rate limiting, and an intuitive fluent filter DSL.

---

## Features

- **Smart Rate Limiting**: Implements a dual-layer **Sliding Window** rate limiter to strictly respect OpenF1 limits (**3 requests/second** & **30 requests/minute**).
- **Automatic Retries**: Reactive Exponential Backoff mechanism for handling `HTTP 429 (Too Many Requests)` gracefully.
- **Fluent Filter DSL**: Type-safe query construction for sessions, drivers, laps, telemetry, and more.

---

## Disclaimer & Credits

* **OpenF1 Project**: This library interacts with **[OpenF1](https://openf1.org)**, a free and open-source API for real-time and historical Formula 1 data created by [br-g/openf1](https://github.com/br-g/openf1). Please support their amazing open-source initiative!
* **Official Association**: OpenF1 is an unofficial, community-operated project and is not associated, affiliated, endorsed, or sponsored by Formula One companies.

---

## Installation

### Maven
Add the dependency to your `pom.xml` (once published to Maven Central):

```xml
<dependency>
    <groupId>io.github.elix113</groupId>
    <artifactId>openf1-client</artifactId>
    <version>1.0.0</version>
</dependency>
