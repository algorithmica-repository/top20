package com.alg.top20.array;

import java.util.Arrays;
import java.util.Random;

public class MatrixSearch {

	// TC:O(n ^2) SC:O(1)
	public static boolean search1(long[][] in, long x) {
		for (int i = 0; i < in.length; ++i) {
			for (int j = 0; j < in.length; ++j) {
				if (in[i][j] == x)
					return true;
			}
		}
		return false;
	}

	// TC:O(n log n) SC:O(1)
	public static boolean search2(long[][] in, long x) {
		for (int i = 0; i < in.length; ++i) {
			if (Arrays.binarySearch(in[i], x) >= 0)
				return true;
		}
		return false;
	}

	private static int findCandidateRow(long[][] in, long x) {
		int l = 0, r = in.length - 1;
		while (l < r) {
			int m = (l + r) / 2;
			long tmp = in[m][in.length - 1];
			if (tmp == x)
				return m;
			if (tmp < x)
				l = m + 1;
			else
				r = m;
		}
		if (in[l][in.length - 1] >= x)
			return l;
		return Integer.MAX_VALUE;
	}

	// TC:O(log n) SC:O(1)
	public static boolean search3(long[][] in, long x) {
		int r = findCandidateRow(in, x);
		//System.out.println(r);
		if (r == Integer.MAX_VALUE)
			return false;
		if (Arrays.binarySearch(in[r], x) >= 0)
			return true;
		return false;
	}

	// TC:O(log n) SC:O(1)
	public static boolean search4(long[][] in, long x) {
		int l = 0, r = in.length * in.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			long tmp = in[m / in.length][m % in.length];
			if (tmp == x)
				return true;
			if (x < tmp)
				r = m - 1;
			else
				l = m + 1;
		}
		return false;
	}

	public static long testCase1(long[][] in) {
		long k = 1;
		for (int i = 0; i < in.length; ++i)
			for (int j = 0; j < in.length; ++j)
				in[i][j] = k++;
		return new Random().nextLong();
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		long[][] in = new long[n][n];
		long x = testCase1(in);
		//for (long[] tmp : in)
		//	System.out.println(Arrays.toString(tmp));
		//System.out.println(x);
		long start = System.currentTimeMillis();
		System.out.println(search3(in, x));
		// System.out.println(search2(in, x));
		// System.out.println(search4(in, x));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000.0 + "secs");
	}

}
