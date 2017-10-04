package com.alg.top20.dsdesign.cache;

public interface ICache {
	Integer get(String key);
	void add(String key, Integer value);
	void display();
}

