package com.alg.top20.trie;

import java.util.Queue;

public class KwayTrie implements ITrie {
	private KwayNode root;

	class KwayNode {
		boolean isword;
		KwayNode[] children;
		
		public KwayNode() {
			children = new KwayNode[26];
		}
	}
	
	
	@Override
	public String findLongestCommonPrefix(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(String word) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Queue<String> autocomplete(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

}
