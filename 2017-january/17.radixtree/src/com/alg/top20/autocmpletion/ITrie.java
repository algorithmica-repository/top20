package com.alg.top20.autocmpletion;

import java.util.List;

public interface ITrie {	
	void add(String key);
	boolean contains(String key);
	void remove(String key);
	void display();
	int size();
	List<String> autocomplete(String prefix);
	int findCommonPrefixLength(String key);
}
