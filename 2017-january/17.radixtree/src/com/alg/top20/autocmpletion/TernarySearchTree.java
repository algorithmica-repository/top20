package com.alg.top20.autocmpletion;

import java.util.LinkedList;
import java.util.List;

public class TernarySearchTree implements ITrie {
	private TSTNode root;
	private int size;

	private TSTNode auxAdd(TSTNode current, String key) {
		if (current == null) {
			current = new TSTNode(key.charAt(0));
		}
		if (key.charAt(0) == current.data) {
			if (key.length() > 1)
				current.middle = auxAdd(current.middle, key.substring(1));
			else
				current.isword = true;
		} else if (key.charAt(0) < current.data) {
			current.left = auxAdd(current.left, key);
		} else {
			current.right = auxAdd(current.right, key);
		}
		return current;
	}

	//O(k)  <=26 * k
	public void add(String key) {
		TSTNode tmp = auxAdd(root, key);
		if (root == null)
			root = tmp;
		++size;
	}

	//O(k)  <=26 * k
	public boolean contains(String key) {
		int i = 0;
		TSTNode current = root;
		while (i < key.length() && current != null) {
			if (key.charAt(i) < current.data)
				current = current.left;
			else if (key.charAt(i) > current.data)
				current = current.right;
			else  {
				if(i == key.length()-1) return current.isword;
				current = current.middle;
				++i;
			} 
		}
		return false;
	}

	@Override
	public void remove(String key) {
		// TODO Auto-generated method stub

	}

	private void auxDisplay(TSTNode current, String word, List<String> words) {
		if (current == null)
			return;
		auxDisplay(current.left, word, words);
		if (current.isword == true)
			words.add(word + current.data);
		auxDisplay(current.middle, word + current.data, words);
		auxDisplay(current.right, word, words);
	}

	//O(n*k)  
	public void display() {
		List<String> words = new LinkedList<String>();
		auxDisplay(root, "", words);
		System.out.println(words);
	}

	//O(1)
	public int size() {
		return size;
	}

	@Override
	public List<String> autocomplete(String prefix) {
		TSTNode current = root;
		int i = 0;

		while (i < prefix.length() && current != null) {
			if (prefix.charAt(i) < current.data)
				current = current.left;
			else if (prefix.charAt(i) > current.data)
				current = current.right;
			else if (prefix.charAt(i) == current.data) {
				if(i == prefix.length()-1) break;
				current = current.middle;
				++i;
			} else
				return null;
		}
		if(current == null) return null;
		
		List<String> words = new LinkedList<String>();
		if(current.isword == true) words.add(prefix);
		auxDisplay(current.middle, prefix, words);
		return words;
	}

	class TSTNode {
		char data;
		boolean isword;
		TSTNode left, middle, right;

		public TSTNode(char data) {
			this.data = data;
		}
	}

	@Override
	public int findCommonPrefixLength(String key) {
		TSTNode current = root;
		int common_len = 0;
		int i = 0;

		while (current != null) {
			if (key.charAt(i) < current.data)
				current = current.left;
			else if (key.charAt(i) > current.data)
				current = current.right;
			else {
				++common_len;
				if(i == key.length()-1) break;
				current = current.middle;
				++i;
			} 
		}
		return common_len;
	}

}
