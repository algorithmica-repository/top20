package com.alg.top20.pqueue;

public interface IPriorityQueue {
	int size();
	void display();
	void add(Integer e);
	Integer findMin();
	Integer removeMin();
}
