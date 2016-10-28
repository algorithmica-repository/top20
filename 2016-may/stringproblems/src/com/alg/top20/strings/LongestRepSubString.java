package com.alg.top20.strings;

import java.util.HashSet;

import com.alg.top20.trie.ITrie;
import com.alg.top20.trie.TernarySearchTree;

public class LongestRepSubString {

	public static String longRepSubStr1(String s) {
		HashSet<String> set = new HashSet<String>();
		for(int len = s.length() - 1; len >= 1; --len) {
			for(int i = 0; i <= s.length() - len; ++i) {
				String tmp = s.substring(i, i+len);
				System.out.println(tmp);
				if(set.contains(tmp)) {
					return tmp;
				} else {
					set.add(tmp);
				}
			}
		}
		return null;
	}
	
	private static int findCommonLength(String s, int i, int j) {
		int clength = 0;
		while(j < s.length() && s.charAt(i) == s.charAt(j)) {
				++clength;
				++i; 
				++j;
		}
		return clength;
	}
	
	public static String longRepSubStr2(String s) {
		int maxlen = 0;
		int resp = -1;
		for(int i = 0; i < s.length(); ++i) {
			for(int j = i+1; j < s.length(); ++j) {
				int commonLength = findCommonLength(s, i, j);
				if(commonLength > maxlen) {
					maxlen = commonLength;
					resp = i;
				}
			}
		}
		return s.substring(resp, resp+maxlen);
	}
	
	public static String longRepSubStr3(String s) {
		int maxlen = 0;
		String res = null;
		ITrie trie = new TernarySearchTree();
		for(int i = 0; i < s.length(); ++i) {
				String commonStr = trie.findLongestCommonPrefix(s.substring(i));
				if(commonStr.length() > maxlen) {
					maxlen = commonStr.length();
					res = commonStr;
				}
		}
		return res;
	}
	private static void sort(int[] array, String s) {
		
	}
	public static String longRepSubStr4(String s) {
		int[] suffixarray = new int[s.length()];
		for(int i = 0; i < suffixarray.length; ++i)
			suffixarray[i] = i;
		sort(suffixarray, s);
		int maxlen = 0;
		int resp = -1;
		for(int i = 0; i < s.length() - 1; ++i) {
			int commonLength = findCommonLength(s, suffixarray[i], suffixarray[i+1]);
			if(commonLength > maxlen) {
				maxlen = commonLength;
				resp = suffixarray[i];
			}
		}
		return s.substring(resp, resp+maxlen);
	}
	
	

	public static void main(String[] args) {
		//System.out.println("abcdefg".substring(2, 3));
		System.out.println(longRepSubStr3(args[0]));
	}
}
