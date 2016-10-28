package com.alg.top20.pqueue;

public interface IPQueue {
	void add(Integer key);
	Integer removeMin();
	Integer findMin();
	int size();
	void display();
}
