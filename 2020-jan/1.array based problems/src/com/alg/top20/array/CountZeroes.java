package com.alg.top20.array;

import java.util.Random;

public class CountZeroes {

	public static int countZeroes1(int[] in) {
		int i;
		for (i = 0; i < in.length; ++i) {
			if (in[i] != 0)
				break;
		}
		return i;
	}

	public static int countZeroes2(int[] in) {
		int l = 0, r = in.length - 1;
		while (r - l > 1) {
			int m = (l + r) / 2;
			if (in[m] == 0)
				l = m;
			else
				r = m - 1;
		}
		if (in[r] == 0)
			return r + 1;
		return l + 1;
	}

	public static void testCase1(int[] in) {
		Random r = new Random();
		int nzeros = r.nextInt(in.length);
		int i;
		for (i = 0; i < nzeros; ++i)
			in[i] = 0;
		while (i < in.length)
			in[i++] = r.nextInt(100) + 1;
	}

	public static void testCase2(int[] in) {
		for (int i = 0; i < in.length; ++i)
			in[i] = 0;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		testCase2(in);
		// System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		System.out.println(countZeroes2(in));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000.0 + "secs");

		// System.out.println(countZeroes2(in));
	}

}
