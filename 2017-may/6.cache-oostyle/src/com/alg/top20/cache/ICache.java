package com.alg.top20.cache;

public interface ICache {
	Integer get(String key);
	void put(String key, Integer value);
	void display();
}
