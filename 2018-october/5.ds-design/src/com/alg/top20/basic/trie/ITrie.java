package com.alg.top20.basic.trie;

import java.util.List;

public interface ITrie {
	void add(String s);
	boolean contains(String s);
	boolean remove(String s);
	List<String> autocomplete(String s);
	String longestCommonPrefix(String s);
	void display();
}
