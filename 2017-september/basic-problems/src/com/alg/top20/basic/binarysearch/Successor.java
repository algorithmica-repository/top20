package com.alg.top20.basic.binarysearch;

public class Successor {

	public static int findSuccessor(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		if(target > nums[r]) return r+1;
		while (l < r) {
			int m = (l + r) / 2; 
			if (nums[m] == target)
				return m;
			if (target < nums[m])
				r = m;
			else
				l = m + 1;
		}
		return l;
	}
}
