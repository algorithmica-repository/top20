package com.alg.top20.trie;

import java.util.ArrayList;
import java.util.List;

class TSTNode {
	TSTNode left;
	TSTNode middle;
	TSTNode right;
	char data;
	boolean isword;

	TSTNode(char data) {
		this.data = data;
	}
}

public class TST {
	private TSTNode root;

	public TST() {
		root = null;
	}

	public void add(String word) {
		TSTNode tmp = auxAdd(root, word);
		if (root == null)
			root = tmp;
	}

	private TSTNode auxAdd(TSTNode current, String word) {
		if (current == null) {
			current = new TSTNode(word.charAt(0));
		}
		if (word.charAt(0) < current.data)
			current.left = auxAdd(current.left, word);
		else if (word.charAt(0) > current.data)
			current.right = auxAdd(current.right, word);
		else {
			if (word.length() == 1) {
				current.isword = true;
				return current;
			}
			current.middle = auxAdd(current.middle, word.substring(1));
		}
		return current;

	}

	public boolean contains(String word) {
		TSTNode tmp = findLastNode(word);
		if (tmp == null)
			return false;
		return tmp.isword;
	}

	private TSTNode findLastNode(String word) {
		if (word.length() == 0)
			return root;
		TSTNode current = root;
		int i = 0;
		while (current != null) {
			if (word.charAt(i) == current.data) {
				if (i == word.length() - 1)
					return current;
				++i;
				current = current.middle;
			} else if (word.charAt(i) < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return null;
	}

	public boolean remove(String word) {
		return false;
	}

	public List<String> autocomplete(String prefix) {
		ArrayList<String> words = new ArrayList<String>();
		if (prefix.length() == 0)
			inOrder(root, words, prefix);
		else {
			TSTNode tmp = findLastNode(prefix);
			if (tmp == null)
				return null;
			if (tmp.isword == true)
				words.add(prefix);
			inOrder(tmp.middle, words, prefix);
		}
		return words;
	}

	private void inOrder(TSTNode current, ArrayList<String> words, String word) {
		if (current == null)
			return;
		inOrder(current.left, words, word);
		if (current.isword == true)
			words.add(word + current.data);
		inOrder(current.middle, words, word + current.data);
		inOrder(current.right, words, word);
	}

	public void display() {
		auxDisplay(root, 4, "Root");
	}

	private static void auxDisplay(TSTNode root, int nspaces, String type) {
		if (root == null)
			return;
		for (int i = 0; i < nspaces; ++i)
			System.out.print(' ');
		System.out.println(root.data + "(" + type + ")");
		auxDisplay(root.left, nspaces + 4, "L");
		auxDisplay(root.middle, nspaces + 4, "M");
		auxDisplay(root.right, nspaces + 4, "R");
	}

	public static void main(String[] args) {
		String[] words = { "pqr", "abc", "abd", "ab", "xyz", "xab", "yz",
				"acx", "abcg", "aba" };
		TST tst = new TST();
		for (String word : words) {
			tst.add(word);
			tst.display();
		}
		System.out.println(tst.contains("abcd"));
		System.out.println(tst.contains("abd"));
		System.out.println(tst.autocomplete("a"));
		System.out.println(tst.autocomplete("ab"));
		System.out.println(tst.autocomplete("abd"));
		System.out.println(tst.autocomplete("de"));
		System.out.println(tst.autocomplete(""));

	}

}
