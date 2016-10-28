package com.alg.top20.bt;

import java.util.Arrays;

public class Nqueens {
	
	private static boolean attacking1(int[] out) {
		for(int i = 0; i < out.length; ++i) {
			for(int j = i+1; j < out.length; ++j) {
				if( (out[i] == out[j]) || Math.abs(j - i) == Math.abs(out[j] - out[i])) return true;
			}
		}
		return false;
	}

	private static void auxnqueens1(int d, int n, int[] out) {
		if(d == n) {
			if(!attacking1(out))
			   System.out.println(Arrays.toString(out));
			return;
		}
		for(int c = 0; c < n; ++c) {
			out[d] = c;
			auxnqueens1(d+1, n, out);
		}
	}
	public static void nqueens1(int n) {
		int[] out = new int[n];
		auxnqueens1(0,n,out);
	}
	
	private static boolean isvalid(int cq, int cc,int[] out) {
		for(int q = 0; q < cq; ++q) {
				if( (out[q] == cc) || Math.abs(cq - q) == Math.abs(cc - out[q])) return false;
		}
		return true;
	}

	private static void auxnqueens2(int d, int n, int[] out) {
		if(d == n) {
		   System.out.println(Arrays.toString(out));
		   return;
		}
		for(int c = 0; c < n; ++c) {
			if(isvalid(d,c,out)) {
				out[d] = c;
				auxnqueens2(d+1, n, out);
			}
		}
	}
	public static void nqueens2(int n) {
		int[] out = new int[n];
		auxnqueens2(0,n,out);
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		nqueens2(n);

	}

}
