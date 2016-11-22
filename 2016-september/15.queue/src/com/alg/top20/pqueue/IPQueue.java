package com.alg.top20.pqueue;

public interface IPQueue {
	void add(Integer e);
	Integer findMax();
	Integer removeMax();
	int size();
	void display();
}
