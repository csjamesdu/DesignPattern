package com.csjamesdu.dp.abstractFactory.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.csjamesdu.dp.abstractFactory.factory.impl.*;
import com.csjamesdu.dp.abstractFactory.intfc.*;

public class TestCarFactory {

	@Test
	public void testGetCar() {
		List<Car> luxuryCars = new ArrayList<Car>();
		luxuryCars.add(CarFactoryPortal.getCar(new LuxuryCarFactory(), "Sedan"));
		luxuryCars.add(CarFactoryPortal.getCar(new LuxuryCarFactory(), "SUV"));
		luxuryCars.add(CarFactoryPortal.getCar(new LuxuryCarFactory(), "Compact"));
		for(Iterator<Car> iterator = luxuryCars.iterator(); iterator.hasNext();){
			System.out.println("Luxury Car Spec: "+iterator.next());
		}
		
		System.out.println("**************************");
		
		List<Car> economyCars = new ArrayList<Car>();
		economyCars.add(CarFactoryPortal.getCar(new EconomyCarFactory(), "Sedan"));
		economyCars.add(CarFactoryPortal.getCar(new EconomyCarFactory(), "SUV"));
		economyCars.add(CarFactoryPortal.getCar(new EconomyCarFactory(), "Compact"));
		for(Iterator<Car> iterator = economyCars.iterator(); iterator.hasNext();){
			System.out.println("Economy Car Spec: "+iterator.next());
		}
	}

}
