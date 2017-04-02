package com.alg.top20.autocmpletion;

import java.io.BufferedReader;
import java.io.FileReader;

public class Test {

	public static void testTrie1(ITrie trie) {
		trie.add("def");
		trie.add("abc");
		trie.add("ab");
		trie.add("axy");
		trie.add("pqr");
		trie.add("xyz");
		trie.add("xxx");
		trie.display();
		System.out.println(trie.autocomplete("a"));
		System.out.println(trie.autocomplete("ab"));
		System.out.println(trie.autocomplete("x"));
		System.out.println(trie.findCommonPrefixLength("abcd"));
		System.out.println(trie.findCommonPrefixLength("efx"));
		System.out.println(trie.findCommonPrefixLength("abc"));
	}
	public static void testTrie2(ITrie trie, String filename) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		while((line=br.readLine()) != null) {
			String[] words = line.split(" ");
			for(String word:words) {
				String tmp = word.trim().toLowerCase();
				if(tmp.length() > 0)
				  trie.add(tmp);
			}
		}
		trie.display();
		System.out.println(trie.autocomplete("//"));
		System.out.println(trie.autocomplete("t"));
	}
	public static void main(String[] args) throws Exception {
		String filename = args[0];
		//testTrie2(new TernarySearchTree(), filename);
		testTrie1(new TernarySearchTree());
	}

}
