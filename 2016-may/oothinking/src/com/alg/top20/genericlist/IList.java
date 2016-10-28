package com.alg.top20.genericlist;

public interface IList<T> {	
	void add(T e);
	void add(int ind, T e);
	T get(int ind);
	void display();
}
