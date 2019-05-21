package com.alg.top20.basic;

import java.util.Arrays;

public class GridSearch {

	// time:O(n ^ 2) space:O(1)
	public static boolean search1(int[][] in, int x) {
		int n = in.length;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (in[i][j] == x)
					return true;
			}
		}
		return false;
	}

	// time:O(n log n) space:O(1)
	public static boolean search2(int[][] in, int x) {
		int n = in.length;
		for (int i = 0; i < n; ++i) {
			if (Arrays.binarySearch(in[i], x) >= 0)
				return true;
		}
		return false;
	}

	private static int ceil(int[][] in, int x) {
		return 0;
	}
	// time:O(log n) space:O(1)
	public static boolean search3(int[][] in, int x) {
	    int r = ceil(in, x);
		return Arrays.binarySearch(in[r], x) >= 0;
	}
	// time:O(log n) space:O(1)
	public static boolean search4(int[][] in, int x) {
		int n = in.length;
		int l = 0, r = n * n - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;
			int element = in[m / n][m % n];
			if (x == element)
				return true;
			if (x < element)
				r = m - 1;
			else
				l = m + 1;
		}
		return false;
	}

	public static int[][] testcase1(int n) {
		int k = 1;
		int[][] in = new int[n][n];
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				in[i][j] = k++;
			}
		}
		return in;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = testcase1(n);
		//for(int[] tmp:in)
			//System.out.println(Arrays.toString(tmp));
		System.out.println(search1(in, n*n));
	}

}
