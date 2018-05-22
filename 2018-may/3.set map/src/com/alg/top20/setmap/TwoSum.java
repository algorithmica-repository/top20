package com.alg.top20.setmap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class TwoSum {

	public static boolean twoSum1(int[] in, int s) {
		for (int i = 0; i < in.length - 1; ++i) {
			for (int j = i + 1; j < in.length; ++j) {
				if (s - in[i] == in[j])
					return true;
			}
		}
		return false;
	}

	public static boolean twoSum21(int[] in, int s) {
		Arrays.sort(in);
		for (int i = 0; i < in.length - 1; ++i) {
			if (Arrays.binarySearch(in, i + 1, in.length - 1, s - in[i]) >= 0)
				return true;
		}
		return false;
	}

	public static boolean twoSum22(int[] in, int s) {
		Arrays.sort(in);
		int start = 0, end = in.length - 1;
		while (start < end) {
			if (in[start] + in[end] == s)
				return true;
			if (in[start] + in[end] < s)
				++start;
			else
				--end;
		}
		return false;
	}

	public static boolean twoSum3(int[] in, int s) {
		HashSet<Integer> hset = new HashSet<Integer>();
		for (int i = 0; i < in.length; ++i) {
			if (hset.contains(s - in[i]))
				return true;
			hset.add(in[i]);
		}
		return false;
	}

	public static void main(String[] args) {
		//test case1
		int n = Integer.parseInt(args[0]);
		int s = Integer.parseInt(args[1]);
		int[] in = new int[n];
		Random r = new Random();
		for(int i = 0; i < n; ++i)
			in[i] = r.nextInt(n)+1;
		boolean debug = Boolean.parseBoolean(args[2]);
		if(debug == true)
			System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		System.out.println(twoSum3(in, s));
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000.0 + " seconds");
		
	}

}
