package com.alg.top20.strings;

public class LongestRepeatedSubstring {

	private static int findCommonPrefixLength(String s, int i, int j) {
		int l = 0;
		for(;j < s.length();++i,++j) {
			if(s.charAt(i) == s.charAt(j)) ++l;
			else break;
		}
		return l;
	}
	public static int longestRepSubstr(String s) {
		int maxl = 0;
		for(int i = 0; i < s.length(); ++i) {
			for(int j = i+1; j < s.length(); ++j) {
				int l = findCommonPrefixLength(s, i, j);
				maxl = Math.max(maxl, l);
			}
		}
		return maxl;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
