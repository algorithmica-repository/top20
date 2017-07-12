package com.alg.top20.trie;

import java.util.List;

class TrieNode {
	boolean isword;
	TrieNode[] children;

	public TrieNode() {
		children = new TrieNode[26];
	}
}

public class RwayTrieSet implements ITrieSet {
	private TrieNode root;
	private int size;
	
	//todo: duplicate check
	@Override
	public boolean add(String word) {
		TrieNode current = root;
		TrieNode tmp;
		for(int i = 0; i < word.length(); ++i) {
			tmp = current.children[word.charAt(i)-'a'];
			if(tmp == null) {
				tmp = new TrieNode();
				current.children[word.charAt(i)-'a']= tmp;
			}
			current = tmp;
		}
		current.isword = true;
		
		return false;
	}

	@Override
	public boolean contains(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> autocomplete(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsRE(String pattern) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(String word) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
