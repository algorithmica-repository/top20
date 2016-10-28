package com.alg.top20.list;

public interface IList {
	int get(int ind);
	int size();
	void add(int e);
	void add(int ind, int e);
	void remove(int ind);
	void set(int ind, int e);
	void display();
	boolean contains(int e);
	void reverse();
}
