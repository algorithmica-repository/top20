package com.alg.top20.trie.t9.approach2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class TrieNode {
	TrieNode[] children;
	static final int NCHILDREN = 10;
	List<Pair> values;
	TrieNode() {
		children = new TrieNode[NCHILDREN];
	}
}

class RwayTrie {
	private TrieNode root;
	private static char[] keys = {
		2, 2, 2, 3, 3, 3, 4, 4, 4,
		5, 5, 5, 6, 6, 6, 7, 7, 7, 7,
		8, 8, 8, 9, 9, 9, 9
		};
	public RwayTrie() {
		root = new TrieNode();
	}	

	public void add(String word, int frequency) {
		TrieNode current = root;
		for(int i = 0; i < word.length(); ++i) {
			int index = keys[word.charAt(i)-'a'];
			if(current.children[index] == null) {
				current.children[index] = new TrieNode();
			}
			current = current.children[index];
		}
		if(current.values == null)
			current.values = new ArrayList<Pair>();
		current.values.add(new Pair(word, frequency));
	}

	public void display() {
		auxDisplay(root, "");
	}
	private void auxDisplay(TrieNode root, String word) {
		if(root == null) return;		
		if(root.values != null) 
			System.out.println(word + root.values);
		for(int i = 0; i < 10; ++i) {
			auxDisplay(root.children[i], word + i);
		}
	}
	
	public TrieNode findLastPrefixNode(String word) {
		TrieNode current = root;
		for(int i = 0; i < word.length(); ++i) {
			int index = word.charAt(i)-'0';
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
		if(root.values != null) 
			words.addAll(root.values);
		for(int i = 0; i < 10; ++i) {
			traverse(root.children[i], word + i, words);
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
public class T9Impl2 {
	private RwayTrie trie;
	
	public void getSuggestions(String input) {		
		for(int i = 0; i < input.length(); ++i) {
			List<Pair> words = trie.autocomplete(input.substring(0, i+1));
			if(words != null)
				Collections.sort(words, new MyComparator());	
			System.out.println(words);
		}
	}
	public T9Impl2(List<Pair> words) {
		trie = new RwayTrie();
		for(Pair pair: words) 
			trie.add(pair.word, pair.frequency);
		trie.display();
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
		words.add(new Pair("ghuf", 12));
		T9Impl2 t9 = new T9Impl2(words);
		t9.getSuggestions(args[0]);
	}
}
