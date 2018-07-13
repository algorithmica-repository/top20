package com.alg.top20.string;

import java.util.Arrays;

public class LongestCommonSubstring {

	private static String commonPrefix1(String s1, String s2, int i, int j) {
		int start = i;
		while(i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
			++i;
			++j;
		}
		return s1.substring(start, i);
	}
	//naive
	public static String longCommonSubstr1(String s1, String s2) {
		String res = "";
		for(int i = 0; i < s1.length() -1; ++i) {
			for(int j = 0; j < s2.length(); ++j) {
				String cprefix = commonPrefix1(s1, s2, i, j);
				if(cprefix.length() > res.length())
					res = cprefix;
			}
		}
		return res;
	}
	private static String commonPrefix2(String s1, String s2) {
		if(s1.endsWith("$") && s2.endsWith("$")) return "";
		if(s1.endsWith("#") && s2.endsWith("#")) return "";
		int i = 0, j = 0;
		int start = i;
		while(i < s1.length()-1 && j < s2.length()-1 && s1.charAt(i) == s2.charAt(j)) {
			++i;
			++j;
		}
		return s1.substring(start, i);
	}
	//suffix array
	public static String longCommonSubstr2(String s1, String s2) {
		String[] sa = new String[s1.length() + s2.length()];
		int k = 0;
		for(int i = 0; i < s1.length(); ++i)
			sa[k++] =  s1.substring(i) + "$";
		for(int i = 0; i < s2.length(); ++i)
			sa[k++] =  s2.substring(i) + "#";
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
	
	//suffix trie
	public static String longCommonSubstr3(String s1, String s2) {
		RwayTrie trie = new RwayTrie();
		String res = "";
		for(int i = 0; i < s1.length(); ++i)
			trie.add(s1.substring(i));
		trie.display();
		for(int i = 0; i < s2.length(); ++i) {
			String cprefix = trie.longestCommonPrefix(s2.substring(i));
			if(cprefix.length() > res.length())
				res = cprefix;
		}
		return res;
	}
	//dp based logic
	public static String longCommonSubstr4(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int maxlen =0;
		int maxi =0;
		int[][] mem = new int[n+1][m+1];
		for(int j = 0; j <= m; ++j)
			mem[n][j] = 0;
		for(int i = 1; i <= s1.length(); ++i)
			mem[i][m] = 0;
		for(int i = n-1; i >= 0; --i) {
			for(int j = m-1; j >= 0; --j) {
				if(s1.charAt(i) == s2.charAt(j)) {
					mem[i][j] = 1 + mem[i+1][j+1];
					if(mem[i][j] > maxlen) {
						maxlen  = mem[i][j];
						maxi = i;
					}
				}
				else 
					mem[i][j] = 0;
			}
		}
		return s1.substring(maxi, maxi + maxlen);

	}

	public static void main(String[] args) {
		System.out.println(longCommonSubstr1(args[0], args[1]));
		System.out.println(longCommonSubstr2(args[0], args[1]));
		System.out.println(longCommonSubstr3(args[0], args[1]));

	}

}
