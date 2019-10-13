package com.alg.top20.array;

import java.util.Arrays;

public class GridSearch {

	public static boolean search1(int[][] in, int x) {
		for (int i = 0; i < in.length; ++i) {
			for (int j = 0; j < in.length; ++j) {
				if (in[i][j] == x)
					return true;
			}
		}
		return false;
	}

	public static boolean search2(int[][] in, int x) {
		for (int i = 0; i < in.length; ++i) {
			if (Arrays.binarySearch(in[i], x) >= 0)
				return true;
		}
		return false;
	}

	public static boolean search3(int[][] in, int x) {
		int r = 0, c = in.length - 1;
		while (r < in.length && c >= 0) {
			if (in[r][c] == x)
				return true;
			if (x < in[r][c])
				--c;
			else
				++r;
		}
		return false;
	}

	private static int upper_bound(int[][] in, int x) {
		return 0;
	}

	public static boolean search41(int[][] in, int x) {
		int r = upper_bound(in, x);
		if (Arrays.binarySearch(in[r], x) >= 0)
			return true;
		return false;
	}

	public static boolean search42(int[][] in, int x) {
		int left = 0, right = in.length * in.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			int tmp = in[mid / in.length][mid % in.length];
			if (tmp == x)
				return true;
			if (x < tmp)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return false;
	}
	
	public static int[][] testcase1(int n) {
		int k = 0;
		int[][] in = new int[n][n];
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				in[i][j] = ++k;
			}
		}
		return in;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = testcase1(n);
		//int x = (n-1) * n + 1;
		int x = n * n + 1;
		//for(int[] tmp: in)
		//	System.out.println(Arrays.toString(tmp));
		System.out.println(x);
		System.out.println(search1(in, x));
		System.out.println(search2(in, x));
		System.out.println(search3(in, x));
		System.out.println(search42(in, x));
	}

}
