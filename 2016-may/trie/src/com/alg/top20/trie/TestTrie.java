package com.alg.top20.trie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TestTrie {
	
	public static void testTrie(ITrie trie, String file) throws Exception  {
		/*trie.add("cat");
		trie.add("cake");
		trie.add("dog");
		trie.add("ca");*/
		String line;
		BufferedReader br = new BufferedReader(new FileReader(new File(file)));
		while((line = br.readLine()) != null) {
			String[] tokens = line.split(" ");
			for(String word:tokens) {
				trie.add(word);
			}
		}	
		trie.display();
		System.out.println(trie.autocomplete("a"));
		System.out.println(trie.autocomplete("in"));
		System.out.println(trie.autocomplete("d"));
		System.out.println(trie.findLongestCommonPrefix("data??"));
		trie.display();
				
	}

	public static void main(String[] args) throws Exception {
		String file = args[0];
		testTrie(new TernarySearchTree(), file);
	}

}
