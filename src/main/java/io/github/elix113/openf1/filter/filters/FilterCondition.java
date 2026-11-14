package io.github.elix113.openf1.filter.filters;

import io.github.elix113.openf1.filter.BaseFilter;

/**
 * Operator
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public class FilterCondition<F extends BaseFilter, T> {

	private F filter;
	private String property;

	public FilterCondition(F filter, String property) {
		this.filter = filter;
		this.property = property;
	}

	private FilterConnector<F> condition(String comparator, T value) {
		this.filter.addParam(property, comparator, value);
		return new FilterConnector<>(filter);
	}

	public FilterConnector<F> eq(T value) {
		return condition("=", value);
	}

	public FilterConnector<F> gt(T value) {
		return condition(">", value);
	}

	public FilterConnector<F> ge(T value) {
		return condition(">=", value);
	}

	public FilterConnector<F> lt(T value) {
		return condition("<", value);

	}

	public FilterConnector<F> le(T value) {
		return condition("<=", value);
	}

	@SafeVarargs
	public final FilterConnector<F> in(T... values) {
		if (values != null) {
			for (T value : values)
				filter.addParam(property, "=", value);
		}
		return new FilterConnector<>(filter);
	}
}
