package com.alg.top20.divideprune;


public class MinInRotatedSortedArray {

	public static int findMin(int[] in) {
		int left = 0, right = in.length - 1;
		
		while (left < right) {
			int mid = left + (right - left) >>> 1;
			if (in[mid] > in[right])
				left = mid + 1;
			else
				right = mid;
		}
		return in[right];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
