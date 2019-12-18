package com.alg.top20.trie;

import java.util.LinkedList;
import java.util.List;

class RadixNode {
	boolean isword;
	RadixNode[] children;
	
	public RadixNode() {
		this.isword = false;
		children = new RadixNode[26];
	}
}
public class RadixTrie implements ITrie {
	private RadixNode root;
	
	public RadixTrie() {
		root = new RadixNode();
	}
	
	@Override
	public void add(String in) {
		RadixNode current = root;
		for(int i = 0; i < in.length(); ++i) {
			int ind = in.charAt(i) - 'a';
			if(current.children[ind] == null)
				current.children[ind] = new RadixNode();
			current = current.children[ind];
		}
		current.isword = true;		
	}

	@Override
	public boolean contains(String in) {
		RadixNode current = root;
		for(int i = 0; i < in.length(); ++i) {
			int ind = in.charAt(i) - 'a';
			if(current.children[ind] == null)
				return false;
			current = current.children[ind];
		}
		return current.isword;
	}

	@Override
	public boolean remove(String in) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void traverse(RadixNode current, String word, List<String> res) {
		if(current == null) return;
		if(current.isword == true) res.add(word);
		for(int i = 0; i < 26; ++i)
			traverse(current.children[i], word+ (char)('a'+i), res);
	}
	
	private RadixNode findLastNode(String in) {
		RadixNode current = root;
		for(int i = 0; i < in.length(); ++i) {
			int ind = in.charAt(i) - 'a';
			if(current.children[ind] == null)
				return null;
			current = current.children[ind];
		}
		return current;
	}
	

	@Override
	public List<String> autocomplete(String prefix) {
		RadixNode tmp = findLastNode(prefix);
		if(tmp == null) return null;
		List<String> res = new LinkedList<String>();
		traverse(tmp, prefix, res);
		return res;
	}

	@Override
	public String lcp(String in) {
		RadixNode current = root;
		int i;
		for(i = 0; i < in.length(); ++i) {
			int ind = in.charAt(i) - 'a';
			if(current.children[ind] == null)
				break;
			current = current.children[ind];
		}
		return in.substring(0, i);
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub

	}

}
