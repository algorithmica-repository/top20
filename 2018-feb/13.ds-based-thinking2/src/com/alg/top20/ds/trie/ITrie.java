package com.alg.top20.ds.trie;

import java.util.List;

public interface ITrie {
	boolean add(String key);
	boolean contains(String key);
	List<String> autocomplete(String prefix);
	void display();
}
