package com.alg.top20.setmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class TwoSum {

	//TC:O(n ^ 2)   SC:O(1)
	public static boolean twoSum1(int[] in, int target) {
		for(int i = 1; i < in.length; ++i) {
			for(int j = 0; j < i; ++j) {
				if(target-in[i] == in[j])
					return true;
			}
		}
		return false;
	}
	//TC:O(n log n)   SC:O(1)
	public static boolean twoSum2(int[] in, int target) {
		Arrays.sort(in);
		for(int i = 1; i < in.length; ++i) {
			if(Arrays.binarySearch(in, 0, i, target-in[i]) >= 0)
					return true;
		}
		return false;
	}
	
	//TC:O(n)   SC:O(n)
	public static boolean twoSum3(int[] in, int target) {
		HashSet<Integer> hset = new HashSet<Integer>();
		hset.add(in[0]);
		for(int i = 1; i < in.length; ++i) {
			if(hset.contains(target-in[i]))
					return true;
			hset.add(in[i]);
		}
		return false;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random(100);
		for(int i  = 0; i < n; ++i)
			in[i] = r.nextInt(n)+1;
		int target = 0;
		//System.out.println(Arrays.toString(in));
		System.out.println(target);
		System.out.println(twoSum1(in, target));
		System.out.println(twoSum2(in, target));
		System.out.println(twoSum3(in, target));

	}

}
