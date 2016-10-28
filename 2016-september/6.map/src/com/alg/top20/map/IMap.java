package com.alg.top20.map;


interface IMap {
	boolean put(String key, Integer value);
	Integer get(String key);
	boolean remove(String key);
	int size();
	void display();
	boolean containsKey(String key);
	boolean containsValue(Integer value);
}