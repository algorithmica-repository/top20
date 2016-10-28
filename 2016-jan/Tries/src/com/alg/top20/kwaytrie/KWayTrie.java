package com.alg.top20.kwaytrie;

import java.util.List;

import com.alg.top20.tst.Trie;

public class KWayTrie implements Trie {
	
	class TrieNode {
		boolean isword;
		TrieNode[] children;
		
		public TrieNode() {
			children = new TrieNode[26];
		}
	}

	@Override
	public void add(String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean remove(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> autocomplete(String prefix) {
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
