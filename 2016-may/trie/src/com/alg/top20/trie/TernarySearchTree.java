package com.alg.top20.trie;

import java.util.LinkedList;
import java.util.Queue;

public class TernarySearchTree implements ITrie {
	private TSTNode root;
	private int size;

	class TSTNode {
		boolean isword;
		char data;
		TSTNode left, right, middle;

		public TSTNode(char data) {
			this.data = data;
		}
	}
	
	
	@Override
	public String findLongestCommonPrefix(String word) {
		TSTNode current = root;
		String tmp = word;
		int ncommon = 0;
		while (current != null) {
			if (word.charAt(0) == current.data) {
				++ncommon;
				if (word.length() > 1) {
					current = current.middle;
					word = word.substring(1);
				} else
					break;
			} else if (word.charAt(0) < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}			
		}
		add(tmp);
		return tmp.substring(0,ncommon);
	}

	@Override
	public boolean contains(String word) {
		TSTNode current = findLastNode(word);
		if(current == null) return false;
		return current.isword == true;
	}

	private TSTNode auxAdd(TSTNode current, String word) {
		if (current == null) {
			current = new TSTNode(word.charAt(0));
		}
		if (word.charAt(0) == current.data) {
			if (word.length() > 1)
				current.middle = auxAdd(current.middle, word.substring(1));
			else {
				current.isword = true;
				return current;
			}
		} else if (word.charAt(0) < current.data) {
			current.left = auxAdd(current.left, word);
		} else {
			current.right = auxAdd(current.right, word);
		}
		return current;
	}

	@Override
	public void add(String word) {
		if (word.trim().length() == 0)
			return;
		TSTNode tmp = auxAdd(root, word.toLowerCase());
		if (root == null)
			root = tmp;
		++size;
	}

	@Override
	public boolean remove(String word) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private TSTNode containsRE(TSTNode current, String word) {
			if (word.charAt(0) == '?' || word.charAt(0) == current.data) {
				if (word.length() > 1) {
					containsRE(current.middle, word.substring(1));
				} else
					return current;
			} 
			if (word.charAt(0) == '?' || word.charAt(0) < current.data) {
				return containsRE(current.left, word);
			} 
			if (word.charAt(0) == '?' || word.charAt(0) > current.data) {
				return containsRE(current.right, word);
			}
			return null;
	}

	private TSTNode findLastNode(String prefix) {
		TSTNode current = root;
		while (current != null) {
			if (prefix.charAt(0) == current.data) {
				if (prefix.length() > 1) {
					current = current.middle;
					prefix = prefix.substring(1);
				} else
					return current;
			} else if (prefix.charAt(0) < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return null;
	}

	@Override
	public Queue<String> autocomplete(String prefix) {
		TSTNode current = findLastNode(prefix);
		if(current == null) return null;
		Queue<String> out = new LinkedList<String>();
		if(current.isword == true) out.add(prefix);
		auxDisplay(current.middle, prefix, out);
		return out;
	}

	@Override
	public int size() {
		return size;
	}

	private void auxDisplay(TSTNode current, String word, Queue<String> out) {
		if (current == null)
			return;
		auxDisplay(current.left, word, out);
		if (current.isword == true)
			out.add(word + current.data);
		auxDisplay(current.middle, word + current.data, out);
		auxDisplay(current.right, word, out);
	}

	@Override
	public void display() {
		Queue<String> out = new LinkedList<String>();
		auxDisplay(root, "", out);
		System.out.println(out);
	}

}
