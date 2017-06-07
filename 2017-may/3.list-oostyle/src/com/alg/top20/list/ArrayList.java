package com.alg.top20.list;

public class ArrayList implements List {
	private Integer[] array;
	private int size;
	
	//init method
	public ArrayList() {
		array = new Integer[10];
		size = 0;
	}
	//O(1) am
	public void add(Integer e) {
		if(size == array.length) {
			System.out.println("Doubling the array");
			Integer[] newarray = new Integer[2*array.length];
			for(int i = 0; i < array.length; ++i)
				newarray[i] = array[i];
			array = newarray;
		}
		array[size++] = e;			
	}
	
	//O(n)
	public void display() {
		for(int i = 0; i < size; ++i)
			System.out.print(array[i] + " ");
	}
	//O(1)
	public Integer get(int ind) {
		if(size == 0) return null; 
		return array[ind];
	}
}
