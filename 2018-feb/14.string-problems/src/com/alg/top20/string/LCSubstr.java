package com.alg.top20.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import com.alg.top20.ds.trie.ITrie;
import com.alg.top20.ds.trie.TSTTrie;

public class LCSubstr {

	public static int lcSubstr1(String s1, String s2) {
		HashSet<String> hset = new HashSet<String>();
		for(int i = 0; i < s1.length(); ++i) {
			for(int j = i;  j < s1.length(); ++j) {
				hset.add(s1.substring(i, j+1));
			}
		}
		int maxlen = 0;
		for(int i = 0; i < s2.length(); ++i) {
			for(int j = i;  j < s2.length(); ++j) {
				if(hset.contains(s2.substring(i, j+1)))
						maxlen = Math.max(maxlen, j-i+1);
			}
		}
		return maxlen;
	}
	
	public static int lcSubstr2(String s1, String s2) {
		ITrie trie = new TSTTrie();
		for(int i = 0; i < s1.length(); ++i) {
			trie.add(s1.substring(i));
		}
		//trie.display();
		//System.out.println(trie.autocomplete(""));
		int maxlen = 0;
		for(int i = 0; i < s2.length(); ++i) {
			int clen = trie.findLongestPrefixLength(s2.substring(i));
			maxlen = Math.max(maxlen, clen);
		}
		return maxlen;
	}
	
	public static int lcSubstr3(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] mem = new int[m+1][n+1];
		for(int j = 0; j <= n; ++j)
			mem[m][j] = 0;
		for(int i = 1; i <= m; ++i)
			mem[i][n] = 0;
		int maxlen = 0;
		for(int i = m-1; i >= 0; --i) {
			for(int j = n-1; j>= 0; --j) {
				if(s1.charAt(i) == s2.charAt(j)) {
					mem[i][j] = 1 + mem[i+1][j+1];
					maxlen = Math.max(maxlen, mem[i][j]);
				}
				else
					mem[i][j] = 0;
			}
		}
		//for(int[] tmp: mem)
		//	System.out.println(Arrays.toString(tmp));
		return maxlen;
	}
	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		Random r = new Random(100);
		String s1 ="";
		String s2 = "";
		for(int i = 0; i < m; ++i)
			s1 = s1 + (char)('a' + r.nextInt(26));
		for(int i = 0; i < n; ++i)
			s2 = s2 + (char)('a' + r.nextInt(26));
		System.out.println(s1);
		System.out.println(s2);
		//System.out.println(lcSubstr1(s1, s2));
		System.out.println(lcSubstr2(s1, s2));
		System.out.println(lcSubstr3(s1, s2));
	}

}
