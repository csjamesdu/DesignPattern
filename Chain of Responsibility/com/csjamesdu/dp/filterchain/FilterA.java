package com.csjamesdu.dp.filterchain;

public class FilterA implements Filter{

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.setRequestStr(request.getRequestStr().replace("A", "a")+"->FilterA");	
		chain.doFilter(request, response, chain);
		response.setResponseStr(response.getResponseStr()+"->FilterA");
	}

}
