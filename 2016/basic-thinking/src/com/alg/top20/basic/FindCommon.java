package com.alg.top20.basic;

import java.util.Arrays;
import java.util.HashSet;

public class FindCommon {

	public static int findCommon1(int[] input1, int[] input2) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for (Integer e : input1) {
			hs.add(e);
		}
		int ncommon = 0;
		for (Integer e : input2) {
			if (hs.contains(e))
				++ncommon;
		}
		return ncommon;
	}
	
	public static int findCommon2(int[] input1, int[] input2) {
		Arrays.sort(input1);
		int ncommon = 0;
		for (int e : input2) {
			if(Arrays.binarySearch(input1, e) >= 0)
				++ncommon;
		}
		return ncommon;
	}

	public static void main(String[] args) {
		int[] a = { 5, 8, 2, 1};		
		int[] b = {10,5,8,20,30};
		System.out.println(findCommon2(a, b));

	}

}
