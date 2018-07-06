package com.alg.top20.trie.t9.approach1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class TrieNode {
	TrieNode[] children;
	static final int NCHILDREN = 26;
	int frequency;
	TrieNode() {
		children = new TrieNode[NCHILDREN];
	}
}

class RwayTrie {
	private TrieNode root;
	
	public RwayTrie() {
		root = new TrieNode();
	}	

	public void add(String word, int frequency) {
		TrieNode current = root;
		for(int i = 0; i < word.length(); ++i) {
			int index = word.charAt(i)-'a';
			if(current.children[index] == null) {
				current.children[index] = new TrieNode();
			}
			current = current.children[index];
		}
		current.frequency = frequency;
	}

	public TrieNode findLastPrefixNode(String word) {
		TrieNode current = root;
		for(int i = 0; i < word.length(); ++i) {
			int index = word.charAt(i)-'a';
			if(current.children[index] == null) 
				return null;
			current = current.children[index];
		}
		return current;
	}

	public List<Pair> autocomplete(String prefix) {
		TrieNode tmp = findLastPrefixNode(prefix);
		if(tmp == null) return null;
		List<Pair> words = new ArrayList<Pair>();
		traverse(tmp, prefix, words);
		return words;
	}

	private void traverse(TrieNode root, String word, List<Pair> words) {
		if(root == null) return;		
		if(root.frequency > 0) 
			words.add(new Pair(word, root.frequency));
		for(int i = 0; i < 26; ++i) {
			traverse(root.children[i], word+(char)('a'+i), words);
		}
	}

}

class Pair {
	String word;
	int frequency;
	public Pair(String word, int frequency) {
		this.word = word;
		this.frequency = frequency;
	}
	public String toString() {
		return "(" + word + "," + frequency + ")";
	}
}

class MyComparator implements Comparator<Pair> {

	@Override
	public int compare(Pair left, Pair right) {
		return right.frequency - left.frequency;
	}
	
}
public class T9Impl1 {
	private RwayTrie trie;
	private static String[] phoneDigitsToLetters = {
			  "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
			};
	
	private void allValidCombinations(String input, String word, List<Pair> words) {		
		if(input.length() == 0)  {
			List<Pair> res = trie.autocomplete(word);
			if(res != null) words.addAll(res);
			return;
		}
		String options = phoneDigitsToLetters[input.charAt(0)-'0'];
		for(int i = 0; i < options.length(); ++i) {
			String tmp = word + options.charAt(i);
			allValidCombinations(input.substring(1), tmp, words);
		}
	}
	public void getSuggestions(String input) {		
		for(int i = 0; i < input.length(); ++i) {
			List<Pair> words = new ArrayList<Pair>();
			allValidCombinations(input.substring(0, i+1), "", words);
			Collections.sort(words, new MyComparator());	
			System.out.println(words);
		}
	}
	public T9Impl1(List<Pair> words) {
		trie = new RwayTrie();
		for(Pair pair: words) 
			trie.add(pair.word, pair.frequency);
		System.out.println(trie.autocomplete(""));
	}
	public static void main(String[] args) {
		List<Pair> words = new ArrayList<Pair>();
		words.add(new Pair("another", 5));
		words.add(new Pair("contest", 6));
		words.add(new Pair("follow", 3));
		words.add(new Pair("give", 13));
		words.add(new Pair("integer", 6));
		words.add(new Pair("new", 14));
		words.add(new Pair("program", 4));
		T9Impl1 t9 = new T9Impl1(words);
		t9.getSuggestions(args[0]);
	}
}
