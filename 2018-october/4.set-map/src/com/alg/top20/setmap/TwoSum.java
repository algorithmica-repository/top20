package com.alg.top20.setmap;

import java.util.Arrays;
import java.util.HashSet;

public class TwoSum {

	//TC:O(n ^ 2)  SC:O(1)
	public static boolean twoSum1(int[] in, int s) {
		for(int i = 0; i < in.length-1; ++i) {
			int tmp = s - in[i]; 
			for(int j = i+1; j < in.length; ++j) 
				if(in[j] == tmp) return true;
		}
		return false;
	}
	
	//TC:O(n log n)  SC:O(1)
	public static boolean twoSum2(int[] in, int s) {
		Arrays.sort(in);
		for(int i = 0; i < in.length-1; ++i) {
			int tmp = s - in[i]; 
			if(Arrays.binarySearch(in, i+1, in.length-1, tmp) >= 0) return true;
		}
		return false;
	}
	
	//TC:O(n)  SC:O(n)
	public static boolean twoSum3(int[] in, int s) {
		HashSet<Integer> hset = new HashSet<Integer>();
		for(int i = 0; i < in.length-1; ++i) {
			int tmp = s - in[i]; 
			if(hset.contains(tmp)) return true;
			else hset.add(in[i]);
		}
		return false;
	}
	//TC:O(n log n)  SC:O(1)
	public static boolean twoSum4(int[] in, int s) {
		Arrays.sort(in);
		int i = 0, j = in.length-1;
		while(i < j) {
			if(in[i] + in[j] == s) return true;
			if(in[i] + in[j] < s) ++i;
			else --j;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
