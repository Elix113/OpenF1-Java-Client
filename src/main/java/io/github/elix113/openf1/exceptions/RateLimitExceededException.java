package io.github.elix113.openf1.exceptions;

import java.net.URI;

/**
 * RateLimitExceededException
 * @author Elias Weissensteiner
 * @since 2026-11-15
 */
public class RateLimitExceededException extends ApiException {

	public RateLimitExceededException(URI uri) {
		super("Rate limit exceeded", 429, uri);
	}
}
