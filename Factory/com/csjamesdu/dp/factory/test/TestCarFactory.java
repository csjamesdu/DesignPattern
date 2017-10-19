package com.csjamesdu.dp.factory.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.csjamesdu.dp.factory.factory.impl.CarFactoryImpl;
import com.csjamesdu.dp.factory.intfc.*;
import com.csjamesdu.dp.factory.factory.impl.*;

public class TestCarFactory {

	@Test
	public void testGetCar() {
		List<Car> luxuryCars = new ArrayList<Car>();
		luxuryCars.add(CarFactoryImpl.getCar(new LuxuryCarFactory(), "Sedan"));
		luxuryCars.add(CarFactoryImpl.getCar(new LuxuryCarFactory(), "SUV"));
		luxuryCars.add(CarFactoryImpl.getCar(new LuxuryCarFactory(), "Compact"));
		for(Iterator<Car> iterator = luxuryCars.iterator(); iterator.hasNext();){
			System.out.println("Luxury Car Spec: "+iterator.next());
		}
		
		System.out.println("**************************");
		
		List<Car> economyCars = new ArrayList<Car>();
		economyCars.add(CarFactoryImpl.getCar(new EconomyCarFactory(), "Sedan"));
		economyCars.add(CarFactoryImpl.getCar(new EconomyCarFactory(), "SUV"));
		economyCars.add(CarFactoryImpl.getCar(new EconomyCarFactory(), "Compact"));
		for(Iterator<Car> iterator = economyCars.iterator(); iterator.hasNext();){
			System.out.println("Economy Car Spec: "+iterator.next());
		}
	}

}
