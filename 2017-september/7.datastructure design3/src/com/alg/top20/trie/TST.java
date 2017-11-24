package com.alg.top20.trie;

import java.util.LinkedList;
import java.util.List;

class TSTNode {
	TSTNode left;
	TSTNode right;
	TSTNode middle;
	boolean isword;
	char data;

	TSTNode(char data) {
		this.data = data;
	}
}

public class TST implements ITrie {
	private TSTNode root;

	//TC:O(m)
	//SC:O(1)
	public boolean add(String word) {
		TSTNode current = root, parent = null;
		int i = 0;

		while (i < word.length() && current != null) {
			parent = current;
			if (word.charAt(i) == current.data) {
				current = current.middle;
				i = i + 1;
			} else if (word.charAt(i) < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		//word already exist
		if (i == word.length()) {
			if(parent.isword == true) return false;
			parent.isword = true;
			return true;
		}
		//word does not exist
		TSTNode tmp = new TSTNode(word.charAt(i++));
		TSTNode start = tmp;
		while (i < word.length()) {
			tmp.middle = new TSTNode(word.charAt(i++));
			tmp = tmp.middle;
		}
		tmp.isword = true;
		//check if the word is the first one?
		if (parent != null) {
			if (start.data > parent.data)
				parent.right = start;
			else
				parent.left = start;
		} else {
			root = start;
		}
		return true;
	}

	@Override
	public boolean remove(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(String word) {
		TSTNode tmp = findLastPrefixNode(word);
		if(tmp == null) return false;
		return tmp.isword;
	}

	private TSTNode findLastPrefixNode(String word) {
		TSTNode current = root;
		int i = 0;
		while (i < word.length() && current != null) {
			if (word.charAt(i) == current.data) {
				if(i == word.length()-1) return current;
				current = current.middle;
				i = i + 1;
			} else if (word.charAt(i) < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if(current == null) return null;
		return current;
	}
	//TC:O(m+k)
	public List<String> autocomplete(String prefix) {
		TSTNode tmp = findLastPrefixNode(prefix);
		if(tmp == null) return null;
		List<String> words = new LinkedList<String>();
		inorder(tmp.middle, prefix, words);
		return words;
	}
	
	private void inorder(TSTNode current, String prefix, List<String> words) {
		if(current == null) return;
		inorder(current.left, prefix, words);
		if(current.isword == true) {
			words.add(prefix + current.data);
		}
		inorder(current.middle, prefix+current.data, words);
		inorder(current.right, prefix, words);
	}

	@Override
	public void displayAll() {
		List<String> words = new LinkedList<String>();
		inorder(root, "", words);
		System.out.println(words);
	}

	// TC:O(n ^ 2)
	// SC:O(n)
	private static void auxPrint(TSTNode root, int nspaces, String type) {
		if (root == null)
			return;
		for (int i = 0; i < nspaces; ++i)
			System.out.print(' ');
		System.out.println(root.data + "(" + type + "," + root.isword + ")" );
		auxPrint(root.left, nspaces + 4, "L");
		auxPrint(root.middle, nspaces + 4, "M");
		auxPrint(root.right, nspaces + 4, "R");
	}

	@Override
	public void print() {
		auxPrint(root, 0, "root");
		
	}

	@Override
	public int findLongestPrefix(String word) {
		TSTNode current = root;
		int i = 0;
		while (i < word.length() && current != null) {
			if (word.charAt(i) == current.data) {
				if(i == word.length()-1) break;
				current = current.middle;
				i = i + 1;
			} else if (word.charAt(i) < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return i;
	}

}
