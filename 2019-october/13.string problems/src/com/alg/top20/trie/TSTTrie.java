package com.alg.top20.trie;

import java.util.LinkedList;
import java.util.List;

class TSTNode {
	boolean isword;
	char data;
	TSTNode left, right, middle;

	public TSTNode(char data) {
		this.data = data;
	}
}

public class TSTTrie implements ITrie {
	private TSTNode root;

	@Override
	public void add(String in) {
		auxAdd(root, in);
	}

	private TSTNode auxAdd(TSTNode current, String in) {
		if (current == null)
			current = new TSTNode(in.charAt(0));
		if (current.data == in.charAt(0)) {
			if (in.length() == 1) {
				current.isword = true;
				return current;
			}
			current.middle = auxAdd(current.middle, in.substring(1));
		}
		if (in.charAt(0) < current.data)
			current.left = auxAdd(current.left, in);
		else
			current.right = auxAdd(current.right, in);
		return current;
	}

	@Override
	public boolean contains(String in) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(String in) {
		// TODO Auto-generated method stub
		return false;
	}
	private TSTNode findLastNode(String in) {
		
	}
	
	private void traverse(TSTNode root, String word, List<String> res) {
		
	}

	@Override
	public List<String> autocomplete(String prefix) {
		TSTNode tmp = findLastNode(prefix);
		if(tmp == null) return null;
		List<String> res = new LinkedList<String>();
		traverse(tmp, prefix, res);
		return res;
	}

	@Override
	public String lcp(String in) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub

	}

}
