package com.csjamesdu.dp.filterchain;

public class FilterB implements Filter {

	

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.setRequestStr(request.getRequestStr().replace("B", "b")+"->FilterB");
		
		chain.doFilter(request, response, chain);
		
		response.setResponseStr(response.getResponseStr()+"->FilterB");
	}

}
