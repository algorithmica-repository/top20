package com.alg.top20.trie;

public class Driver {

	public static void testTrie(ITrie trie) {
		trie.add("lmn");
		trie.add("abc");
		trie.add("ab");
		trie.add("aaaaa");
		trie.add("aab");
		trie.add("xyz");
		trie.add("bcd");
		trie.display();
		System.out.println();
		System.out.println(trie.autocomplete("a"));
		System.out.println();
		System.out.println(trie.autocomplete("ab"));
	}
	public static void main(String[] args) {
		testTrie(new TernarySearchTree());

	}

}
