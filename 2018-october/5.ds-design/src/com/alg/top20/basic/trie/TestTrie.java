package com.alg.top20.basic.trie;

public class TestTrie {

	public static void test(ITrie trie) {
		String[] input= {"pqr", "abc", "abd", "ab", "xyz", "xab", "abcx", "aaab"};
		for(String s:input) {
			trie.add(s);			
		}
		trie.display();
		
		System.out.println(trie.contains("abc"));
		System.out.println(trie.contains("aaa"));
		System.out.println(trie.contains("xabc"));
		
		System.out.println(trie.autocomplete(""));
		System.out.println(trie.autocomplete("a"));
		System.out.println(trie.autocomplete("ab"));
		System.out.println(trie.autocomplete("ay"));

		System.out.println(trie.longestCommonPrefix("abyx"));
		System.out.println(trie.longestCommonPrefix("yx"));
		System.out.println(trie.longestCommonPrefix("aaab"));
	}
	public static void main(String[] args) {
		test(new RadixTernarySearchTree());
	}

}
