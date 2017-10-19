package com.csjamesdu.dp.cor.filters;

import com.csjamesdu.dp.cor.chain.FilterChain;
import com.csjamesdu.dp.cor.model.Request;
import com.csjamesdu.dp.cor.model.Response;

public interface Filter {
	void doFilter(Request request, Response response, FilterChain chain);
}
