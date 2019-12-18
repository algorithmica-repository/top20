package com.alg.top20.trie;

import java.util.List;

public interface ITrie {
	void add(String in);
	boolean contains(String in);
	boolean remove(String in);
	List<String> autocomplete(String prefix);
	String lcp(String in);
	void print();
}
