package com.alg.top20.backtracking;


import java.util.Arrays;

public class PermutationSequence {
	
	//It verifies whether the current character is already taken into sequnce or not
	private static boolean isValid(int c, int d, char[] out) {
		for(int i = 0; i < d; ++i) {
			if(out[i] == c) return false; 
		}
		return true;
	}
	private static void auxPermSeq(int d, char[] in, char[] out) {
		if(d == in.length) { 
			System.out.println(Arrays.toString(out));
			return; 
		}
		for (int i = 0; i < in.length; ++i) {
			//conditional branch logic
			if(isValid(in[i],d,out)) {
				out[d] = in[i];
				auxPermSeq(d+1, in, out);
			}
		}
	}
	public static void generatePermSeq(char[] in) {
		char[] out = new char[in.length];
		auxPermSeq(0, in, out);
	}

	public static void main(String[] args) {
		char[] in = args[0].toCharArray();
		generatePermSeq(in);
	}

}
