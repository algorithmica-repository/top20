package com.alg.top20.adhoc;

import java.util.Arrays;
import java.util.HashSet;

public class FindDuplicate {

	//TC:O(n^2) SC:O(1)
	public static int findDuplicate1(int[] in) {
		for (int i = 0; i < in.length - 1; ++i) {
			for (int j = i + 1; j < in.length; ++j)
				if (in[i] == in[j])
					return in[i];
		}
		return Integer.MIN_VALUE;
	}
	//TC:O(n log n)   SC:O(1)
	public static int findDuplicate2(int[] in) {
		Arrays.sort(in);		
		for (int i = 1; i < in.length; ++i)
			if(in[i] == in[i-1]) return in[i];
		return Integer.MIN_VALUE;
	}
	
	//TC:O(n)   SC:O(n)
	public static int findDuplicate3(int[] in) {
		HashSet<Integer> hset = new HashSet<Integer>();
		for (int i = 0; i < in.length; ++i) {
			boolean res = hset.add(in[i]);
			if(res == false) return in[i];
		}
		return Integer.MIN_VALUE;
	}
	
	//TC:O(n)    SC:O(1)
	public static int findDuplicate4(int[] in) {
		for (int i = 0; i < in.length; ++i) {
			int val = Math.abs(in[i]);
			if(in[val] < 0) return val;
			in[val] *= -1;
		}
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		//test case 1
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		int i;
		for(i = 0; i < n-1; ++i)
			in[i] = n-1-i;
		in[i] = n-1;
		//System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		System.out.println(findDuplicate4(in));
		long end = System.currentTimeMillis();
		System.out.println("Time taken:" + (end-start)/1000.0 + "secs");

	}

}
;