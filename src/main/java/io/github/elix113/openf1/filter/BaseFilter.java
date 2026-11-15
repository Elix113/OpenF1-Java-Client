package io.github.elix113.openf1.filter;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * BaseFilter
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public abstract class BaseFilter {

	protected final List<String> params = new ArrayList<>();

	public void addParam(String s) {
		params.add(s);
	}

	public void addParam(String property, String comparator, Object value) {
		if (value != null) {
			String encodedKey = URLEncoder.encode(property, StandardCharsets.UTF_8);
			String encodedComparator = "=".equals(comparator)
				? "="
				: URLEncoder.encode(comparator, StandardCharsets.UTF_8);
			String encodedValue = URLEncoder.encode(value.toString(), StandardCharsets.UTF_8);
//				.replace("+", "%20");
			params.add(encodedKey + encodedComparator + encodedValue);
		}
	}

	@Override
	public String toString() {
		return String.join("&", params);
	}

	public abstract String getFinalUrl();
//	public abstract <T> Class<T> getModelClass();
}
