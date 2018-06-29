package com.alg.top20.bt;
import java.util.Arrays;


public class Nqueens {

	private static boolean isValid1(int[] out) {
		for(int i = 0; i < out.length; ++i) {
			for(int j = i+1; j < out.length; ++j) {
				if(out[i] == out[j] || Math.abs(i-j) == Math.abs(out[i]-out[j]) )
					return false;
			}
		}
		return true;
	}
	public static void nqueens1(int n) {
		int[] out = new int[n];
		auxqueens1(0, n, out);
	}
	private static void auxqueens1(int d, int n, int[] out) {
		if(d == n) {
			if(isValid1(out)) 
				System.out.println(Arrays.toString(out));
			return;
		}
		for(int c = 0; c < n; ++c) {
			out[d] = c;
			auxqueens1(d+1, n, out);
		}
	}
	
	private static boolean isValid2(int[] out, int d, int c) {
		for(int i = 0; i < d; ++i) {
			if(out[i] == c || Math.abs(i-d) == Math.abs(out[i]-c) )
					return false;
		}
		return true;
	}
	public static void nqueens2(int n) {
		int[] out = new int[n];
		auxqueens2(0, n, out);
	}
	private static void auxqueens2(int d, int n, int[] out) {
		if(d == n) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int c = 0; c < n; ++c) {
			if(isValid2(out, d, c)) {
				out[d] = c;
				auxqueens2(d+1, n, out);
			}
		}
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		nqueens2(n);
	}

}
