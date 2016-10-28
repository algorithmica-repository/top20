package com.alg.top20.list;

public interface IList {	
	void add(Integer e);
	void add(int ind, Integer e);
	Integer get(int ind);
	void display();
	void serialize();
	void deserialize();
}
