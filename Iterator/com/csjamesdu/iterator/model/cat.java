package com.csjamesdu.iterator.model;

public class cat {
	String name;
	int id;
	
	public cat(int id){
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		return "cat:"+id;
	}
}
