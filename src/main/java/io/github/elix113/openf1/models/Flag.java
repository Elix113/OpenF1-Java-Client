package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;

public enum Flag {

	GREEN("GREEN"),
	YELLOW("YELLOW"),
	DOUBLE_YELLOW("DOUBLE YELLOW"),
	RED("RED"),
	CHEQUERED("Flag"),
	CLEAR("CLEAR"),
	BLACK_AND_WHITE("BLACK AND WHITE"),
	NULL(null),
	UNKNOWN("unknown");

	private final String id;

	Flag(String id) {
		this.id = id;
	}

	@JsonCreator
	public static Flag fromId(String id) {
		for (Flag value : values())
			if (Objects.equals(value.id, id))
				return value;
		return UNKNOWN;
	}

	@Override
	public String toString() {
		return id;
	}
}
