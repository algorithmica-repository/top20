package com.alg.top20.ds.trie;

public class TestTrie {

	public static void main(String[] args) {
		String[] words = 
		{"pqr", "abc", "ab", "axy", "axz" ,"xyz", "xab", "abcz", "aaa"};
		ITrie trie = new TSTTrie();
		for(int i = 0; i < words.length; ++i)
			trie.add(words[i]);
		trie.display();
		System.out.println(trie.autocomplete("a"));
		System.out.println(trie.autocomplete("ab"));
		System.out.println(trie.autocomplete("x"));
		System.out.println(trie.autocomplete(""));

	}

}
