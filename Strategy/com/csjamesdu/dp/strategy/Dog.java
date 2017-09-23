package com.csjamesdu.dp.strategy;
import java.lang.Comparable;

public class Dog implements Comparable<Dog>{
	private int size;
	
	public Dog(int size){
		super();
		this.size=size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	
	
	@Override
	public String toString(){
		return this.size+"";
	}

	@Override
	public int compareTo(Dog o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
