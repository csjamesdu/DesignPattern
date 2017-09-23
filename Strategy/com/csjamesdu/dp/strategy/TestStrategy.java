package com.csjamesdu.dp.strategy;

public class TestStrategy {
	public static void main(String[] args) {
		
		Cat[] c = {new Cat(1,8), new Cat(5,4), new Cat(3,6), new Cat(7,2)};
		
		Dog[] d = {new Dog(3), new Dog(1), new Dog(4), new Dog(2), new Dog(6), new Dog(9)};

		DataSorter.bubbleSort(d);
		DataSorter.print(d);
		System.out.println("**********");
		DataSorter.bubbleSort(c);
		DataSorter.print(c);
	}
}
