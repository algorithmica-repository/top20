package com.alg.top20.divideprune;

public class MinInRotatedSortedArray {

	public static int findMin1(int[] in) {
		int l = 0;
		int r = in.length - 1;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (in[m] > in[r])
				l = m + 1;
			else
				r = m;
		}
		return in[l];
	}
}
