package com.alg.top20.set;

import java.util.List;

public interface ISortedSet extends ISet {
	int findMin();
	int select(int k);
	List<Integer> findRange(Integer s, Integer e);
}
