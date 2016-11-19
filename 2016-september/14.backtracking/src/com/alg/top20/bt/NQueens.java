package com.alg.top20.bt;

import java.util.Arrays;

public class NQueens {

	private static boolean isValid(int[] q) {
		for(int i = 0; i < q.length; ++i) {
			for(int j  = i + 1; j < q.length; ++j) {
				if(q[i] == q[j]) return false;
				if(Math.abs(i-j) == Math.abs(q[i]-q[j]))
					return false;
			}
		}
		return true;
	}
	public static void nqueens1(int n) {
		int[] q = new int[4];
		for(int q0 = 0; q0 < 4; ++q0) {
			for(int q1 = 0; q1 < 4; ++q1) {
				for(int q2 = 0; q2 < 4; ++q2) {
					for(int q3 = 0; q3 < 4; ++q3) {
						q[0] = q0; q[1] = q1; q[2] = q2; q[3] = q3;
						if(isValid(q)) {
							System.out.println(q0 + " " + q1 + " " + q2 + " " + q3);
						}
					}
				}
			}
		}
	}
	
	private static void auxqueens2(int q, int n, int[] out) {
		if(q == n) {
			if(isValid(out)) {
				System.out.println(Arrays.toString(out));
			}
			return;
		}
		for(int c = 0; c < n; ++c) {
			out[q] = c;
			auxqueens2(q+1, n, out);
		}
	}
	
	public static void nqueens2(int n) {
		int[] out = new int[n];
		auxqueens2(0, n, out);
	}
	
	private static boolean isValidPosition(int q, int c, int[] out) {
		for(int i = 0; i < q; ++i) {
				if(c == out[i]) return false;
				if(Math.abs(i-q) == Math.abs(out[i]-c))
					return false;
		}
		//Write hueristic logic
		return true;
	}
	private static void auxqueens3(int q, int n, int[] out) {
		if(q == n) {
			if(isValid(out)) {
				System.out.println(Arrays.toString(out));
			}
			return;
		}
		for(int c = 0; c < n; ++c) {
			if(isValidPosition(q, c, out)) {
				out[q] = c;
				auxqueens3(q+1, n, out);
			}
		}
	}
	
	public static void nqueens3(int n) {
		int[] out = new int[n];
		auxqueens3(0, n, out);
	}
	public static void main(String[] args) {
		nqueens3(Integer.parseInt(args[0]));
	}

}
