package com.alg.top20.bt.TernarySequence;

import java.util.Arrays;

public class AllSequences {
	// It doesnt work for arbitrary n since we need to generate n for loops at
	// runtime
	public static void allSeq1(char[] in) {
		for (int i = 0; i < in.length; ++i) {
			for (int j = 0; j < in.length; ++j) {
				for (int k = 0; k < in.length; ++k) {
					for(int l = 0; l < in.length; ++l) {
						System.out.println(in[i] + " " + in[j] + " " + in[k] + " " + in[l]);
					}
				}
			}
		}
	}

	private static void auxSeq2(int d, char[] in, char[] out) {
		if (d == in.length) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for (int i = 0; i < in.length; ++i) {
			out[d] = in[i];
			auxSeq2(d + 1, in, out);
		}
	}
	
	public static void allSeq2(char[] in) {
		char[] out = new char[in.length];
		auxSeq2(0, in, out);
	}

	public static void main(String[] args) {
		char tmp = 'A';
		char[] in = new char[Integer.parseInt(args[0])];
		for(int i = 0; i < in.length; ++i)
			in[i] = (char)(tmp + i);
		System.out.println(Arrays.toString(in));
		allSeq2(in);
	}

}
