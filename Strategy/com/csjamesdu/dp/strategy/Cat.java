package com.csjamesdu.dp.strategy;

import java.util.Comparator;
import java.lang.Comparable;

public class Cat implements Comparable<Cat>{
	private int height;
	private int weight;
	
	private Comparator<Cat> comparator=new CatWeightComparator();
	
	public Cat(int height, int weight) {
		super();
		this.height = height;
		this.weight = weight;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public Comparator<Cat> getComparator() {
		return comparator;
	}
	
	public void setComparator(Comparator<Cat> comparator) {
		this.comparator = comparator;
	}
		
	@Override
	public String toString(){
		return height+"|"+weight;
	}
	@Override
	public int compareTo(Cat o) {
		return comparator.compare(this, o);
	}
	
}
