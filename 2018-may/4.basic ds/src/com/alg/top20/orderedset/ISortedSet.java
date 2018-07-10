package com.alg.top20.set;

public interface ISortedSet {
	boolean add(Integer key);
	boolean contains(Integer key);
	boolean remove(Integer key);
	int size();
	void display();
	Integer findMin();
	Integer select(int k);
}
