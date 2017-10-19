package com.csjamesdu.dp.abstractFactory.factory.impl;

import com.csjamesdu.dp.abstractFactory.car.impl.LuxuryCar;
import com.csjamesdu.dp.abstractFactory.intfc.Car;
import com.csjamesdu.dp.abstractFactory.intfc.CarFactory;


public class LuxuryCarFactory implements CarFactory{	

	@Override
	public Car getCar(String Type) {
		Car lcar = new LuxuryCar();
		if(Type.equalsIgnoreCase("SUV")){
			lcar.setBrand("BMW");
			lcar.setModel("X5");
			lcar.setEngine("5.0");
		} else if(Type.equalsIgnoreCase("Sedan")){
			lcar.setBrand("Benz");
			lcar.setModel("S300");
			lcar.setEngine("3.0L");
		} else if(Type.equalsIgnoreCase("Compact")){
			lcar.setBrand("Audi");
			lcar.setModel("A1");
			lcar.setEngine("1.8L");
		}
		return lcar;	
	}
	
	
}
