package com.alg.top20.cache;

public interface ICache {
	Integer get(String key);
	void add(String key, Integer value);
	void display();
	int capacity();
	int size();
}

//ICache<K,V>
