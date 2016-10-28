package com.alg.top20.oop.reuse;

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
		return array[ind];
	}
}
