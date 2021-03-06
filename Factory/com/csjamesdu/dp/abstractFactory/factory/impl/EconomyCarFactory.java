package com.csjamesdu.dp.abstractFactory.factory.impl;

import com.csjamesdu.dp.abstractFactory.intfc.Car;
import com.csjamesdu.dp.abstractFactory.intfc.CarFactory;
import com.csjamesdu.dp.abstractFactory.car.impl.EconomyCar;

public class EconomyCarFactory implements CarFactory{

	@Override
	public Car getCar(String Type) {
		Car ecar = new EconomyCar();
		if(Type.equalsIgnoreCase("Sedan")){
			ecar.setBrand("Toyota");
			ecar.setModel("Camry");
			ecar.setEngine("2.4L");
		}else if(Type.equalsIgnoreCase("SUV")){
			ecar.setBrand("KIA");
			ecar.setModel("Sportage");
			ecar.setEngine("3.0L");
		}else if(Type.equalsIgnoreCase("Compact")){
			ecar.setBrand("Suzuki");
			ecar.setModel("Swift");
			ecar.setEngine("1.8L");
		}
		return ecar;
	}
	
}
