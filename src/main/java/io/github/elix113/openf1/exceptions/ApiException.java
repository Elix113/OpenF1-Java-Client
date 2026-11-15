package io.github.elix113.openf1.exceptions;

import java.net.URI;

/**
 * ApiException
 * @author Elias Weissensteiner
 * @since 2026-11-15
 */
public class ApiException extends OpenF1Exception {

	private final int statusCode;
	private final URI uri;

	public ApiException(String message, int statusCode, URI uri) {
		super(message + ", (HTTP" + statusCode + "): " + uri);
		this.statusCode = statusCode;
		this.uri = uri;
	}

	public ApiException(int statusCode, URI uri) {
		super("Failed to fetch data, (HTTP" + statusCode + "): " + uri);
		this.statusCode = statusCode;
		this.uri = uri;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public URI getUri() {
		return uri;
	}
}
