package com.alg.top20.array;

public class MinInRotSortedArray {

	// TC:O(n) SC:O(1)
	public static int findMin1(int[] in) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < in.length; ++i) {
			if (in[i] < min)
				min = in[i];
		}
		return min;
	}

	// TC:O(log n) SC:O(1)
	public static int findMin2(int[] in) {
		int l = 0, r = in.length - 1;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (in[m] < in[r])
				r = m;
			else
				l = m + 1;
		}
		return in[l];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
