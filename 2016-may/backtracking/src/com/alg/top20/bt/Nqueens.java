package com.alg.top20.bt;

import java.util.Arrays;

public class Nqueens {
	private static boolean isValid1(int[] out) {
		for (int cq1 = 1; cq1 < out.length; ++cq1) {
			for (int cq2 = 0; cq2 < cq1; ++cq2) {
				if (out[cq1] == out[cq2]
						|| Math.abs(cq1 - cq2) == Math.abs(out[cq1] - out[cq2]))
					return false;
			}
		}
		return true;
	}

	private static void auxqueens1(int d, int n, int[] out) {
		if (d == n) {
			if (isValid1(out))
				System.out.println(Arrays.toString(out));
			return;
		}
		for (int c = 0; c < n; ++c) {
			out[d] = c;
			auxqueens1(d + 1, n, out);
		}
	}

	public static void nqueens1(int n) {
		int[] out = new int[n];
		auxqueens1(0, n, out);
	}

	private static boolean isValid2(int[] out, int cq, int c) {
		for (int q = 0; q < cq; ++q) {
			if (c == out[q] || Math.abs(q - cq) == Math.abs(c - out[q]))
					return false;
		}
		return true;
	}

	private static void auxqueens2(int d, int n, int[] out) {
		if (d == n) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for (int c = 0; c < n; ++c) {
			if (isValid2(out, d, c)) {
				out[d] = c;
				auxqueens2(d + 1, n, out);
			}
		}
	}

	public static void nqueens2(int n) {
		int[] out = new int[n];
		auxqueens2(0, n, out);
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		nqueens1(n);
	}

}
