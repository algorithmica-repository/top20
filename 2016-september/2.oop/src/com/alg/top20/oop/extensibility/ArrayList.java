package com.alg.top20.oop.extensibility;

public class ArrayList implements IList{
	
	/*struct arryalist {
		int[] array;
		int size;
	}*/
	private int[] array;
	private int size;
	
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
	
	public int size() {
		return size;
	}
}
