package com.alg.top20.bt.permutations;

import java.util.Arrays;

public class Permutations {

	//TC: O(n ^ n+1)
	//SC: O(n)
	//Recursion
	public static void permutations1(char[] in) {
		char[] out = new char[in.length];
		auxPermutations1(0, in, out);
	}
	private static boolean isValid1(char[] out) {
		return true;
	}
	private static void auxPermutations1(int d, char[] in, char[] out) {
		if(d == in.length) {
			if(isValid1(out)) 
				System.out.println(Arrays.toString(out));
			return;
		}
		for(int i = 0; i < in.length; ++i) {
			out[d] = in[i];
			auxPermutations1(d+1, in, out);
		}
	}
	
	//TC: O(n!)
	//SC: O(n)
	//Backtracking
	public static void permutations2(char[] in) {
		char[] out = new char[in.length];
		auxPermutations2(0, in, out);
	}
	private static boolean isValid2(char[] out, int d, char c) {
		for(int i = 0; i < d; ++i)
			if(out[i] == c) return false;
		return true;
	}
	private static void auxPermutations2(int d, char[] in, char[] out) {
		if(d == in.length) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int i = 0; i < in.length; ++i) {
			if(isValid2(out, d, in[i])) {
				out[d] = in[i];
				auxPermutations2(d+1, in, out);
			}
		}
	}
	
	public static void main(String[] args) {
		permutations2(args[0].toCharArray());
	}

}
