package com.alg.top20.string.trie;

public class TestTrie {

	public static void main(String[] args) {
		ITrie trie = new TernarySearchTrie();
		trie.add("pqr");
		trie.add("abc");
		trie.add("ab");
		trie.add("abcd");
		trie.add("axy");
		trie.add("xyz");
		trie.add("xab");
		System.out.println(trie.autocomplete(""));
		System.out.println(trie.autocomplete("a"));
		System.out.println(trie.autocomplete("ab"));
		System.out.println(trie.lcp("axyb"));
		//System.out.println(trie.contains("axyb"));
		//System.out.println(trie.contains("axy"));

	}

}
