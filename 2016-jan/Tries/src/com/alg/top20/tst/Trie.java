package com.alg.top20.tst;

import java.util.List;

public interface Trie {
	void add(String key);
	boolean remove(String key);
	boolean contains(String key);
	List<String> autocomplete(String prefix);
	int size();
	void display();
}
