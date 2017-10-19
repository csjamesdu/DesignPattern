package com.csjamesdu.dp.abstractFactory.factory.impl;

import com.csjamesdu.dp.abstractFactory.intfc.Car;
import com.csjamesdu.dp.abstractFactory.intfc.CarFactory;

public class CarFactoryPortal {
	public static Car getCar(CarFactory factory, String Type){
		
		return factory.getCar(Type);
	}
}
