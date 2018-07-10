package com.alg.top20.trie.maxor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class TrieNode {
	TrieNode[] children;
	static final int NCHILDREN = 2;
	int value;
	TrieNode() {
		children = new TrieNode[NCHILDREN];
	}
}

class RwayTrie {
	private TrieNode root;
	public RwayTrie() {
		root = new TrieNode();
	}	

	public void add(int key) {
		TrieNode current = root;
		for(int i = 31; i >= 0; --i) {
			int bit = (key & (1 << i)) == 0?0:1;
			if(current.children[bit] == null) {
				current.children[bit] = new TrieNode();
			}
			current = current.children[bit];
		}
		current.value = key;
	}

	public void display() {
		auxDisplay(root, "");
		System.out.println();
	}
	private void auxDisplay(TrieNode root, String word) {
		if(root == null) return;		
		if(root.children[0] == null && root.children[1] == null) 
			System.out.println("(" + word + "," + root.value + ")");
		for(int i = 0; i < 2; ++i) {
			auxDisplay(root.children[i], word + i);
		}
	}
	
	public int queryForMax(int key) {
		TrieNode current = root;
		for(int i = 31; i >= 0; --i) {
			int bit = (key & (1 << i)) == 0?0:1;
			if(current.children[1-bit] != null) {
				current = current.children[1-bit];
			} else
				current = current.children[bit];
		}
		return current.value;
	}

	
}
public class MaxXor {

	public static int findMax(int[] in) {
		RwayTrie trie = new RwayTrie();
		trie.add(in[0]);
		trie.display();
		int maxSum = in[0];
		for(int i = 1; i < in.length; ++i) {
			int tmp = trie.queryForMax(in[i]);
			maxSum = Math.max(maxSum, tmp ^ in[i]);
			trie.add(in[i]);
			System.out.println(tmp);
			trie.display();
		}
		return maxSum;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		/*int[] in = new int[n];
		Random r = new Random(10);
		for(int i = 0; i < n; ++i)
			in[i] = r.nextInt(n) + 1;*/
		int[] in = {3, 10, 5, 25, 2, 8 };
		System.out.println(Arrays.toString(in));
		System.out.println(findMax(in));
	}

}
