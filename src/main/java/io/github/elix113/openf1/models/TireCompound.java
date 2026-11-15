package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;

public enum TireCompound {

	SOFT("SOFT"),
	MEDIUM("MEDIUM"),
	HARD("HARD"),
	UNKNOWN("unknown");

	private final String id;

	TireCompound(String id) {
		this.id = id;
	}

	@JsonCreator
	public static TireCompound fromId(String id) {
		for (TireCompound value : values())
			if (Objects.equals(value.id, id))
				return value;
		return UNKNOWN;
	}

	@Override
	public String toString() {
		return id;
	}
}
