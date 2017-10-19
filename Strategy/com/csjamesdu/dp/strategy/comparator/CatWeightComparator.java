package com.csjamesdu.dp.strategy.comparator;

import com.csjamesdu.dp.strategy.comparator.model.Cat;

public class CatWeightComparator implements java.util.Comparator<Cat> {

	@Override
	public int compare(Cat c1, Cat c2) {

		if(c1.getWeight()>c2.getWeight()) return 1;
		else if(c1.getWeight()<c2.getWeight()) return -1;
		else return 0;
	}

}
