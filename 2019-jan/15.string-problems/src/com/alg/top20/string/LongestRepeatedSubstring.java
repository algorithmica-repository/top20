package com.alg.top20.string;

import java.util.Arrays;
import java.util.HashSet;

public class LongestRepeatedSubstring {

	public static int longrepsubstr0(String s) {
		HashSet<String> hset = new HashSet<String>();
		int res = 0;
		for(int l = s.length()-1; l >= 1 ; --l) {
			for(int i = 0; i <= s.length()-l; ++i) {
				String tmp = s.substring(i, i+l+1);
				if(hset.contains(tmp))
					return l;
				hset.add(tmp);
			}
			hset.clear();
		}
		return res;
	}
	private static int longestcommonprefix1(String s, int i, int j) {
		int len = 0;
		while(j < s.length() && s.charAt(i) == s.charAt(j)) {
			++i;
			++j;
			++len;
		}
		return len;
	}
	public static int longrepsubstr1(String s) {
		int res = Integer.MIN_VALUE;
		for(int i = 0; i < s.length(); ++i) {
			for(int j = i+1; j < s.length(); ++j) {
				int tmp = longestcommonprefix1(s, i, j);
				res = Math.max(res, tmp);
			}
		}
		return res;
	}
	private static int longestcommonprefix2(String s1, String s2) {
		int i = 0;
		int len = 0;
		while(i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i)) {
			++i;
			++len;
		}
		return len;
	}
	public static int longrepsubstr21(String s) {
		String[] suffixes = new String[s.length()];
		for(int i = 0; i < s.length(); ++i)
			suffixes[i] = s.substring(i);
		Arrays.sort(suffixes);
		
		int res = Integer.MIN_VALUE;
		for(int i = 1; i < s.length(); ++i) {
				int tmp = longestcommonprefix2(suffixes[i], suffixes[i-1]);
				res = Math.max(res, tmp);
		}
		return res;
	}
	
	private static void suffix_sort(int[] suffixes, String s) {
		
	}
	//use suffix array ~ an array with sorted suffixes
	public static int longrepsubstr22(String s) {
		int[] suffixes = new int[s.length()];
		for(int i = 0; i < s.length(); ++i)
			suffixes[i] = i;
		suffix_sort(suffixes, s);
		
		int res = Integer.MIN_VALUE;
		for(int i = 1; i < s.length(); ++i) {
				int tmp = longestcommonprefix2(suffixes, i, i -1]);
				res = Math.max(res, tmp);
		}
		return res;
	}
	
	public static int longrepsubstr3(String s) {
		ITrie trie = new RadixTree();
		
		int res = Integer.MIN_VALUE;
		trie.add(s.substring(0));
		for(int i = 1; i < s.length(); ++i) {
				String tmp = trie.lcp(s.substring(i));
				res = Math.max(res, tmp.length());
				trie.add(s.substring(i));
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		System.out.println(longrepsubstr1(args[0]));
		System.out.println(longrepsubstr2(args[0]));
		System.out.println(longrepsubstr3(args[0]));

	}

}
