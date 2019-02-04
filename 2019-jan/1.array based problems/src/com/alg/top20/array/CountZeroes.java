package com.alg.top20.array;

import java.util.Random;

public class CountZeroes {

	public static int countZeroes1(int[] in) {
		int i;
		for (i = 0; i < in.length; ++i)
			if (in[i] != 0)
				break;
		return i;
	}

	public static int countZeroes2(int[] in) {
		int left = 0, right = in.length - 1;
		while (right - left > 1) {
			int middle = (left + right) / 2;
			if (in[middle] == 0)
				left = middle;
			else
				right = middle - 1;
		}
		if (in[right] == 0)
			return right + 1;
		return left + 1;
	}

	public static void testCase1(int[] in) {
		int n = in.length;
		Random r = new Random();
		int nzeroes = r.nextInt(n)+1;
		for(int i = 0; i < nzeroes; ++i)
			in[i] = 0;
		for(int i = nzeroes; i < n; ++i)
			in[i] = r.nextInt(n) + 1;
		//System.out.println(Arrays.toString(in));
		System.out.println(countZeroes1(in));
		System.out.println(countZeroes2(in));
	}
	public static void testCase2(int[] in) {
		System.out.println(countZeroes1(in));
		System.out.println(countZeroes2(in));
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		testCase2(in);
	}

}
