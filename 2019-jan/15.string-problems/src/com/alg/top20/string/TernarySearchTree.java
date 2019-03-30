package com.alg.top20.string;

import java.util.LinkedList;
import java.util.List;

class TSTNode {
	boolean isword;
	char data;
	TSTNode left, middle, right;
	public TSTNode(char data) {
		this.data = data;
	}
}
public class TernarySearchTree implements ITrie {
	private TSTNode root;
	
	@Override
	public void add(String s) {
		TSTNode tmp = auxAdd(root, s);
		if(root == null)
			root = tmp;
	}
	private TSTNode auxAdd(TSTNode root, String s) {
		if(root == null) 
			root = new TSTNode(s.charAt(0));
		if(root.data == s.charAt(0)) {
			if(s.length() == 1)
				root.isword = true;
			else
				root.middle = auxAdd(root.middle, s.substring(1));
		} else if(s.charAt(0) < root.data)
			root.left = auxAdd(root.left, s);
		else
			root.right = auxAdd(root.right, s);
		return root;
	}

	@Override
	public void remove(String s) {
		// TODO Auto-generated method stub

	}

	private TSTNode findLastNode(String s) {
		TSTNode current = root;
		int i = 0;
		while(current != null) {
			if(current.data == s.charAt(i)) {
				++i;
				if(i == s.length()) break;
				current = current.middle;
			}
			else if(s.charAt(i) < current.data)
				current = current.left;
			else
				current = current.right;
		}
		return current;
	}

	private void traverse(TSTNode current, String word, List<String> res) {
		if(current == null) return;
		traverse(current.left, word, res);
		if(current.isword == true)
			res.add(word+current.data);
		traverse(current.middle, word+current.data, res);
		traverse(current.right, word, res);
	}
	@Override
	public List<String> autocomplete(String s) {
		TSTNode current;
		if(s.length() == 0) 
			current = root;
		else 
			current = findLastNode(s);
		if(current == null) return null;
		List<String> res = new LinkedList<String>();
		if(current.isword == true)
			res.add(s);
		traverse(s.length() == 0? current: current.middle, s, res);
		return res;
	}

	@Override
	public String lcp(String s) {
		TSTNode current = root;
		int i = 0;
		while(current != null) {
			if(current.data == s.charAt(i)) {
				current = current.middle;
				++i;
			}
			else if(s.charAt(i) < current.data)
				current = current.left;
			else
				current = current.right;
		}
		return s.substring(0, i);
	}

	@Override
	public void display() {
		auxDisplay(root, 0, "Root");
	}

	private static void auxDisplay(TSTNode root, int nspaces, String type) {
		if (root == null)
			return;
		for (int i = 0; i < nspaces; ++i)
			System.out.print(' ');
		System.out.println(root.data + "(" + type + "," + root.isword + ")");
		auxDisplay(root.left, nspaces + 4, "L");
		auxDisplay(root.middle, nspaces + 4, "M");
		auxDisplay(root.right, nspaces + 4, "R");
	}


}
