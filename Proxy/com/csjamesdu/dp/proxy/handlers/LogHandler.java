package com.csjamesdu.dp.proxy.handlers;

import java.lang.reflect.Method;

import com.csjamesdu.dp.proxy.intfc.InvocationHandler;

public class LogHandler implements InvocationHandler {
	
	private Object target;
	
	public LogHandler(Object o){
		super();
		this.target = o;
	}

	@Override
	public void invoke(Object o, Method m) {
		System.out.println("Log starts...");
		try {
			m.invoke(target);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		System.out.println("Log ends...");		
	}

}
