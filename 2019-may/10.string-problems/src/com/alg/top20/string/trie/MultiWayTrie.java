package com.alg.top20.string.trie;

import java.util.LinkedList;
import java.util.List;

class MultiWayNode {
	boolean isword;
	MultiWayNode[] children;
	
	public MultiWayNode() {
		isword = false;
		children = new MultiWayNode[26];
	}
}
public class MultiWayTrie implements ITrie {
	private MultiWayNode root;
	private int size;

	public MultiWayTrie() {
		root = new MultiWayNode();
	}
	@Override
	public void add(String in) {
		MultiWayNode current = root;
		for(int i = 0; i < in.length(); ++i) {
			if(current.children[in.charAt(i)-'a'] == null)
				current.children[in.charAt(i)-'a'] = new MultiWayNode();
			current = current.children[in.charAt(i)-'a'];
		}
		if(current.isword != true) ++size;
		current.isword = true;
	}

	@Override
	public boolean contains(String in) {
		MultiWayNode current = root;
		for(int i = 0; i < in.length(); ++i) {
			if(current.children[in.charAt(i)-'a'] == null) return false;
			current = current.children[in.charAt(i)-'a'];
		}
		return current.isword == true;
	}

	@Override
	public void remove(String in) {
		// TODO Auto-generated method stub
		
	}

	private void traverse(MultiWayNode current, String out, List<String> result) {
		if(current == null) return;
		if(current.isword == true)
			result.add(out);
		for(int i = 0; i < 26; ++i)
			traverse(current.children[i], out + (char)('a' + i), result);
	}
	private MultiWayNode findLastNode(String prefix) {
		MultiWayNode current = root;
		for(int i = 0; i < prefix.length(); ++i) {
			if(current.children[prefix.charAt(i)-'a'] == null) return null;
			current = current.children[prefix.charAt(i)-'a'];
		}
		return current;
	}
	@Override
	public List<String> autocomplete(String prefix) {
		List<String> result = new LinkedList<String>();
		MultiWayNode tmp = findLastNode(prefix);
		if(tmp == null) return null;
		traverse(tmp, prefix, result);
		return result;
	}

	@Override
	public String lcp(String in) {
		MultiWayNode current = root;
		int i;
		for(i = 0; i < in.length(); ++i) {
			if(current.children[in.charAt(i)-'a'] == null) break;
			current = current.children[in.charAt(i)-'a'];
		}
		return in.substring(0, i);
	}

	@Override
	public int size() {
		return size;
	}


}
