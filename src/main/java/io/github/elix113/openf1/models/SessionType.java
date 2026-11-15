package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;

public enum SessionType {

	PRACTICE("Practice"),
	QUALIFYING("Qualifying"),
	RACE("Race"),
	UNKNOWN("unknown");

	private final String id;

	SessionType(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@JsonCreator
	public static SessionType fromId(String id) {
		for (SessionType value : values())
			if (Objects.equals(value.id, id))
				return value;
		return UNKNOWN;
	}

	@Override
	public String toString() {
		return id;
	}
}
