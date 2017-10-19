package com.csjamesdu.dp.proxy.handlers;

import java.lang.reflect.Method;

import com.csjamesdu.dp.proxy.intfc.InvocationHandler;

public class TimeHandler implements InvocationHandler{
	
	private Object target;
	
	public TimeHandler(Object target){
		super();
		this.target=target;
	}
	
	@Override
	public void invoke(Object o, Method m) {
		long start = System.currentTimeMillis();
		try {
			m.invoke(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Elapsed Time:"+ (end-start));
		
	}
}
