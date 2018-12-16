package com.alg.top20.basic.trie;

import java.util.List;

class TreeNode {
	boolean isword;
	TreeNode[] children;
	public TreeNode() {
		children = new TreeNode[26];
		isword = false;
	}
}
public class RadixMultiWayTree implements ITrie {
	private TreeNode root;
	
	public RadixMultiWayTree() {
		
	}
	@Override
	public void add(String s) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(String s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(String s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> autocomplete(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String longestCommonPrefix(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
