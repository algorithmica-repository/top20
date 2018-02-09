package com.alg.top20.divideprune;


public class CountOnes {

	public static int countOnes(int[] in) {
		int left = 0, right = in.length - 1;
		if (in.length == 0 ||
				in[left] == 0)
			return 0;
		while (left < right) {
			int mid = (int) Math.ceil(left + (right - left) >>> 1);
			if (in[mid] == 1)
				left = mid;
			else
				right = mid - 1;
		}
		return right + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
