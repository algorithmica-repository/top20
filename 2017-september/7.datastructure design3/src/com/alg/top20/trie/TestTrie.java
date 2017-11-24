package com.alg.top20.trie;

public class TestTrie {
	
	public static void testTrie(ITrie trie) {
		String[] testwords = {"pqr", "abc", "def", "ab", "xyz",  "axy", "adf", "xab", "xdb"};
		for(int i = 0; i < testwords.length; ++i)
			trie.add(testwords[i]);
		trie.print();
		trie.displayAll();
		System.out.println(trie.autocomplete("a"));
		System.out.println(trie.autocomplete("ab"));
		System.out.println(trie.autocomplete("x"));
		System.out.println(trie.autocomplete("y"));
		System.out.println(trie.contains("pqr"));
		System.out.println(trie.contains("pab"));
	}

	public static void main(String[] args) {
		testTrie(new RwayTrie());
	}

}
