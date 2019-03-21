package com.alg.top20.combinatorics;

import java.util.Arrays;

public class AllCharSequences {

	public static void allSeq(char[] in) {
		char[] out = new char[in.length];
		auxSeq(0, in, out);
	}
	private static void auxSeq(int d, char[] in, char[] out) {
		if(d == in.length) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int i = 0; i < in.length; ++i) {
			out[d] = in[i];
			auxSeq(d+1, in, out);
		}
	}
	public static void main(String[] args) {
		allSeq(args[0].toCharArray());
	}


}
