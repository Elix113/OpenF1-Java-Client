package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;

public enum RaceControlScope {

	TRACK("Track"),
	DRIVER("Driver"),
	SECTOR("Sector"),
	NULL(null),
	UNKNOWN("unknown");

	private final String id;

	RaceControlScope(String id) {
		this.id = id;
	}

	@JsonCreator
	public static RaceControlScope fromId(String id) {
		for (RaceControlScope value : values())
			if (Objects.equals(value.id, id))
				return value;
		return UNKNOWN;
	}

	@Override
	public String toString() {
		return id;
	}
}
