package com.alg.top20.adhoc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class TwoSum {

	public static boolean twoSum1(int[] in, int target) {
		for (int i = 0; i < in.length; ++i) {
			for (int j = i + 1; j < in.length; ++j) {
				if (in[j] == target - in[i])
					return true;
			}
		}
		return false;
	}

	// sort + binary search
	public static boolean twoSum2(int[] in, int target) {
		Arrays.sort(in);
		for (int i = 0; i < in.length; ++i) {
			if (Arrays.binarySearch(in, i + 1, in.length, target - in[i]) >= 0)
				return true;
		}
		return false;
	}

	// sort + 2-pointer approach
	public static boolean twoSum3(int[] in, int target) {
		Arrays.sort(in);
		int left = 0, right = in.length - 1;

		while (left < right) {
			if (in[left] + in[right] == target)
				return true;
			if (in[left] + in[right] < target)
				++left;
			else
				--right;
		}
		return false;
	}
	
	// DS based - hashset
	public static boolean twoSum4(int[] in, int target) {
		HashSet<Integer> hset = new HashSet<Integer>();
		for (int i = 0; i < in.length; ++i) {
			if (hset.contains(target-in[i]))
				return true;
			hset.add(in[i]);
		}
		return false;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		//testcase1
		Random r = new Random();
		for(int i = 0; i < in.length; ++i)
			in[i] = r.nextInt(3*n) + 1;
		int target = 0;
		//System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		System.out.println(twoSum4(in, target));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end-start)/1000.0 +"seconds");

	}

}
