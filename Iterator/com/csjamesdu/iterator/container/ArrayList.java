package com.csjamesdu.iterator.container;

public class ArrayList implements Collection{
	Object [] ol = new Object[10];
	int index = 0;
	
	public void add(Object o){
		if(index==ol.length){
			Object [] olnew = new Object[ol.length*2];
			System.arraycopy(ol, 0, olnew, 0, ol.length);
			ol = olnew;
		}
		
		ol[index]=o;
		index++;
	}
	
	public int size(){
		return this.index;
	}
	
	public Iterator iterator(){
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements Iterator{  //内部类定义ArrayListIterator
		private int currentIndex=0;
		@Override
		public Object next() {
			Object o = ol[currentIndex];
			currentIndex++;
			return o;
		}

		@Override
		public boolean hasNext() {
			if(currentIndex>=index)
				return false;
			else 
				return true;
		}
		
	}
}
