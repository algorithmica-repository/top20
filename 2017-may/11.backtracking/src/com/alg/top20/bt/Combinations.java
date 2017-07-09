package com.alg.top20.bt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

	//recursion: TC-O(2 ^ (n+1))  SC:O(n)
	public static void combinations1(char[] in) {
		List<Character> out = new ArrayList<Character>();
		auxCombinations1(0, in, out);
	}
	
	private static void auxCombinations1(int d, char[] in, List<Character> out) {
		if( d == in.length) {
			System.out.println(out);
			return;
		}
		//exclude element at d
		auxCombinations1(d+1, in, out);
		//include element at d
		out.add(in[d]);
		auxCombinations1(d+1, in, out);
		out.remove(out.size()-1);
	}
	
	//backtracking: TC-O(2 ^ n)  SC:O(n)
	public static void combinations2(char[] in) {
		List<Character> out = new ArrayList<Character>();
		auxCombinations2(0, in, out);
	}
	
	private static void auxCombinations2(int start, char[] in, List<Character> out) {
		for (int i = start; i < in.length; ++i) {
			out.add(in[i]);
			System.out.println(out);
			auxCombinations2(i + 1, in, out);
			out.remove(out.size()-1);
		}
	}
	public static void main(String[] args) {
		char[] in = args[0].toCharArray();
		// System.out.println(Arrays.toString(in));
		combinations2(in);

	}

}
