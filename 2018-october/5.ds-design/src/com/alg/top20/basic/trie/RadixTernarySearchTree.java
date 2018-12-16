package com.alg.top20.basic.trie;

import java.util.LinkedList;
import java.util.List;

class TSTNode {
	boolean isword;
	char data;
	TSTNode left, middle, right;

	public TSTNode(char data) {
		this.data = data;
		isword = false;
		left = middle = right = null;
	}
}

public class RadixTernarySearchTree implements ITrie {
	private TSTNode root;

	public RadixTernarySearchTree() {
		root = null;
	}

	@Override
	public void add(String s) {
		TSTNode tmp = auxAdd(root, s);
		if (root == null)
			root = tmp;
	}

	private TSTNode auxAdd(TSTNode root, String s) {
		if (root == null) {
			root = new TSTNode(s.charAt(0));
		}
		if (s.charAt(0) == root.data) {
			if (s.length() == 1) {
				root.isword = true;
				return root;
			}
			root.middle = auxAdd(root.middle, s.substring(1));
		} else if (s.charAt(0) < root.data) {
			root.left = auxAdd(root.left, s);
		} else {
			root.right = auxAdd(root.right, s);
		}
		return root;
	}

	@Override
	public boolean contains(String s) {
		TSTNode res = findLastNode(s);
		if(res == null) return false;
		return res.isword == true;
	}

	@Override
	public boolean remove(String s) {
		// TODO Auto-generated method stub
		return false;
	}

	private TSTNode findLastNode(String s) {
		TSTNode current = root;
		int i = 0;
		while(current != null) {
			if (s.charAt(i) == current.data) {
				if(i == s.length()-1) return current;
				++i;
				current = current.middle;
			}
			else if (s.charAt(i) < current.data)
				current = current.left;
			else
				current = current.right;
		}
		return null;
	}

	private void traverse(TSTNode root, String s, List<String> res) {
		if(root == null) return;
		traverse(root.left, s, res);
		if(root.isword == true)
			res.add(s+root.data);
		traverse(root.middle, s+root.data, res);
		traverse(root.right, s, res);
	}
	@Override
	public List<String> autocomplete(String s) {
		List<String> res = new LinkedList<String>();
		if(s.length() == 0) {
			traverse(root, s, res);
		}
		else {
			TSTNode current = findLastNode(s);
			if(current == null) return null;
			if(current.isword == true) res.add(s);
			traverse(current.middle, s, res);
		}
		return res;
	}

	@Override
	public String longestCommonPrefix(String s) {
		TSTNode current = root;
		int i = 0;
		while(current != null) {
			if (s.charAt(i) == current.data) {
				if(i == s.length()-1) return s;
				++i;
				current = current.middle;
			}
			else if (s.charAt(i) < current.data)
				current = current.left;
			else
				current = current.right;
		}
		return s.substring(0, i);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static void auxDisplay(TSTNode root, int nspaces, String type) {
		if (root == null)
			return;
		for (int i = 0; i < nspaces; ++i)
			System.out.print(' ');
		System.out.println("(" + root.data + "," + root.isword + "," + type
				+ ")");
		auxDisplay(root.left, nspaces + 4, "L");
		auxDisplay(root.middle, nspaces + 4, "M");
		auxDisplay(root.right, nspaces + 4, "R");
	}

	@Override
	public void display() {
		auxDisplay(root, 0, "Root");
	}

}
