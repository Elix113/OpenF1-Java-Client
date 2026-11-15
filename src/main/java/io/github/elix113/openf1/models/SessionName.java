package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;

public enum SessionName {

	PRACTICE_1("Practice 1"),
	PRACTICE_2("Practice 2"),
	PRACTICE_3("Practice 3"),
	QUALIFYING("Qualifying"),
	RACE("Race"),
	SPRINT("Sprint"),
	SPRINT_QUALIFYING("Sprint Qualifying"),
	UNKNOWN("unknown");

	private final String id;

	SessionName(String id) {
		this.id = id;
	}

	@JsonCreator
	public static SessionName fromId(String id) {
		for (SessionName value : values())
			if (Objects.equals(value.id, id))
				return value;
		return UNKNOWN;
	}

	@Override
	public String toString() {
		return id;
	}
}
