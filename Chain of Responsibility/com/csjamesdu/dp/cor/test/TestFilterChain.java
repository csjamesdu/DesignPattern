package com.csjamesdu.dp.cor.test;

import org.junit.Test;

import com.csjamesdu.dp.cor.chain.FilterChain;
import com.csjamesdu.dp.cor.model.Request;
import com.csjamesdu.dp.cor.model.Response;
import com.csjamesdu.dp.cor.model.filters.FilterA;
import com.csjamesdu.dp.cor.model.filters.FilterB;
import com.csjamesdu.dp.cor.model.filters.FilterC;

public class TestFilterChain {

	@Test
	public void test() {
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
