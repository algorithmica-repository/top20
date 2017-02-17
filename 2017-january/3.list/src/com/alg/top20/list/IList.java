package com.alg.top20.list;

//Apply abstraction: usage perspective of an object
public interface IList {
	Integer get(int index);
	void add(Integer e);
	void display();
	int size();
}
