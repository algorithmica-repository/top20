package com.alg.top20.setmap;

import java.util.Arrays;
import java.util.HashMap;

public class AnagramCheck {

	//TC:O(n log n)  SC:O(n)
	public static boolean anagramCheck1(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		for(int i = 0; i < c1.length; ++i)
			if(c1[i] != c2[i])
				return false;
		return true;
	}
	
	//TC:O(n)  SC:O(1)
	public static boolean anagramCheck21(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		int[] lookup = new int[26];
		for(int i = 0; i < s1.length(); ++i)
			++lookup[s1.charAt(i)-'a'];
		for(int i = 0; i < s2.length(); ++i) {
			if(lookup[s2.charAt(i)-'a'] <= 0) return false;
			--lookup[s2.charAt(i)-'a'];
		}
		return true;
	}
	
	//TC:O(n)  SC:O(1)
	public static boolean anagramCheck22(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		for(int i = 0; i < s1.length(); ++i) {
			if(! hmap.containsKey(s1.charAt(i)))
				hmap.put(s1.charAt(i), 1);
			else {
				int tmp =hmap.get(s1.charAt(i));
				hmap.put(s1.charAt(i),++tmp);
			}
		}
			
		for(int i = 0; i < s2.length(); ++i) {
			if(! hmap.containsKey(s2.charAt(i))) return false;
			int tmp = hmap.get(s2.charAt(i));
			if(tmp == 1) hmap.remove(s2.charAt(i));
			else
				hmap.put(s2.charAt(i),--tmp);
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
