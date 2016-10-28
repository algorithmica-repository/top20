package com.alg.top20.bt;

import java.util.Arrays;

public class DisplayPermutations {

	private static boolean isValid(char[] out, int d, char c) {
		for(int i = 0; i < d; ++i) {
			if(out[i] == c) return false;
		}
		return true;
	}

	private static void auxPerm(int d, char[] in, char[] out) {
		if (d == in.length) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for (int i = 0; i < in.length; ++i) {
			if (isValid(out, d, in[i])) {
				out[d] = in[i];
				auxPerm(d + 1, in, out);
			}
		}
	}

	public static void displayAllPerm(char[] in) {
		char[] out = new char[in.length];
		auxPerm(0, in, out);
	}

	public static void main(String[] args) {
		char[] in = args[0].toCharArray();
		displayAllPerm(in);
	}

}
