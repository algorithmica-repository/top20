package com.alg.top20.string;

import java.util.LinkedList;
import java.util.List;

class RadixTreeNode {
	RadixTreeNode[] children = new RadixTreeNode[26];
	boolean isword;
}

public class RadixTree implements ITrie {
	private RadixTreeNode root;

	public RadixTree() {
		root = new RadixTreeNode();
	}

	@Override
	public void add(String s) {
		RadixTreeNode current = root;
		for (int i = 0; i < s.length(); ++i) {
			int index = s.charAt(i) - 'a';
			if (current.children[index] == null)
				current.children[index] = new RadixTreeNode();
			current = current.children[index];
		}
		current.isword = true;
	}

	@Override
	public void remove(String s) {
		// TODO Auto-generated method stub

	}
	private RadixTreeNode findLastNode(String s) {
		RadixTreeNode current = root;
		for (int i = 0; i < s.length(); ++i) {
			int index = s.charAt(i) - 'a';
			if (current.children[index] == null)
				return null;
			current = current.children[index];
		}
		return current;
	}

	private void traverse(RadixTreeNode current, String word, List<String> res) {
		if(current == null) return;
		if(current.isword == true)
			res.add(word);
		for (int i = 0; i < 26; ++i) 
			traverse(current.children[i], word+(char)('a'+i), res);
	}
	@Override
	public List<String> autocomplete(String s) {
		RadixTreeNode current = findLastNode(s);
		if(current == null) return null;
		List<String> res = new LinkedList<String>();
		traverse(current, s, res);
		return res;
	}

	@Override
	public String lcp(String s) {
		RadixTreeNode current = root;
		int i = 0;
		for (; i < s.length(); ++i) {
			int index = s.charAt(i) - 'a';
			if (current.children[index] == null)
				break;
			current = current.children[index];
		}
		return s.substring(0, i);
	}

	@Override
	public void display() {
		auxDisplay(root, 0, 'R');
	}

	private static void auxDisplay(RadixTreeNode root, int nspaces, char type) {
		if (root == null)
			return;
		for (int i = 0; i < nspaces; ++i)
			System.out.print(' ');
		System.out.println(root.isword + "(" + type + ")");
		for (int i = 0; i < 26; ++i)
			auxDisplay(root.children[i], nspaces + 4, (char) ('a' + i));
	}
	
}
