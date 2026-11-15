package io.github.elix113.openf1.filter;

/**
 * FilterConnector
 * @author Elias Weissensteiner
 * @since 2026-11-14
 */
public class FilterConnector<F extends BaseFilter> {

	private F filter;

	public FilterConnector(F filter) {
		this.filter = filter;
	}

	public F and() {
		return this.filter;
	}

	public F build() {
		return this.filter;
	}
}
