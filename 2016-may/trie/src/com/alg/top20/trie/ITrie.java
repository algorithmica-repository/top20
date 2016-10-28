package com.alg.top20.trie;

import java.util.Queue;

public interface ITrie {	
	public void add(String word);
	public boolean contains(String word);
	public boolean remove(String word);
	public Queue<String> autocomplete(String prefix);
	public int size();
	public void display();
	public String findLongestCommonPrefix(String word);
}
