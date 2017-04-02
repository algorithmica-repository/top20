package com.alg.top20.strings;

public class Exploration {

	//O(n ^ 2)
	public static void exploreSubStr(String s) {
		int n = s.length();
		for(int l = 1; l <= n; ++l) {
			for(int i = 0; i <= n - l; ++i) 
				System.out.println(s.substring(i, i+l));
		}		
	}
	
	public static void exploreSuffixes(String s) {
		for(int i = 0; i < s.length(); ++i)
			System.out.println(s.substring(i));
	}
	
	public static void explorePrefixes(String s) {
		for(int i = 1; i <= s.length(); ++i)
			System.out.println(s.substring(0,i));
	}
	public static void exploreSubSeq(String s) {
		
	}
	public static void main(String[] args) {
		exploreSuffixes("abcdefg");
		explorePrefixes("abcdefg");
	}

}
