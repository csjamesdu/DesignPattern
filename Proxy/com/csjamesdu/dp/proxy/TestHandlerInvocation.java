package com.csjamesdu.dp.proxy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestHandlerInvocation{
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
		m = (Movable)Proxy.newProxyInstance(Movable.class, h);
		m.move();
	}
	
	@Test
	public void testInvokeLogHandler() {
		h = new LogHandler(c);
		m = (Movable)Proxy.newProxyInstance(Movable.class, h);
		m.move();
	}

}
