package com.alg.top20.tst;

import java.util.ArrayList;
import java.util.List;

public class TernarySearchTree implements Trie {
	private TSTNode root;
	private int size;

	class TSTNode {
		boolean isword;
		char data;
		TSTNode left;
		TSTNode right;
		TSTNode middle;

		public TSTNode(char data) {
			this.data = data;
		}
	}

	private TSTNode auxAdd(TSTNode current, String key) {
		if (current == null) {
			current = new TSTNode(key.charAt(0));
		}
		if (current.data == key.charAt(0)) {
			if (key.length() > 1) {
				current.middle = auxAdd(current.middle, key.substring(1));
			} else {
				current.isword = true;
				return current;
			}
		} else if (key.charAt(0) < current.data) {
			current.left = auxAdd(current.left, key);
		} else {
			current.right = auxAdd(current.right, key);
		}
		return current;

	}

	@Override
	public void add(String key) {
		TSTNode tmp = auxAdd(root, key);
		if (root == null)
			root = tmp;
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

	private TSTNode findLastNode(TSTNode current, String prefix) {
		if (current == null || prefix.length() == 0)
			return null;
		if (current.data == prefix.charAt(0)) {
			if (prefix.length() > 1)
				return findLastNode(current.middle, prefix.substring(1));
			else
				return current;
		} else if (prefix.charAt(0) < current.data) {
			return findLastNode(current.left, prefix);
		} else {
			return findLastNode(current.right, prefix);
		}
	}

	private void auxComplete(TSTNode current, String key, List<String> keys) {
		if (current == null)
			return;
		auxComplete(current.left, key, keys);
		if (current.isword == true) {
			keys.add(key + current.data);
		}
		auxComplete(current.middle, key + current.data, keys);
		auxComplete(current.right, key, keys);
	}

	@Override
	public List<String> autocomplete(String prefix) {
		List<String> keys = new ArrayList<String>();
		if (prefix.length() == 0) {
			auxComplete(root, "", keys);
		} else {
			TSTNode lastnode = findLastNode(root, prefix);
			if (lastnode == null)
				return null;
			auxComplete(lastnode.middle, prefix, keys);
		}
		return keys;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void display() {

	}

}
