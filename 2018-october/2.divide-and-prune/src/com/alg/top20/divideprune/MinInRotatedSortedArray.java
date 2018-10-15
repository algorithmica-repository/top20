package com.alg.top20.divideprune;

public class MinInRotatedSortedArray {

	//TC:O(n)  SC:O(1)
	public static int findMin1(int[] in) {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < in.length; ++i) {
			if(in[i] < min)
				min = in[i];
		}
		return min;
	}
	//TC:O(log n)  SC:O(1)
	public static int findMin2(int[] in) {
		int l = 0, r = in.length - 1;
		int m;
		while (l < r) {
			m = (l + r) / 2;
			if (in[m] >  in[r])
				l = m+1;
			else
				r = m;
		}
		return in[l];		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
