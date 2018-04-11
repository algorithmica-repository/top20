package com.alg.top20.ds.trie;

import java.util.LinkedList;
import java.util.List;

public class TSTTrie implements ITrie {
	private TSTNode root;
	
	public TSTTrie() {
		
	}
	private TSTNode auxAdd(TSTNode root, String key) {
		if(root == null) {
			root = new TSTNode(key.charAt(0));
		}
		if(key.charAt(0) == root.data) {
			if(key.length() > 1)
				root.middle = auxAdd(root.middle, key.substring(1));
			else {
				root.isword = true;
				return root;
			}
		} else if(key.charAt(0) < root.data){
			root.left = auxAdd(root.left, key);
		} else {
			root.right = auxAdd(root.right, key);
		}
		return root;		
	}
	@Override
	public  boolean add(String key) {
		TSTNode res = auxAdd(root, key);
		if(root == null) 
			root = res;
		return true;
	}

	@Override
	public boolean contains(String key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void inOrder(TSTNode root, String word, List<String> words) {
		if(root == null) return;
		inOrder(root.left, word, words);
		if(root.isword == true) 
			words.add(word+root.data);
		inOrder(root.middle, word+root.data, words);
		inOrder(root.right, word, words);
	}

	private TSTNode findPrefixLastNode(TSTNode root, String prefix) {
		int i = 0;
		while(i < prefix.length() && root != null) {
			if(prefix.charAt(i) == root.data) {
				if(i == prefix.length()-1) return root;
				root = root.middle;
				++i;
			}
			else if(prefix.charAt(i) < root.data) 
				root = root.left;
			else
				root = root.right;
		}
		return root;
	}
	@Override
	public List<String> autocomplete(String prefix) {
		List<String> words = new LinkedList<String>();
		TSTNode tmp = findPrefixLastNode(root, prefix);
		if(tmp == null)  return null;
		if(tmp.isword == true) words.add(prefix);
		inOrder(prefix.length()==0?tmp:tmp.middle, prefix, words);
		return words;
	}

	private static void auxDisplay(TSTNode root, int nspaces, char type) {
		if(root == null) return;
		for(int i = 0; i < nspaces; ++i)
			System.out.print(' ');
		System.out.println("(" + root.data + "," + type + "," + root.isword + ")");
		auxDisplay(root.left, nspaces+4, 'L');
		auxDisplay(root.middle, nspaces + 4, 'M');		
		auxDisplay(root.right, nspaces + 4, 'R');
	}
	@Override
	public void display() {
		auxDisplay(root, 0, 'R');
	}

}
