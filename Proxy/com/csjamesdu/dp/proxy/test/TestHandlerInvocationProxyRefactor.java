package com.csjamesdu.dp.proxy.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.csjamesdu.dp.proxy.Proxy;
import com.csjamesdu.dp.proxy.ProxyRefactor;
import com.csjamesdu.dp.proxy.handlers.LogHandler;
import com.csjamesdu.dp.proxy.handlers.TimeHandler;
import com.csjamesdu.dp.proxy.intfc.InvocationHandler;
import com.csjamesdu.dp.proxy.intfc.Movable;
import com.csjamesdu.dp.proxy.model.Car;

public class TestHandlerInvocationProxyRefactor {
	private Car c ;
	private InvocationHandler h;
	private Movable m;
	
	@Before
	public void init() {
		c = new Car();
	}

	@Test
	public void testInvokeTimeHandler() {
		h = new TimeHandler(c);
		m = (Movable)ProxyRefactor.newProxyInstance(Movable.class, h);
		m.move();
	}
	
	@Test
	public void testInvokeLogHandler() {
		h = new LogHandler(c);
		m = (Movable)ProxyRefactor.newProxyInstance(Movable.class, h);
		m.move();
	}

}
