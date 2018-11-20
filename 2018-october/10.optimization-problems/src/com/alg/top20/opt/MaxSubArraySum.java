package com.alg.top20.opt;

public class MaxSubArraySum {

	//naive approach
	public static int maxSubarraySum1(int[] in) {
		int max = 0;
		for(int i = in.length-1; i >= 0; --i)  {
			int csum = 0;
			for(int j = i; j >= 0; --j) {
				csum += in[j];
				max = Math.max(max, csum);
			}
		}
		return max;
	}
	
	//recursion
	public static int maxSubarraySum2(int[] in) {
		int max = 0;
		for(int i = 1; i <= in.length; ++i) 
			max = Math.max(max, auxSubarraySum2(i, in));
		return max;
	}
	private static int auxSubarraySum2(int i, int[] in) {
		if(i == 0) return 0;
		return Math.max(auxSubarraySum2(i-1, in), 0)  + in[i-1];
	}
	
	//memoization
	public static int maxSubarraySum3(int[] in) {
		int max = 0;
		int[] mem = new int[in.length+1];
		for(int i = 0; i <= in.length; ++i)
			mem[i] = Integer.MIN_VALUE;
		for(int i = in.length; i >= 1; --i) 
			max = Math.max(max, auxSubarraySum3(i, in, mem));
		return max;
	}
	private static int auxSubarraySum3(int i, int[] in, int[] mem) {
		if(i == 0) return 0;
		if(mem[i] != Integer.MIN_VALUE) return mem[i];
		mem[i] = Math.max(auxSubarraySum2(i-1, in), 0)  + in[i-1];
		return mem[i];
	}
	
	//dynamic programming
	public static int maxSubarraySum4(int[] in) {
		int max = 0;
		int[] mem = new int[in.length+1];
		mem[0] = 0;
		for(int i = 1; i <= in.length; ++i) {
			mem[i] = Math.max(0, mem[i-1]) + in[i-1];
			max = Math.max(max, mem[i]);
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
