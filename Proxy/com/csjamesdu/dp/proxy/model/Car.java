package com.csjamesdu.dp.proxy.model;
import java.util.Random;

import com.csjamesdu.dp.proxy.intfc.Movable;

public class Car implements Movable{

	@Override
	public void move() {

		System.out.println("Car is moving....");
		try {
			Thread.sleep(new Random().nextInt(10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
	}


	
}
