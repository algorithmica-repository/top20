package com.alg.top20.basic;

import java.util.Arrays;
import java.util.HashSet;

public class Intersection {

	public static int findCommon1(int[] in1, int[] in2) {
		int common = 0;
		// n^2 comparisons
		for (int i = 0; i < in1.length; ++i) {
			for (int j = 0; j < in2.length; ++j) {
				if (in1[i] == in2[j])
					++common;
			}
		}
		return common;
	}

	public static int findCommon2(int[] in1, int[] in2) {
		int common = 0;
		// n log n
		Arrays.sort(in2);

		// n log n
		for (int i = 0; i < in1.length; ++i) {
			if (Arrays.binarySearch(in2, in1[i]) >= 0)
				++common;
		}
		return common;
	}

	public static int findCommon3(int[] in1, int[] in2) {
		HashSet<Integer> hs = new HashSet<Integer>();

		// n * c
		for (int i = 0; i < in2.length; ++i) {
			hs.add(in2[i]);
		}
		int common = 0;

		// n * c
		for (int i = 0; i < in1.length; ++i) {
			if (hs.contains(in1[i]))
				++common;
		}
		return common;
	}

	public static int findCommon4(int[] in1, int[] in2) {
		int common = 0;
		// n log n
		Arrays.sort(in2);
		// n log n
		Arrays.sort(in1);

		// <= (2n - 1)
		int i = 0, j = 0;
		while (i < in1.length && j < in2.length) {
			if (in1[i] == in2[j]) {
				++common;
				++i;
				++j;
			} else if (in1[i] < in2[j]) {
				++i;
			} else {
				++j;
			}
		}
		return common;
	}

	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		int[] in1 = new int[size];
		int[] in2 = new int[size];

		for (int i = 0; i < size; ++i) {
			in1[i] = i;
			in2[i] = i + size;
		}
		long start = System.currentTimeMillis();
		System.out.println(findCommon1(in1, in2));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start)/1000.0 + " Seconds");

	}

}
