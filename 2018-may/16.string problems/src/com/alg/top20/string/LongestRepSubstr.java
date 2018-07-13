package com.alg.top20.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TrieNode {
	TrieNode[] children;
	static final int NCHILDREN = 26;
	boolean isword;
	TrieNode() {
		children = new TrieNode[NCHILDREN];
	}
}

class RwayTrie {
	private TrieNode root;
	
	public RwayTrie() {
		root = new TrieNode();
	}	

	public void add(String word) {
		TrieNode current = root;
		for(int i = 0; i < word.length(); ++i) {
			int index = word.charAt(i)-'a';
			if(current.children[index] == null) {
				current.children[index] = new TrieNode();
			}
			current = current.children[index];
		}
		current.isword = true;
	}

	public String longestCommonPrefix(String word) {
		TrieNode current = root;
		int i;
		for(i = 0; i < word.length(); ++i) {
			int index = word.charAt(i)-'a';
			if(current.children[index] == null) break;
			current = current.children[index];
		}
		return word.substring(0, i);
	}

	public void display() {
		List<String> words = new ArrayList<String>();
		traverse(root, "", words);
		System.out.println(words);
	}

	private void traverse(TrieNode root, String word, List<String> words) {
		if(root == null) return;		
		if(root.isword == true) 
			words.add(word);
		for(int i = 0; i < 26; ++i) {
			traverse(root.children[i], word+(char)('a'+i), words);
		}
	}

}

public class LongestRepSubstr {

	private static String commonPrefix1(String s, int i, int j) {
		int start = i;
		while(j < s.length() && s.charAt(i) == s.charAt(j)) {
			++i;
			++j;
		}
		return s.substring(start, i);
	}
	//naive
	public static String longRepSubstr1(String s) {
		String res = "";
		for(int i = 0; i < s.length() -1; ++i) {
			for(int j = i + 1; j < s.length(); ++j) {
				String cprefix = commonPrefix1(s, i, j);
				if(cprefix.length() > res.length())
					res = cprefix;
			}
		}
		return res;
	}
	private static String commonPrefix2(String s1, String s2) {
		int i = 0, j = 0;
		int start = i;
		while(i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
			++i;
			++j;
		}
		return s1.substring(start, i);
	}
	public static String longRepSubstr21(String s) {
		String[] sa = new String[s.length()];
		for(int i = 0; i < sa.length; ++i)
			sa[i] = s.substring(i);
		System.out.println("suffix array before sort");
		System.out.println(Arrays.toString(sa));
		Arrays.sort(sa);
		System.out.println("suffix array after sort");
		System.out.println(Arrays.toString(sa));

		String res = "";
		for(int i = 1; i < sa.length; ++i) {
			String cprefix = commonPrefix2(sa[i-1], sa[i]);
			if(cprefix.length() > res.length())
				res = cprefix;
		}
		return res;
	}
	private static void suffixSort(String s, int[] sa){
		
	}
	//suffix array = index based sorted suffixes
	public static String longRepSubstr22(String s) {
		int[] sa = new int[s.length()];
		for(int i = 0; i < sa.length; ++i)
			sa[i] = i;
		suffixSort(s, sa);
		String res = "";
		for(int i = 1; i < sa.length; ++i) {
			String cprefix = commonPrefix1(s, sa[i-1], sa[i]);
			if(cprefix.length() > res.length())
				res = cprefix;
		}
		return res;
	}
	
	//suffix trie
	public static String longRepSubstr3(String s) {
		RwayTrie trie = new RwayTrie();
		String res = "";
		for(int i = 0; i < s.length(); ++i) {
			String cprefix = trie.longestCommonPrefix(s.substring(i));
			if(cprefix.length() > res.length())
				res = cprefix;
			trie.add(s.substring(i));
			trie.display();
			System.out.println(cprefix);
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(args[0]);
		//System.out.println(longRepSubstr1(args[0]));
		System.out.println(longRepSubstr21(args[0]));
		System.out.println();
		System.out.println(longRepSubstr3(args[0]));

	}

}
