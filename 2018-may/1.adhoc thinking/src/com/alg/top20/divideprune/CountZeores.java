package com.alg.top20.divideprune;
public class CountZeores {

	public static int countZeroes(int[] in) {
		int l = 0, r = in.length - 1;
		// bug: (l+r)/2
		// alternatives: l + (r-l)/2, l + (r-l)>>>1
		while (r - l > 1) {
			int m = l + (r - l) / 2;
			if (in[m] == 0)
				l = m;
			else
				r = m - 1;
		}
		if(in[r] == 0) return r+1;
		return l+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
