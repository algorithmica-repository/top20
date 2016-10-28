package com.alg.top20.map;

public interface ISortedMap extends IMap {
	Integer findMin();
	Integer findMax();
	Integer select(int k);
	void findElementsInRange(Integer x, Integer y);
}
