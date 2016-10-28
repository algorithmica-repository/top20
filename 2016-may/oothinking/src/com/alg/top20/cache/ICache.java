package com.alg.top20.cache;

public interface ICache {
	void add(Integer key, String value);
	String get(Integer key);
	void display();
}
