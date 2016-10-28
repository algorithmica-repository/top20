package com.alg.top20.list;

public class ArrayList implements IList {
	private Integer[] array;
	private int size;
	
	@Override
	public void display() {
		for(Integer e:array)
			System.out.print(e + " ");
		System.out.println();
		
	}

	public ArrayList() {
		array = new Integer[10];
		size = 0;
	}

	@Override
	public void add(Integer e) {
		Integer[] newarray;
		if(size == array.length) {
			newarray = new Integer[2*size];
			for(int i = 0; i < size; ++i)
				newarray[i] = array[i];
			array = newarray;
		}
		array[size++] = e;
	}

	@Override
	public void add(int ind, Integer e) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer get(int ind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void serialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deserialize() {
		// TODO Auto-generated method stub
		
	}
	
	

}
