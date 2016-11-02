package com.alg.top20.trie;

import java.util.Queue;

public class TernarySearchTree implements ITrie {
	private TSTNode root;
	private int size;

	public TernarySearchTree() {
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
		TSTNode current = root;
		int i = 0;
		while (true) {
			if (word.charAt(i) == current.data) {
				current = current.middle;
				++i;
			} else if (word.charAt(i) < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}

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

	class TSTNode {
		boolean isword;
		char data;
		TSTNode left, middle, right;

		public TSTNode(char data) {
			this.data = data;
			middle = left = right = null;
			isword = false;
		}
	}

}
