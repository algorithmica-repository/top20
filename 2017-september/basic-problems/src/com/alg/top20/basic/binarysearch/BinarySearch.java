package com.alg.top20.basic.binarysearch;

public class BinarySearch {

	public static int binarySearch(int[] in, int target) {
		int l = 0, r = in.length - 1;
		while (l <= r) {
			int m = (l + r) / 2; // fix the bug
			if (in[m] == target)
				return m;
			if (target < in[m])
				r = m - 1;
			else
				l = m + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		for(int i = 0; i < n; ++i)
			in[i] = i+1;
		//System.out.println(Arrays.toString(in));
		int target = n/2;
		//System.out.println(target);
		System.out.println(binarySearch(in, target));
	}

}
