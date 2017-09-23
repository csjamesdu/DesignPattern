package com.csjamesdu.iterator.container;

public class LinkedList implements Collection{
	Node head = null;
	Node tail = null;
	int size = 0;
	
	public void add(Object o){
		Node n = new Node(o, null);
		if(head==null){
			head = n;
			tail = n;
			
			n.setNext(null);
		}else{
			tail.setNext(n);
			tail = n;
		}
		size++;
	}

	public int size() {
		return size;
	}

	@Override
	public Iterator iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator{
		Node n = head;
		@Override
		public Object next() {
			Object r = n.getData();
			n=n.getNext();
			return r;	
		}

		@Override
		public boolean hasNext() {
			if (head == null || n==tail.getNext())
				return false;
			else
				return true;
		}
		
	}
	
}
