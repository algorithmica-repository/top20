package com.alg.top20.bt;

import java.util.Arrays;

public class Permutations {

	private static boolean isValid(char[] out, int d, char c) {
		for(int i = 0; i < d; ++i) {
			if(out[i] == c) return false;
		}
		return true;
	}
	private static void auxPermSeq1(int d, char[] in, char[] out) {
		if (d == in.length) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for (int i = 0; i < in.length; ++i) {
			//adding branch pruning logic
			if(isValid(out, d,  in[i])) {
				out[d] = in[i];
				auxPermSeq1(d + 1, in, out);
			}
		}
	}
	
	public static void permSeq1(char[] in) {
		char[] out = new char[in.length];
		auxPermSeq1(0, in, out);
	}

	public static void main(String[] args) {
		char tmp = 'A';
		char[] in = new char[Integer.parseInt(args[0])];
		for(int i = 0; i < in.length; ++i)
			in[i] = (char)(tmp + i);
		//System.out.println(Arrays.toString(in));
		permSeq1(in);
	}

}
