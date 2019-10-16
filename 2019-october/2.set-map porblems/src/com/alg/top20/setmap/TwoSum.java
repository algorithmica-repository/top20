package com.alg.top20.setmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class TwoSum {

	public static boolean twoSum1(int[] in, int s) {
		for (int i = 0; i < in.length - 1; ++i) {
			for (int j = i + 1; j < in.length; ++j) {
				if (in[j] == s - in[i])
					return true;
			}
		}
		return false;
	}
	
	public static boolean twoSum2(int[] in, int s) {
		Arrays.parallelSort(in);
		for (int i = 0; i < in.length - 1; ++i) {
			int ret = Arrays.binarySearch(in, i+1, in.length, s-in[i]);
			if(ret >= 0) return true;			
		}
		return false;
	}
	
	public static boolean twoSum31(int[] in, int s) {
		HashSet<Integer> hset = new HashSet<Integer>();
		for (int i = 0; i < in.length; ++i) {
			if(hset.contains(s-in[i]))	return true;
			hset.add(in[i]);
		}
		return false;
	}
	
	public static boolean twoSum32(int[] in, int s) {
		TreeSet<Integer> tset = new TreeSet<Integer>();
		for (int i = 0; i < in.length; ++i) {
			if(tset.contains(s-in[i]))	return true;
			tset.add(in[i]);
		}
		return false;
	}
	
	public static int[] testCase1(int n) {
		int[] in = new int[n];
		Random r = new Random(0);
		for(int i = 0; i < n; ++i)
			in[i] = r.nextInt(100)+1;
		return in;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = testCase1(n);
		int s = 0;
		//System.out.println(Arrays.toString(in));
		//System.out.println(s);
		long start = System.currentTimeMillis();
		System.out.println(twoSum31(in, s));
		long end = System.currentTimeMillis();
		System.out.println("Time taken:" + (end-start)/1000.0 + "secs");

	}

}
