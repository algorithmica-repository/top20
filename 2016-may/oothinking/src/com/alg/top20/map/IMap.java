package com.alg.top20.map;

public interface IMap {	
	boolean add(Integer k, String v);
	boolean containsKey(Integer k);
	boolean containsValue(String v);
	boolean remove(Integer k);
	String get(Integer k);
	boolean set(Integer k, String v);
	int size();
	void display();
}
