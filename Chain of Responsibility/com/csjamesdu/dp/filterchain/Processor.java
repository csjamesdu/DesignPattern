package com.csjamesdu.dp.filterchain;


public class Processor {

	public static void main(String[] args) {
		String pre_msg = "A | B | C";
		Request request= new Request();
		request.setRequestStr(pre_msg);
		Response response = new Response();
		response.setResponseStr("default response | ");
		
		FilterChain chain = new FilterChain();
		chain.addFilter(new FilterA()).addFilter(new FilterB()).addFilter(new FilterC());
		
		chain.doFilter(request, response, chain);
		System.out.println("Post Process Request:"+request.getRequestStr());
		System.out.println("Post Process Response:"+response.getResponseStr());
	}

}
