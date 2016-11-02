package com.alg.top20.trie;

import java.util.Queue;

public class RWayTrie implements ITrie {
	private RWayTrieNode root;
	private int size;
	

	public RWayTrie() {
		root = null;
		size = 0;
	}

	@Override
	public void add(String word) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean remove(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsWildCard(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Queue<String> autocomplete(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	class RWayTrieNode {
		boolean isword;
		RWayTrieNode[] children;
		
		public RWayTrieNode(int radix) {
			children = new RWayTrieNode[radix];
		}
	}

}
