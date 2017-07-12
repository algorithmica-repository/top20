package com.alg.top20.trie;

import java.util.List;

public interface ITrieSet {
	boolean add(String word);
	boolean contains(String word);
	void display();
	List<String> autocomplete(String prefix);
	boolean containsRE(String pattern);
	boolean remove(String word);
}
