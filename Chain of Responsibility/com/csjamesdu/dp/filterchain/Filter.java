package com.csjamesdu.dp.filterchain;

public interface Filter {
	void doFilter(Request request, Response response, FilterChain chain);
}
