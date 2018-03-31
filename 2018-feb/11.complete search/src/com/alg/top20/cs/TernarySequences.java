package com.alg.top20.cs;

import java.util.Arrays;

public class TernarySequences {

	public static void ternarySeq1(int n) {
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				for(int k = 0; k < 3; ++k) {
					System.out.println(i + "," + j + "," + k);
				}
			}
		}
	}
	public static void ternarySeq2(int n) {
		int[] out = new int[n];
		auxTernarySeq(0, n, out);
	}
	private static void auxTernarySeq(int d, int n, int[] out) {
		if(d == n) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int i = 0; i < 3; ++i) {
			out[d] = i;
			auxTernarySeq(d+1, n, out);
		}
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ternarySeq2(n);
	}

}
