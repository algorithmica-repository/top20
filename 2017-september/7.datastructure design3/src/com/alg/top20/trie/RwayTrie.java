package com.alg.top20.trie;

import java.util.LinkedList;
import java.util.List;

class TrieNode {
	TrieNode[] children;
	static final int NCHILDREN = 26;
	boolean isword;
	TrieNode() {
		children = new TrieNode[NCHILDREN];
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
		TrieNode tmp = findLastPrefixNode(word);
		if(tmp == null) return false;
		return tmp.isword;
	}

	public TrieNode findLastPrefixNode(String word) {
		TrieNode current = root;
		for(int i = 0; i < word.length(); ++i) {
			int index = word.charAt(i)-'a';
			if(current.children[index] == null) 
				return null;
			current = current.children[index];
		}
		return current;
	}
	@Override
	public List<String> autocomplete(String prefix) {
		TrieNode tmp = findLastPrefixNode(prefix);
		if(tmp == null) return null;
		List<String> words = new LinkedList<String>();
		traverse(tmp, prefix, words);
		return words;
	}

	private void traverse(TrieNode root, String prefix, List<String> words) {
		if(root == null) return;		
		if(root.isword == true) 
			words.add(prefix);
		for(int i = 0; i < 26; ++i) {
			traverse(root.children[i], prefix+(char)('a'+i), words);
		}
	}
	public void displayAll() {
		List<String> words = new LinkedList<String>();
		traverse(root, "", words);
		System.out.println(words);		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int findLongestPrefix(String s) {
		// TODO Auto-generated method stub
		return 0;
	}

}
