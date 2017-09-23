package com.csjamesdu.dp.filterchain;

public class FilterC implements Filter{


	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.setRequestStr(request.getRequestStr().replace("C", "c")+"->FilterC");
		
		chain.doFilter(request, response, chain);
		
		response.setResponseStr(response.getResponseStr()+"->FilterC");
	}

}
