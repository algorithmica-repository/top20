package com.alg.top20.trie;

public class TestTrie {

	public static void main(String[] args) {
		ITrie trie = new TST();
		String[] testwords = {"pqr", "abc", "def", "ab", "xyz",  "axy", "adf", "xab", "xdb"};
		for(int i = 0; i < testwords.length; ++i)
			trie.add(testwords[i]);
		trie.display();
		System.out.println(trie.autocomplete("a"));
		System.out.println(trie.autocomplete("ab"));
		System.out.println(trie.autocomplete("x"));
		System.out.println(trie.autocomplete("y"));



	}

}
