package com.alg.top20.trie;

import java.util.ArrayList;
import java.util.List;

class TSTNode {
	boolean isword;
	TSTNode left;
	TSTNode middle;
	TSTNode right;
	char data;

	public TSTNode(char data) {
		super();
		this.data = data;
	}
}

public class TSTTrie implements ITrieSet {
	private TSTNode root;
	private int size;

	@Override
	public boolean add(String word) {
		MyBoolean isDuplicate = new MyBoolean();
		TSTNode res = auxAdd(root, word, isDuplicate);
		if (root == null)
			root = res;
		if (isDuplicate.get() == false)
			++size;
		return isDuplicate.get();
	}

	private TSTNode auxAdd(TSTNode root, String word, MyBoolean isDuplicate) {
		if (root == null) {
			root = new TSTNode(word.charAt(0));
		}
		if (root.data == word.charAt(0)) {
			if (word.length() == 1) {
				if (root.isword == true)
					isDuplicate.set(true);
				else
					root.isword = true;
				return root;
			} else
				root.middle = auxAdd(root.middle, word.substring(1),
						isDuplicate);
		} else if (word.charAt(0) < root.data) {
			root.left = auxAdd(root.left, word, isDuplicate);
		} else {
			root.right = auxAdd(root.right, word, isDuplicate);
		}
		return root;
	}

	@Override
	public boolean contains(String word) {
		return findLastNode(word).isword == true;
	}

	private static void auxDisplay(TSTNode root, int nspaces) {
		for (int i = 0; i < nspaces; ++i)
			System.out.print(' ');
		if (root == null) {
			System.out.println(-1);
			return;
		} else {
			System.out.println(root.data);
			// if(root.left == null && root.right == null) return;
		}
		auxDisplay(root.left, nspaces + 4);
		auxDisplay(root.middle, nspaces + 4);
		auxDisplay(root.right, nspaces + 4);
	}

	@Override
	public void display() {
		auxDisplay(root, 0);
	}

	private TSTNode findLastNode(String word) {
		if(word.trim().length() == 0) return root;
		TSTNode current = root;
		while (current != null) {
			if (word.charAt(0) < current.data)
				current = current.left;
			else if (word.charAt(0) > current.data)
				current = current.right;
			else {
				if (word.length() > 1) {
					current = current.middle;
					word = word.substring(1);
				} else
					break;
			}
		}
		if (current == null)
			return null;
		return current;
	}

	private void auxCollect(TSTNode root, String prefix, List<String> words) {
		if (root == null)
			return;
		auxCollect(root.left, prefix, words);
		if (root.isword == true)
			words.add(prefix + root.data);
		auxCollect(root.middle, prefix + root.data, words);
		auxCollect(root.right, prefix, words);
	}

	@Override
	public List<String> autocomplete(String prefix) {
		TSTNode tmp = findLastNode(prefix);
		if(tmp == null) return null;
		List<String> words = new ArrayList<String>();
		if(tmp.isword == true) words.add(prefix);
		auxCollect(tmp == root? root:tmp.middle, prefix, words);
		return words;
	}

	@Override
	public boolean containsRE(String pattern) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		String[] words = { "cde", "abc", "aaa", "ab", "abd", "xyz", "xab" };
		ITrieSet set = new TSTTrie();
		for (int i = 0; i < words.length; ++i)
			set.add(words[i]);
		// set.display();
		System.out.println(set.autocomplete(""));
		System.out.println(set.autocomplete("ab"));
	}

}
