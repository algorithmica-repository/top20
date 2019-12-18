package com.alg.top20.string.trie;

public class TestTrie {
	
	public static void testCase1(ITrie trie) {
		trie.add("pqr");
		trie.add("abc");
		trie.add("abcd");
		trie.add("ab");
		trie.add("axy");
		trie.add("xyz");
		trie.add("xab");
		System.out.println(trie.autocomplete(""));
		System.out.println(trie.autocomplete("ab"));
		System.out.println(trie.autocomplete("x"));
		System.out.println(trie.lcp("abcxy"));
	}

	public static void main(String[] args) {
		testCase1(new TSTTrie());
	}

}
