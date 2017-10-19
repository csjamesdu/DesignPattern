package com.csjamesdu.dp.cor.filters;

import com.csjamesdu.dp.cor.chain.FilterChain;
import com.csjamesdu.dp.cor.model.Request;
import com.csjamesdu.dp.cor.model.Response;

public class FilterB implements Filter {

	

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.setRequestStr(request.getRequestStr().replace("B", "b")+"->FilterB");
		
		chain.doFilter(request, response, chain);
		
		response.setResponseStr(response.getResponseStr()+"->FilterB");
	}

}
