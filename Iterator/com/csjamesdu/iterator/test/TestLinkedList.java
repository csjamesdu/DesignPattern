package com.csjamesdu.iterator.test;
import com.csjamesdu.iterator.container.Iterator;
import com.csjamesdu.iterator.container.LinkedList;
import com.csjamesdu.iterator.model.cat;

public class TestLinkedList {
	public static void main(String[] args){
		LinkedList list = new LinkedList();
		for(int i=0;i<15;i++){
			list.add(new cat(i));
		}
		
		System.out.println(list.size());
		
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
