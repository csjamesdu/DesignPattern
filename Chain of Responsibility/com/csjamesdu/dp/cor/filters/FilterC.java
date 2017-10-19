package com.csjamesdu.dp.cor.filters;

import com.csjamesdu.dp.cor.chain.FilterChain;
import com.csjamesdu.dp.cor.model.Request;
import com.csjamesdu.dp.cor.model.Response;

public class FilterC implements Filter{


	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.setRequestStr(request.getRequestStr().replace("C", "c")+"->FilterC");
		
		chain.doFilter(request, response, chain);
		
		response.setResponseStr(response.getResponseStr()+"->FilterC");
	}

}
