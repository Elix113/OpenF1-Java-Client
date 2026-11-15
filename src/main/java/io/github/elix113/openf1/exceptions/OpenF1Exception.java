package io.github.elix113.openf1.exceptions;

/**
 * OpenF1Exception
 * @author Elias Weissensteiner
 * @since 2026-11-15
 */
public class OpenF1Exception extends RuntimeException {

	public OpenF1Exception(String message, Throwable cause) {
		super(message);
	}

	public OpenF1Exception(String message) {
		super(message);
	}
}
