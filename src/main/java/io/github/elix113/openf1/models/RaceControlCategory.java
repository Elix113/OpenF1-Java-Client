package io.github.elix113.openf1.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;

public enum RaceControlCategory {

	SESSION_STATUS("SessionStatus"),
	CAR_EVENT("CarEvent"),
	DRS("Drs"),
	FLAG("Flag"),
	SAFETY_CAR("SafetyCar"),
	UNKNOWN("unknown");

	private final String id;

	RaceControlCategory(String id) {
		this.id = id;
	}

	@JsonCreator
	public static RaceControlCategory fromId(String id) {
		for (RaceControlCategory value : values())
			if (Objects.equals(value.id, id))
				return value;
		return UNKNOWN;
	}

	@Override
	public String toString() {
		return id;
	}
}
