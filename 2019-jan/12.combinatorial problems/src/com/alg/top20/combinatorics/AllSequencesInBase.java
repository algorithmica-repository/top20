package com.alg.top20.combinatorics;

import java.util.Arrays;

public class AllSequencesInBase {

	public static void allSeq1(int n, int b) {
		for(int i = 0; i < b; ++i) {
			for(int j = 0; j < b; ++j) {
				for(int k = 0; k < b; ++k) {
					System.out.println(i + " " + j + " " + k);
				}
			}
		}
	}
	
	public static void allSeq2(int n, int b) {
		int[] out = new int[n];
		auxSeq2(0, n, b, out);
	}
	private static void auxSeq2(int d, int n, int b, int[] out) {
		if(d == n) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int i = 0; i < b; ++i) {
			out[d] = i;
			auxSeq2(d+1, n, b, out);
		}
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		allSeq2(n, b);
	}

}
