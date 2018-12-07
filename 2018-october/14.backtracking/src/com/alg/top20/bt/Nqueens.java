package com.alg.top20.bt;

import java.util.Arrays;

public class Nqueens {

	public static void nqueens1(int n) {
		int[] out = new int[n];
		auxQueens1(0, out);
	}

	private static boolean isValid1(int[] out) {
		// for each pair of queens, check for attacking
		for (int i = 1; i < out.length; ++i) {
			for (int j = 0; j < i; ++j) {
				if (out[j] == out[i]
						|| Math.abs(i - j) == Math.abs(out[i] - out[j]))
					return false;
			}
		}
		return true;
	}

	private static void auxQueens1(int q, int[] out) {
		if (q == out.length) {
			if (isValid1(out))
				System.out.println(Arrays.toString(out));
			return;
		}
		for (int i = 0; i < out.length; ++i) {
			out[q] = i;
			auxQueens1(q + 1, out);
		}
	}

	public static void nqueens2(int n) {
		int[] out = new int[n];
		auxQueens2(0, out);
	}

	private static boolean isValid2(int q, int c, int[] out) {
		for (int i = 0; i < q; ++i) {
				if (out[i] == c
						|| Math.abs(i - q) == Math.abs(out[i] - c))
					return false;
		}
		return true;
	}

	private static void auxQueens2(int q, int[] out) {
		if (q == out.length) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for (int i = 0; i < out.length; ++i) {
			if (isValid2(q, i, out)) {
				out[q] = i;
				auxQueens2(q + 1, out);
			}
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		nqueens2(n);
	}

}
