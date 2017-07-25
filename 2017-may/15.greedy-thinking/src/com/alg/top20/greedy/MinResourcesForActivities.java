package com.alg.top20.greedy;

import java.util.Arrays;

public class MinResourcesForActivities {

	//TC:O(n ^ 2)   SC:O(1)
	public static int findMinResources1(int[] start, int[] end) {
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < start.length; ++i) {
			int x = start[i];
			int count = 0;
			for (int j = 0; j < start.length; ++j) {
				if (start[j] <= x && end[j] >= x)
					++count;
			}
			res = Math.max(res, count);
		}
		return res;
	}

	//TC:O(n log n)   SC:O(1)
	public static int findMinResources2(int[] start, int[] end) {
		Arrays.sort(start);
		Arrays.sort(end);
		int i = 0, j = 0;
		int count = 0, res = Integer.MIN_VALUE;
		while (i < start.length) {
			if (start[i] < end[j]) {
				++count;
				++i;
				res = Math.max(res, count);
			} else if (end[j] < start[i]) {
				--count;
				++j;
			} else {
				++i;
				++j;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
