package com.alg.top20.trie;

import java.util.List;

public interface ITrie {
	boolean add(String word);
	boolean remove(String word);
	boolean contains(String word);
	List<String> autocomplete(String prefix);
	int findLongestPrefix(String s);
	void displayAll();
	void print();
}
