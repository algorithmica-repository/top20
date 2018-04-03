package com.alg.top20.bt;

import java.util.Arrays;

public class Nquueens {

	public static void nqueens1(int n) {
		int[] out = new int[n];
		auxqueens1(0, n, out);
	}
	private static boolean isValid(int[] out) {
		for(int i = 0; i < out.length; ++i) {
			for(int j = i+1; j < out.length; ++j) {
				if(out[i] == out[j]) return false;
			}
		}
		return true;
	}
	private static void auxqueens1(int d, int n, int[] out) {
		if(d == n) {
			if(isValid(out))
				System.out.println(Arrays.toString(out));
			return;
		}
		for(int c = 0; c < n; ++c) {
			out[d] = c;
			auxqueens1(d+1, n, out);
		}
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		nqueens1(n);
	}

}
