package com.csjamesdu.dp.strategy.comparator.test;

import org.junit.Test;

import com.csjamesdu.dp.strategy.comparator.model.Cat;
import com.csjamesdu.dp.strategy.comparator.model.Dog;
import com.csjamesdu.dp.strategy.comparator.util.DataSorter;

public class TestStrategy {

	@Test
	public void test() {
		Cat[] c = {new Cat(1,8), new Cat(5,4), new Cat(3,6), new Cat(7,2)};
		
		Dog[] d = {new Dog(3), new Dog(1), new Dog(4), new Dog(2), new Dog(6), new Dog(9)};

		DataSorter.bubbleSort(d);
		DataSorter.print(d);
		System.out.println("**********");
		DataSorter.bubbleSort(c);
		DataSorter.print(c);
	}

}
