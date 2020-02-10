package com.alg.top20.array;

import java.util.Arrays;
import java.util.Random;

public class Ceil {

	public static int ceil1(int[] in, int x) {
		for (int i = 0; i < in.length; ++i)
			if (in[i] >= x)
				return in[i];
		return Integer.MAX_VALUE;
	}

	public static int ceil2(int[] in, int x) {
		int l = 0, r = in.length - 1;
		while (l < r) {
			int m = (l + r) / 2;
			if (in[m] == x)
				return in[m];
			if (in[m] < x)
				l = m + 1;
			else
				r = m;
		}
		if (in[l] >= x)
			return in[l];
		return Integer.MAX_VALUE;
	}

	public static int testCase1(int[] in) {
		Random r = new Random();
		for (int i = 0; i < in.length; ++i)
			in[i] = r.nextInt(100) + 1;
		Arrays.sort(in);
		return r.nextInt(100) + 10;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		int x = testCase1(in);
		//System.out.println(Arrays.toString(in));
		System.out.println(x);
		long start = System.currentTimeMillis();
		System.out.println(ceil2(in, x));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000.0 + "secs");

	}

}
