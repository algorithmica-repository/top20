package com.alg.top20.bt.nqueens;

import java.util.Arrays;

public class Nqueens {

	private static boolean isValid1(int i, int j, int k, int l) {
		return true;
	}
	public static void nqueens1(int n) {
		for(int i = 0; i < 4; ++i) {
			for(int j = 0; j < 4; ++j) {
				for(int k = 0; k < 4; ++k) {
					for(int l = 0; l < 4; ++l) {
						if(isValid1(i,j,k,l))
							System.out.println(i + "" + j + "" + k + "" + l);
					}
				}
			}
		}
	}
	
	//TC:O(n ^ n+2)
	//SC:O(n)
	//Recursion 
	public static void nqueens2(int n) {
		int[] out = new int[n];
		auxqueens2(0, n, out);
	}
	public static boolean isValid2(int[] out) {
		for(int i = 0; i < out.length; ++i) {
			for(int j = i+1; j < out.length; ++j) {
				if(out[i] == out[j] || Math.abs(i-j) == Math.abs(out[i]-out[j])) 
					return false;
			}
		}
		return true;
	}
	private static void auxqueens2(int d, int n, int[] out) {
		if(d == n) {
			if(isValid2(out))
				System.out.println(Arrays.toString(out));
			return;
		}
		for(int c = 0; c < n; ++c) {
			out[d] = c;
			auxqueens2(d+1, n, out);
		}
	}
	
	//TC:O(n ^ n+2)
	//SC:O(n)
	//Backtracking: Recursion + branch pruning
	public static void nqueens3(int n) {
		int[] out = new int[n];
		auxqueens3(0, n, out);
	}
	public static boolean isValid3(int[] out, int cq, int cc) {
		for(int q = 0; q < cq; ++q) {
				if(out[q] == cc || Math.abs(cq-q) == Math.abs(out[q]-cc)) 
					return false;
		}
		return true;
	}
	private static void auxqueens3(int d, int n, int[] out) {
		if(d == n) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int c = 0; c < n; ++c) {
			if(isValid3(out, d, c)) {
				out[d] = c;
				auxqueens3(d+1, n, out);
			}
		}
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		nqueens3(n);
	}

}
