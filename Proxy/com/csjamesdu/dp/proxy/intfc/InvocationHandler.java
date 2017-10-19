package com.csjamesdu.dp.proxy.intfc;

import java.lang.reflect.Method;

public interface InvocationHandler {
	public void invoke(Object o, Method m);
}
