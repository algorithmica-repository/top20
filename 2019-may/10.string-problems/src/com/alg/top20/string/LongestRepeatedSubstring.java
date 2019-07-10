package com.alg.top20.string;

import java.util.Arrays;

import com.alg.top20.string.trie.ITrie;
import com.alg.top20.string.trie.TernarySearchTrie;

public class LongestRepeatedSubstring {

	private static int common_prefix1(String s, int i, int j) {
		int l = 0;
		while(j < s.length()) {
			if(s.charAt(i++) == s.charAt(j++) )
				++l;
			else
				break;
		}
		return l;
	}
	public static int longRepSubstr1(String s) {
		int n = s.length();
		int maxl = 0;
		for(int i = 0; i < n; ++i) {
			for(int j = i+1; j < n; ++j) {
				int l = common_prefix1(s, i, j);
				maxl = Math.max(maxl, l);
			}
		}
		return maxl;
	}
	private static int common_prefix2(String s1, String s2) {
		int i = 0, j = 0, l = 0;
		while(i < s1.length() && j < s2.length()) {
			if(s1.charAt(i++) == s2.charAt(j++))
				++l;
			else
				break;
		}
		return l;
	}
	public static int longRepSubstr2(String s) {
		int n = s.length();
		String[] suffixes = new String[n];
		for(int i = 0; i < n; ++i)
			suffixes[i] = s.substring(i);
		Arrays.sort(suffixes);
		int maxl = 0;
		for(int i = 1; i < n; ++i) {
			int l = common_prefix2(suffixes[i], suffixes[i-1]);
			maxl = Math.max(maxl, l);
		}
		return maxl;
	}
	public static int longRepSubstr3(String s) {
		ITrie trie = new TernarySearchTrie();
		int maxl = 0;
		for(int i = 0; i < s.length(); ++i) {
			String tmp = trie.lcp(s.substring(i));
			maxl = Math.max(maxl, tmp==null?0:tmp.length());
			trie.add(s.substring(i));
		}
		return maxl;
	}
	
	public static int longRepSubstr4(String s) {
		int n = s.length();
		int maxl = 0;
		int[][] mem = new int[n+1][n+1];
		for(int i = 0; i < n; ++i)
			mem[i][n] = 0;
		for(int i = n-1; i >= 0; --i) {
			for(int j = i+1; j < n; ++j) {
				if(s.charAt(i) != s.charAt(j))
					mem[i][j] = 0;
				else {
					mem[i][j] = 1 + mem[i+1][j+1];
					maxl = Math.max(maxl, mem[i][j]);
				}
			}
		}
		return maxl;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
