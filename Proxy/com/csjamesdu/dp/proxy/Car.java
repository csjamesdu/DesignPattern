package com.csjamesdu.dp.proxy;
import java.util.Random;

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
