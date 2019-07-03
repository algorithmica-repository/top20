package com.alg.top20.combinatorics;

import java.util.Arrays;

public class NQueens {

	public static  void nqueens1(int n) {
		int[] out = new int[n];
		auxQueens1(0, out);
	}
	private static boolean isValid1(int[] out) {
		for(int i = 0; i < out.length; ++i) {
			for(int j = i+1; j < out.length; ++j) {
				if(out[i] == out[j]) return false;
				if(Math.abs(i-j) == Math.abs(out[i]-out[j])) return false;
			}
		}
		return true;
	}
	private static void auxQueens1(int d, int[] out) {
		if(d == out.length) {
			if(isValid1(out))
				System.out.println(Arrays.toString(out));
			return;
		}
		for(int c = 0; c < out.length; ++c) {
			out[d] = c;
			auxQueens1(d+1, out);
		} 
	}
	
	public static  void nqueens2(int n) {
		int[] out = new int[n];
		auxQueens2(0, out);
	}
	private static boolean isValid2(int d, int c, int[] out) {
		for(int i = 0; i < d; ++i) {
			if(c == out[i]) return false;
			if(Math.abs(i-d) == Math.abs(out[i]-c)) return false;
		}
		return true;
	}
	private static void auxQueens2(int d, int[] out) {
		if(d == out.length) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int c = 0; c < out.length; ++c) {
			if(isValid2(d, c, out)) {
				out[d] = c;
				auxQueens2(d+1, out);
			}
		} 
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		nqueens2(n);

	}

}
