package com.alg.top20.divideprune;

public class CountZeroes {

	//TC:O(n)  SC:O(1)
	public static int countZeros1(int[] in) {
		int i;
		for(i = 0; i < in.length; ++i)
			if(in[i] != 0) break;
		return i;
	}

	//TC:O(log n)  SC:O(1)
	public static int countZeros2(int[] in) {
		int l = 0, r = in.length - 1;
		int m;
		while (r - l > 1) {
			m = (l + r) / 2;
			if (in[m] == 0)
				l = m;
			else
				r = m - 1;
		}
		if (in[r] == 0)
			return r + 1;
		if(in[l] == 0)
			return l + 1;
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
