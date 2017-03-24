package com.alg.top20.backtracking;

import java.util.Arrays;

public class Nqueens {

	// column & diagonal attack check for each pair of queens
	private static boolean isPositionValid(int[] out) {
		for (int i = 0; i < out.length; ++i) {
			for (int j = i + 1; j < out.length; ++j) {
				if (out[i] == out[j]
						|| Math.abs(i - j) == Math.abs(out[i] - out[j]))
					return false;
			}
		}
		return true;
	}

	private static void auxqueens1(int d, int n, int[] out) {
		if (d == n) {
			if (isPositionValid(out))
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

	private static boolean isValid(int cq, int cc, int[] out) {
		//heuristic: first queen first column is never be part of solution
		//if(cq == 0 && cc == 0) return false;
		for(int q = 0; q < cq; ++q) {
			if(cc == out[q] || Math.abs(q-cq) == Math.abs(out[q]-cc))
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
			if (isValid(d, c, out)) {
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
		nqueens2(n);
	}

}
