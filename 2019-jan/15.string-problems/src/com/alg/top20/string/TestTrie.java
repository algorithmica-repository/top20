package com.alg.top20.string;

public class TestTrie {

	public static void main(String[] args) {
		ITrie trie = new TernarySearchTree();
		trie.add("pqr");
		trie.add("abc");
		trie.add("cde");
		trie.add("xyza");
		trie.add("ab");
		trie.add("xab");
		trie.add("a");
		trie.add("abx");
		System.out.println(trie.autocomplete(""));
		System.out.println(trie.autocomplete("a"));
		System.out.println(trie.autocomplete("ab"));;
		System.out.println(trie.autocomplete("x"));
		System.out.println(trie.lcp("abxs"));
		trie.display();
	}


}
