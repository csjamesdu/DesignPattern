package com.csjamesdu.dp.strategy;
import java.lang.Comparable;

public class DataSorter {
	
	public static Object[] bubbleSort(Object[] o){
		for(int i = o.length; i>0; i--){
			for(int j=0; j<i-1; j++){
				Comparable o1 = (Comparable)o[j];
				Comparable o2 = (Comparable)o[j+1];
				if(o1.compareTo(o2)>0) swap(o, j, j+1);				
			}
		}
		return o;
	}
	
	public static void swap(Object[] o, int i, int j){
		Object temp = o[i];
		o[i]=o[j];
		o[j]=temp;
	}
	
	public static void print(Object[] o){
		for(Object i:o){
			System.out.println(i);
		}
	}
	
	public static int[] bubbleSort(int[] a){
		int[] b = a;
		for(int i=0; i<b.length;i++){
			for(int j=0; j<b.length; j++){
				if(b[i]<b[j]){
					int t = b[i];
					b[i]=b[j];
					b[j]=t;
				}
			}
		}
		return b;
	}
	
	public static void print(int[] a){
		for(int i: a){
			System.out.println(i);
		}
	}
	
	public static void print(Cat[] a){
		for(Cat c:a){
			System.out.println(c);
		}
	}
}
