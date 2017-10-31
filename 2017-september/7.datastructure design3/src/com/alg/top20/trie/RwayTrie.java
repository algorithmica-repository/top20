package com.alg.top20.trie;

import java.util.List;

class TrieNode {
	TrieNode[] children;
	boolean isword;
	TrieNode() {
		children = new TrieNode[26];
	}
}

public class RwayTrie implements ITrie {
	private TrieNode root;
	
	public RwayTrie() {
		root = new TrieNode();
	}
	
	//TC:O(m)
	public boolean add(String word) {
		TrieNode current = root;
		for(int i = 0; i < word.length(); ++i) {
			int index = word.charAt(i)-'a';
			if(current.children[index] == null) {
				current.children[index] = new TrieNode();
			}
			current = current.children[index];
		}
		if(current.isword == true) return false;
		current.isword = true;
		return true;
	}

	@Override
	public boolean remove(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	//TC:O(m)
	public boolean contains(String word) {
		TrieNode current = root;
		for(int i = 0; i < word.length(); ++i) {
			int index = word.charAt(i)-'a';
			if(current.children[index] == null) 
				return false;
			current = current.children[index];
		}
		return current.isword;
	}

	@Override
	public List<String> autocomplete(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

}
