package com.csjamesdu.dp.factory.factory.impl;

import com.csjamesdu.dp.factory.intfc.Car;
import com.csjamesdu.dp.factory.intfc.CarFactory;

public class CarFactoryImpl {
	public static Car getCar(CarFactory factory, String Type){
		
		return factory.getCar(Type);
	}
}
