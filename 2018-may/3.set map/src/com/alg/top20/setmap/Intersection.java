package com.alg.top20.setmap;
import java.util.Arrays;
import java.util.HashSet;

public class Intersection {

	public static int findCommon1(int[] in1, int[] in2) {
		int m = in1.length;
		int n = in2.length;
		int ncommon = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (in1[i] == in2[j])
					++ncommon;
			}
		}
		return ncommon;
	}

	public static int findCommon2(int[] in1, int[] in2) {
		int m = in1.length;
		Arrays.sort(in2);
		int ncommon = 0;
		for (int i = 0; i < m; ++i) {
			if (Arrays.binarySearch(in2, in1[i]) >= 0)
				++ncommon;
		}
		return ncommon;
	}

	public static int findCommon3(int[] in1, int[] in2) {
		int m = in1.length;
		int n = in2.length;
		Arrays.sort(in1);
		Arrays.sort(in2);
		int ncommon = 0;
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (in1[i] == in2[j]) {
				++ncommon;
				++i;
				++j;
			} else if (in1[i] < in2[j]) {
				++i;
			} else {
				++j;
			}
		}
		return ncommon;
	}
	
	public static int findCommon4(int[] in1, int[] in2) {
		int m = in1.length;
		int n = in2.length;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < n; ++i)
			set.add(in2[i]);
		int ncommon = 0;
		for (int i = 0; i < m; ++i) {
			if (set.contains(in1[i]))
				++ncommon;
		}
		return ncommon;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
