package com.alg.top20.list;

public class ArrayList extends AbstractList {
	
	/*struct arryalist {
		int[] array;
		int size;
	}*/
	private int[] array;
	
/*	void init(struct arraylist* list) {
		
	}*/
	public ArrayList() {
		array = new int[10];
		size = 0;
	}
	/* int get(struct arraylist* list, int ind) {
	 * }
	 */
	public int get(int ind) {
		//O(1)
		return array[ind];
	}
	
	@Override
	public void add(int e) {
		//O(1) amortized
		if(size == array.length) {
			int[] newarray = new int[2*size];
			for(int i = 0; i < size; ++i)
				newarray[i] = array[i];
			array = newarray;
		}
		array[size++] = e;		
	}
	
	@Override
	public void add(int ind, int e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove(int ind) {
		//O(n)
		--size;
		for(int i = ind; i < size; ++i)
			array[ind] = array[ind+1];
	}
	@Override
	public void set(int ind, int e) {
		//O(1)
		array[ind] = e;		
	}
	@Override
	public void display() {
		//O(n)
		for(int i = 0; i < size; ++i)
			System.out.print(array[i] + " ");
		System.out.println();
		
	}
	@Override
	public boolean contains(int e) {
		//O(n)
		for(int i = 0; i < size; ++i) {
			if(array[i] == e) return true;			
		}
		return false;
	}
	
	
}
