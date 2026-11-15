package io.github.elix113.openf1.client;

import java.net.http.HttpResponse;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Supplier;

import io.github.elix113.openf1.exceptions.OpenF1Exception;
import io.github.elix113.openf1.exceptions.RateLimitExceededException;

/**
 * OpenF1RateLimiter
 * @author Elias Weissensteiner
 * @since 2026-11-15
 */
public class OpenF1RateLimiter {

    //30 requests/minute
    private static final int REQUESTS_PER_WINDOW = 30;
    private static final long WINDOW_MS = 60_000;
    //<3 = requests/second
    private static final long INTERVAL_MS = 350;
    //Retry settings after HTTP 429
    private static final long MAX_TRIES = 3;
    private static final long TIMEOUT_MS = 500;
    private static final double TIMEOUT_FACTOR = 2.0;


    private final Deque<Long> requestTimestamps = new ArrayDeque<>();
    private long lastRequestTime = 0;

    public synchronized void acquireToken() {
        long now = System.currentTimeMillis();

        //Allow Requests every INTERVAL_MS
        long timeSinceLast = now - lastRequestTime;
        if (timeSinceLast < INTERVAL_MS) {
            sleep(INTERVAL_MS - timeSinceLast);
            now = System.currentTimeMillis();
        }

        synchronized (requestTimestamps) {
            //Remove timestamps older then WINDOW_MS
            while (!requestTimestamps.isEmpty() && (now - requestTimestamps.peekFirst() > WINDOW_MS))
                requestTimestamps.pollFirst();

            //Wait for the oldest timestamp to be older then WINDOW_MS
            if (requestTimestamps.size() >= REQUESTS_PER_WINDOW) {
                long oldestAllowed = requestTimestamps.peekFirst() + WINDOW_MS;
                long waitTime = oldestAllowed - now;
                if (waitTime > 0) {
                    sleep(waitTime);
                    now = System.currentTimeMillis();
                }
                //Remove timestamps older then WINDOW_MS
                while (!requestTimestamps.isEmpty() && (now - requestTimestamps.peekFirst() > WINDOW_MS))
                    requestTimestamps.pollFirst();
            }

            //Add new Request
            requestTimestamps.addLast(now);
            lastRequestTime = now;
        }
    }

    public HttpResponse<String> executeWithRetry(Supplier<HttpResponse<String>> requestAction) {
        long timeout = TIMEOUT_MS;
        int attempt = 1;

        HttpResponse<String> response;
        do {
            acquireToken();
            response = requestAction.get();

            if (response.statusCode() == 429) {
                if (attempt >= MAX_TRIES)
                    throw new RateLimitExceededException(response.uri());

                sleep(timeout);
                timeout = (long)(timeout * TIMEOUT_FACTOR);
                attempt++;
            }
        } while(response.statusCode() == 429);

        return response;
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new OpenF1Exception("Rate limiter was interrupted", e);
        }
    }
}
