package com.csjamesdu.dp.abstractFactory.car.impl;

import com.csjamesdu.dp.abstractFactory.intfc.Car;

public class EconomyCar implements Car{
	private String engine;
	private String model;
	private String brand;

	@Override
	public String getEngine() {
		return this.engine;
	}

	@Override
	public String getModel() {
		return this.model;
	}

	@Override
	public String getBrand() {
		return this.brand;
	}
	

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@Override
	public String toString(){
		return "Brand: "+ getBrand()+" EngineSize:"+ getEngine() + " Model:"+ getModel();
	}
}
