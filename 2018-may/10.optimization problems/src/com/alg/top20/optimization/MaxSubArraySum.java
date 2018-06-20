package com.alg.top20.optimization;

public class MaxSubArraySum {

	//Naive approach TC: O(n^2) SC:O(1) 
	public static int maxSum1(int[] in) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < in.length; ++i) {
			int ssum = 0;
			for(int j = i; j >= 0; --j) {
				ssum += in[j];
				max = Math.max(max, ssum);
			}
		}
		return max;
	}
	
	//Recursive Approach
	public static int maxSum2(int[] in) {
		int gmax = Integer.MIN_VALUE;
		for(int i = 1; i <= in.length; ++i)
			gmax = Math.max(gmax, sumEnding2(i, in));
		return gmax;
	}
	private static int sumEnding2(int i, int[] in) {
		if(i == 0) return 0;
		if(i == 1) return in[0];
		int tmp = sumEnding2(i-1, in) + in[i-1];
		return Math.max(tmp, in[i-1]);
	}
	
	//memory filling with recursion
	public static int maxSum3(int[] in) {
		int gmax = Integer.MIN_VALUE;
		int[] mem = new int[in.length+1];
		for(int i = 1; i <= in.length; ++i)
			gmax = Math.max(gmax, sumEnding3(i, in, mem));
		return gmax;
	}
	private static int sumEnding3(int i, int[] in, int[] mem) {
		if(i == 0) return 0;
		if(i == 1) return in[0];
		if(mem[i] != 0) return mem[i];
		int tmp = sumEnding3(i-1, in, mem) + in[i-1];
		mem[i] = Math.max(tmp, in[i-1]);
		return mem[i];
	}
	//memory filling without recursion
	public static int maxSum4(int[] in) {
		int max = Integer.MIN_VALUE;
		int[] mem = new int[in.length+1];
		mem[1] = in[0];
		for(int i = 2; i <= in.length; ++i) {
				mem[i] = Math.max(mem[i-1] + in[i-1], in[i-1]);
				max = Math.max(max, mem[i]);
		}
		//getOptimalPath(mem, in);
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
