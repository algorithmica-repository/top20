package com.alg.top20.array;

import java.util.Arrays;

public class FindDuplicate {

	//TC:O(n ^ 2)  SC:O(1)
	public static int findDuplicate1(int[] in) {
		for (int i = 0; i < in.length - 1; ++i) {
			for (int j = i + 1; j < in.length; ++j) {
				if (in[i] == in[j])
					return in[i];
			}
		}
		return -1;
	}
	
	//TC:O(n log n)  SC:O(1)
	public static int findDuplicate2(int[] in) {
		Arrays.sort(in);
		for (int i = 1; i < in.length; ++i) 
			if(in[i] == in[i-1]) return in[i];
		return -1;
	}
	//TC:O(n)  SC:O(n)
	public static int findDuplicate3(int[] in) {
		boolean[] lookup = new boolean[in.length];
		for (int i = 0; i < in.length; ++i) {
			if(lookup[in[i]] == true) return in[i];
			lookup[in[i]] = true;
		}
		return -1;
	}
	
	//TC:O(n)  SC:O(1)
	public static int findDuplicate4(int[] in) {
		for (int i = 0; i < in.length; ++i) {
			int element = Math.abs(in[i]);
			if(in[element] < 0) return in[i];
			in[element] *= -1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		int i;
		for(i = 0; i < n-1; ++i)
			in[i] = n - (i+1);
		in[i] = i;
		//System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		System.out.println(findDuplicate4(in));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end-start)/1000.0 + "secs");
	}

}
