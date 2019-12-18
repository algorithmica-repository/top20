package com.alg.top20.string.trie;

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
		TSTNode tmp = auxAdd(root, in);
		if(root == null)
			root = tmp;		
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
		} else if (in.charAt(0) < current.data)
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
		TSTNode current = root;
		for(int i = 0; i < in.length(); ) {
			if(current == null) return null;
			if(in.charAt(i) == current.data) {
				current = current.middle;
				++i;
			} else if(in.charAt(i) < current.data)
				current = current.left;
			else 
				current = current.right;
		}
		return current;
	}
	
	private void traverse(TSTNode current, String word, List<String> res) {
		if(current == null) return;
		traverse(current.left, word, res);
		if(current.isword == true) res.add(word+current.data);
		traverse(current.middle, word+current.data, res);
		traverse(current.right, word, res);
	}

	@Override
	//fix the bug to add given prefix as part of result
	public List<String> autocomplete(String prefix) {
		TSTNode tmp = findLastNode(prefix);
		if(tmp == null) return null;
		List<String> res = new LinkedList<String>();
		if(tmp.isword == true)
			res.add(prefix);
		traverse(tmp, prefix, res);
		return res;
	}

	@Override
	public String lcp(String in) {
		TSTNode current = root;
		int i;
		for(i = 0; i < in.length(); ) {
			if(current == null) break;
			if(in.charAt(i) == current.data) {
				current = current.middle;
				++i;
			} else if(in.charAt(i) < current.data)
				current = current.left;
			else 
				current = current.right;
		}
		return in.substring(0, i);
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub

	}

}
