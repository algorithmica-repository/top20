package com.alg.top20.bt.TernarySequence;

import java.util.Arrays;

public class TernarySequence {

	// It doesnt work for arbitrary n since we need to generate n for loops at
	// runtime
	public static void ternarySeq1(int n) {
		for (int i = 0; i <= 2; ++i) {
			for (int j = 0; j <= 2; ++j) {
				for (int k = 0; k <= 2; ++k) {
					for(int l = 0; l <= 2; ++l) {
						System.out.println(i + " " + j + " " + k + " " + l);
					}
				}
			}
		}
	}

	private static void auxternarySeq2(int d, int n, int[] out) {
		if (d == n) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for (int i = 0; i < 3; ++i) {
			out[d] = i;
			auxternarySeq2(d + 1, n, out);
		}
	}
	
	public static void ternarySeq2(int n) {
		int[] out = new int[n];
		auxternarySeq2(0, n, out);
	}

	public static void main(String[] args) {
		ternarySeq2(Integer.parseInt(args[0]));
	}

}
