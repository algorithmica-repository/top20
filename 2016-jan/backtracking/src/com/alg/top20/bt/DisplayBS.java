package com.alg.top20.bt;

import java.util.Arrays;

public class DisplayBS {

	private static void auxBS(int d, int n, int[] out) {
		if(d == n) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int i = 0; i <= 9; ++i) {
			out[d] = i;
			auxBS(d+1, n, out);
		}
	}
	public static void displayBS(int n) {
		int[] out = new int[n];
		auxBS(0, n, out);
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		displayBS(n);
	}

}
