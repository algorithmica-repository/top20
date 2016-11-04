package com.alg.top20.trie;

import java.util.LinkedList;
import java.util.Queue;

public class TernarySearchTree implements ITrie {
	private TSTNode root;
	private int size;

	public TernarySearchTree() {
		root = null;
		size = 0;
	}
	private TSTNode auxAdd(TSTNode root, String word) {
		if(root == null) {
			root = new TSTNode(word.charAt(0));
		}
		if(word.charAt(0) == root.data) {
			if(word.length() == 1) {
				root.isword = true;
				return root;
			}
			root.middle = auxAdd(root.middle, word.substring(1));			
		} else if(word.charAt(0) < root.data) {
			root.left = auxAdd(root.left, word);
		} else {
			root.right = auxAdd(root.right, word);
		}
		return root;
	}

	@Override
	public void add(String word) {
		TSTNode tmp = auxAdd(root, word);
		if(root == null)
			root = tmp;
		++size;
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
		while (current != null) {
			if (word.charAt(i) == current.data) {
				if(i == word.length()-1) return current.isword;
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
		TSTNode current = root;
		int i = 0;
		while (current != null) {
			if (prefix.charAt(i) == current.data) {
				if(i == prefix.length()-1) break;
				current = current.middle;
				++i;
			} else if (prefix.charAt(i) < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		Queue<String> words = new LinkedList<String>();
		if(current.isword == true) words.add(prefix);
		auxDisplay(current.middle, prefix, words );
		return words;
	}

	private void auxDisplay(TSTNode root, String word, Queue<String> words) {
		if(root == null) return;
		auxDisplay(root.left, word, words);
		if(root.isword == true) {
			words.add(word + root.data);
		}
		auxDisplay(root.middle, word + root.data, words);
		auxDisplay(root.right, word, words);
	}
	@Override
	public void display() {
		Queue<String> words = new LinkedList<String>();
		auxDisplay(root, "", words);
		System.out.println(words);
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
