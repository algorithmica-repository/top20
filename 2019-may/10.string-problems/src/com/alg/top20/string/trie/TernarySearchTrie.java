package com.alg.top20.string.trie;

import java.util.LinkedList;
import java.util.List;

class TernaryNode {
	TernaryNode left, middle, right;
	char data;
	boolean isword;
	public TernaryNode(char data) {
		this.data = data;
	}
}
public class TernarySearchTrie implements ITrie {
	private TernaryNode root;

	@Override
	public void add(String in) {
		TernaryNode tmp = auxAdd(root, in);
		if(root == null)
			root = tmp;
	}
	private TernaryNode auxAdd(TernaryNode current, String in) {
		if(current == null) 
			current = new TernaryNode(in.charAt(0));
		if(in.charAt(0) == current.data) {
			if(in.length() == 1) {
				current.isword = true;
				return current;
			}
			current.middle = auxAdd(current.middle, in.substring(1));
		}
		else if(in.charAt(0) < current.data)
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
	public void remove(String in) {
		// TODO Auto-generated method stub
		
	}

	private TernaryNode findLastNode(TernaryNode current, String in) {
		if(current == null) return null;
		if(in.charAt(0) == current.data) {
			if(in.length() == 1) return current;
			return findLastNode(current.middle, in.substring(1));
		}
		else if(in.charAt(0) < current.data)
			return findLastNode(current.left, in);	
		else
			return findLastNode(current.right, in);
	}
	private void traverse(TernaryNode current, String prefix, List<String> result) {
		if(current == null) return;
		traverse(current.left, prefix, result);
		if(current.isword == true)
			result.add(prefix+current.data);
		traverse(current.middle, prefix+current.data, result);
		traverse(current.right, prefix, result);
	}
	@Override
	public List<String> autocomplete(String prefix) {
		List<String> result = new LinkedList<String>();
		if(prefix.length() == 0)
			traverse(root, prefix, result);
		else {
			TernaryNode tmp = findLastNode(root, prefix);
			if(tmp == null) return null;
			if(tmp.isword == true) result.add(prefix);
			traverse(tmp.middle, prefix, result);
		}
		return result;
	}

	@Override
	public String lcp(String in) {
		TernaryNode current = root;
		int i = 0;
		while(current != null && i < in.length()) {
			if(in.charAt(i) == current.data) { 
				current = current.middle;
				++i;
			}
			else if(in.charAt(i) < current.data)
					current = current.left;
			else 
				current = current.right;
		}
		return in.substring(0, i);
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}


}
