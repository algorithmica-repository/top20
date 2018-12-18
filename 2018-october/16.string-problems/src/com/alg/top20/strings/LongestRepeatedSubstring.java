package com.alg.top20.strings;

import java.util.Arrays;

import com.alg.top20.basic.trie.ITrie;
import com.alg.top20.basic.trie.RadixTernarySearchTree;

public class LongestRepeatedSubstring {

	private static int findCommonPrefixLength1(String s, int i, int j) {
		int l = 0;
		for(;j < s.length();++i,++j) {
			if(s.charAt(i) == s.charAt(j)) ++l;
			else break;
		}
		return l;
	}
	public static int longestRepSubstr1(String s) {
		int maxl = 0;
		for(int i = 0; i < s.length(); ++i) {
			for(int j = i+1; j < s.length(); ++j) {
				int l = findCommonPrefixLength1(s, i, j);
				maxl = Math.max(maxl, l);
			}
		}
		return maxl;
	}
	private static int findCommonPrefixLength21(String[] sa, int i, int j) {
		int k = 0;
		while(k < sa[i].length() && k < sa[j].length()) {
			if(sa[i].charAt(k) == sa[j].charAt(k)) ++k;
			else break;
		}
		return k;
	}
	public static int longestRepSubstr21(String s) {
		int maxl = 0;
		String[] sa = new String[s.length()];
		for(int i = 0; i < s.length(); ++i)
			sa[i] = s.substring(i);
		Arrays.sort(sa);
		for(int i = 1; i < s.length(); ++i) {
			int l = findCommonPrefixLength21(sa, i, i-1);
			maxl = Math.max(maxl, l);
		}
		return maxl;
	}
	
	private static void suffix_sort(int[] sa, String s) {
		
	}
	public static int longestRepSubstr22(String s) {
		int maxl = 0;
		int[] sa = new int[s.length()];
		for(int i = 0; i < s.length(); ++i)
			sa[i] = i;
		suffix_sort(sa, s);
		for(int i = 1; i < s.length(); ++i) {
			int l = findCommonPrefixLength1(s, sa[i], sa[i-1]);
			maxl = Math.max(maxl, l);
		}
		return maxl;
	}
	
	public static int longestRepSubstr31(String s) {
		int maxl = 0;
		ITrie trie = new RadixTernarySearchTree();
		for(int i = 0; i < s.length(); ++i) {
			String tmp = trie.longestCommonPrefix(s.substring(i));
			if(tmp != null)
				maxl = Math.max(maxl, tmp.length());
			trie.add(s.substring(i));
		}
		return maxl;
	}
	
	
	public static int longestRepSubstr4(String s) {
		int maxl = 0;
		int n = s.length();
		int[][] mem = new int[n+1][n+1];
		for(int i = 0; i <= n; ++i)
			mem[i][n] = 0;
		for(int i = n-2;  i >= 0; --i) {
			for(int j = i+1; j < n; ++j) {
				if(s.charAt(i) == s.charAt(j))
					mem[i][j] = 1 + mem[i+1][j+1];
				else
					mem[i][j] = 0;
				maxl = Math.max(maxl, mem[i][j]);
			}
		}
		return maxl;
	}

	public static void main(String[] args) {
		System.out.println(longestRepSubstr1(args[0]));
		System.out.println(longestRepSubstr21(args[0]));
		System.out.println(longestRepSubstr31(args[0]));

	}

}
