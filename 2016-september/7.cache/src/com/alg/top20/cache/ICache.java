package com.alg.top20.cache;

public interface ICache {
	void put(String key, Integer value);
	Integer get(String key);
	int size();
	int capacity();
	void display();	
}
