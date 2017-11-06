package com.alg.top20.dp;

import java.util.Arrays;
import java.util.Random;

public class MaximumSum {

	//TC:O(2 ^ n)
	//SC:O(n)
	//Recursion
	public static int findMaxSum1(int[] in) {
		return auxMaxSum1(in.length, in);
	}
	private static int auxMaxSum1(int i, int[] in) {
		if(i < 1) return 0;
		int inclSum = auxMaxSum1(i-2, in) + in[i-1];
		int exclSum = auxMaxSum1(i-1, in);
		return Math.max(inclSum, exclSum);
	}
	//TC:O(n)
	//SC:O(n)
	//Memoization
	public static int findMaxSum2(int[] in) {
		int[] mem = new int[in.length+1];
		return auxMaxSum2(in.length, in, mem);
	}
	private static int auxMaxSum2(int i, int[] in, int[] mem) {
		if(i < 1) return 0;
		if(mem[i] != 0) return mem[i];
		int inclSum = auxMaxSum2(i-2, in, mem) + in[i-1];
		int exclSum = auxMaxSum2(i-1, in, mem);
		mem[i] = Math.max(inclSum, exclSum);
		return mem[i];
	}
	
	//TC:O(n)
	//SC:O(n)
	//dynamic programming
	public static int findMaxSum3(int[] in) {
		int[] mem = new int[in.length+1];
		mem[0] = 0;
		mem[1] = Math.max(0, in[0]);
		for(int i = 2; i <= in.length; ++i) {
			int inclSum = mem[i-2] + in[i-1];
			int exclSum = mem[i-1];
			mem[i] = Math.max(inclSum, exclSum);
		}
		//System.out.println(getSequence());
		return mem[in.length];	
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random(100);
		int[] in = new int[n];
		for(int i = 0; i < n; ++i)
			in[i] = r.nextInt(n) + 1;
		//System.out.println(Arrays.toString(in));
		System.out.println(findMaxSum3(in));
	}

}
