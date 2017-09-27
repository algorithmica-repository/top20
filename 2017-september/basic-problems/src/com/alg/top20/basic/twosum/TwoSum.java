package com.alg.top20.basic.twosum;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class TwoSum {

	public static boolean twoSum1(int[] in, int s) {
		for (int i = 0; i < in.length - 1; ++i) {
			int tmp = s - in[i];
			for (int j = i + 1; j < in.length; ++j) {
				if (in[j] == tmp)
					return true;
			}
		}
		return false;
	}

	public static boolean twoSum2(int[] in, int s) {
		for (int i = 0; i < in.length - 1; ++i) {
			int tmp = s - in[i];
			if (Arrays.binarySearch(in, i + 1, in.length - 1, tmp) >= 0)
				return true;
		}
		return false;
	}

	public static boolean twoSum3(int[] in, int s) {
		int i = 0;
		int j = in.length - 1;
		while (i < j) {
			if (in[i] + in[j] == s)
				return true;
			if (in[i] + in[j] < s)
				++i;
			else
				--j;
		}
		return false;
	}
	
	public static boolean twoSum4(int[] in, int s) {
		HashSet<Integer> hset = new HashSet<Integer>();
		for (int i = 0; i < in.length - 1; ++i) {
			int tmp = s - in[i];
			if (hset.contains(tmp))
				return true;
			else
				hset.add(in[i]);
		}
		return false;
	}


	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; ++i)
			in[i] = r.nextInt(n) + 1;
		// System.out.println(Arrays.toString(in));
		Arrays.sort(in);
		// System.out.println(Arrays.toString(in));
		// System.out.println(n);
		long start = System.currentTimeMillis();
		//System.out.println(twoSum3(in, 0));
		System.out.println(twoSum4(in, 0));
		long end = System.currentTimeMillis();
		System.out.println("Time taken:" + (end - start) / 1000.0 + " seconds");

	}

}
