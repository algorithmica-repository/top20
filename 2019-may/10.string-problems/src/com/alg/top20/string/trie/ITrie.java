package com.alg.top20.string.trie;

import java.util.List;

public interface ITrie {
	void add(String in);
	boolean contains(String in);
	void remove(String in);
	List<String> autocomplete(String prefix);
	String lcp(String in);
	int size();
}
