package com.alg.top20.cs;

import java.util.Arrays;

public class AllCharSequences {

	public static void allSeq(int n, char[] in) {
		char[] out = new char[n];
		auxSeq(0, out, in);
	}
	private static void auxSeq(int d, char[] out, char[] in) {
		if(d == out.length) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int i = 0; i < in.length; ++i) {
			out[d] = in[i];
			auxSeq(d+1, out, in);
		}
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		char[] in = args[1].toCharArray();
		allSeq(n, in);
	}

}
