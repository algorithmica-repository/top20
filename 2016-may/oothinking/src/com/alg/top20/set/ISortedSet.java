package com.alg.top20.set;

public interface ISortedSet extends ISet {
	Integer findMin();
	Integer findMax();
	Integer select(int k);
	void findElementsInRange(Integer x, Integer y);
}
