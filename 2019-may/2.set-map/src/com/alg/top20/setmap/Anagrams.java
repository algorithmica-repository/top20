package com.alg.top20.setmap;

import java.util.Arrays;
import java.util.HashMap;

public class Anagrams {

	public static boolean anagrams1(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		char[] in1 = s1.toCharArray();
		char[] in2 = s2.toCharArray();
		Arrays.sort(in1);
		Arrays.sort(in2);
		for(int i = 0; i < in1.length; ++i)
			if(in1[i] != in2[i])
				return false;
		return true;		
	}
	
	public static boolean anagrams2(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		int[] aux = new int[26];
		for(int i = 0; i < s1.length(); ++i)
			++aux[s1.charAt(i) - 'a'];
		for(int i = 0; i < s2.length(); ++i) {
			int index = s2.charAt(i) - 'a';
			if(aux[index] == 0) return false;
			--aux[index];
		}			
		return true;		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
