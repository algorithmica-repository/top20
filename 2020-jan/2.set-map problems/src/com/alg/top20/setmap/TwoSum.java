package com.alg.top20.setmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class TwoSum {

	// TC:O(n^2) SC:O(1)
	public static boolean twoSum1(int[] in, int s) {
		for (int i = 0; i < in.length; ++i) {
			int tmp = s - in[i];
			for (int j = i + 1; j < in.length; ++j)
				if (tmp == in[j])
					return true;
		}
		return false;
	}

	// TC:O(n log n) SC:O(1)
	public static boolean twoSum2(int[] in, int s) {
		Arrays.sort(in);
		for (int i = 0; i < in.length; ++i) {
			int tmp = s - in[i];
			if (Arrays.binarySearch(in, i + 1, in.length, tmp) >= 0)
				return true;
		}
		return false;
	}

	// TC:O(n)am SC:O(n)
	public static boolean twoSum3(int[] in, int s) {
		HashSet<Integer> hset = new HashSet<Integer>();
		for (int i = 0; i < in.length; ++i) {
			int tmp = s - in[i];
			if (hset.contains(tmp))
				return true;
			hset.add(in[i]);
		}
		return false;
	}

	public static int testCase1(int[] in) {
		Random r = new Random();
		for (int i = 0; i < in.length; ++i)
			in[i] = r.nextInt(100) + 1;
		return r.nextInt(100);
	}

	public static int testCase2(int[] in) {
		Random r = new Random();
		for (int i = 0; i < in.length; ++i)
			in[i] = r.nextInt(100) + 1;
		return 0;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		int s = testCase2(in);
		//System.out.println(Arrays.toString(in));
		//System.out.println(s);
		long start = System.currentTimeMillis();
		System.out.println(twoSum2(in, s));
		//System.out.println(twoSum2(in, s));
		//System.out.println(twoSum3(in, s));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000.0 + "secs");

	}

};