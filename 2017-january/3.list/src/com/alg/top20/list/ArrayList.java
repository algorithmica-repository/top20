package com.alg.top20.list;

public class ArrayList implements IList {
	private int[] array;
	private int size;

	public ArrayList() {
		array = new int[11];
		size = 0;
	}
	//O(1)
	public Integer get(int index) {
		return array[index];
	}

	private void doubling() {
		int[] newarray = new int[2*array.length];
		for(int i = 0; i < array.length; ++i)
			newarray[i] = array[i];
		array = newarray;
	}
	//O(1) am
	public void add(Integer e) {
		if(size == array.length) {
			//System.out.println("doubling overhead");
			doubling();
		}
		array[size++] = e;
	}

	//O(n)
	public void display() {
		for(int i = 0; i < size; ++i)
			System.out.println(array[i]);
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
