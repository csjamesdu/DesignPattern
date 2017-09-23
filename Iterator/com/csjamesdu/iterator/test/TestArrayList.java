package com.csjamesdu.iterator.test;

import com.csjamesdu.iterator.container.*;
import com.csjamesdu.iterator.model.cat;


public class TestArrayList {
	public static void main(String[] args){
		Collection al = new ArrayList();
		for(int i=0;i<15;i++){
			al.add(new cat(i));
		}
		
		System.out.println(al.size());
		
		Iterator it = al.iterator();
		while(it.hasNext()){
			Object o = it.next();
			System.out.println(o+" ");
		}
	}
}
